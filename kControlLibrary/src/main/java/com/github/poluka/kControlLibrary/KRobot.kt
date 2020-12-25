package com.github.poluka.kControlLibrary

import com.github.art241111.tcpClient.Client
import com.github.art241111.tcpClient.connection.Status
import com.github.poluka.kControlLibrary.actions.Command
import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot
import com.github.poluka.kControlLibrary.dsl.Program
import com.github.poluka.kControlLibrary.dsl.runWithAction
import com.github.poluka.kControlLibrary.sender.SenderForRobot
import com.github.poluka.kControlLibrary.enity.position.Position
import com.github.poluka.kControlLibrary.handlers.PositionHandler

class KRobot {
    private val client = Client()
    private val sender = SenderForRobot(client.getSender())
    private val positionHandler = PositionHandler()

    fun setPositionObserver(observer: ((Position) -> Unit)) =
        positionHandler.setPositionObserver(observer)


    fun setConnectRobotStatusObserver(observer: ((Status) -> Unit))
            =  client.setStatusObserver(observer)

    var homePosition = Position(0.0,515.0,242.0,90.0,180.0,0.0)

    fun run(@ExecutedOnTheRobot command: Command){
        sender.safeSend(command.run())
    }

    fun run(@ExecutedOnTheRobot program: Program){
       program.runWithAction{ command ->
           sender.safeSend(command.run())
       }
    }

    fun connect(address: String, port: Int){
        client.connect(address, port)
        setPositionHandler()
        sender.startSending()
    }

    fun disconnect(){
        client.disconnect()
        sender.stopSending()
    }

    private fun setPositionHandler(){
        client.addHandlers(
            listOf(positionHandler, sender.programStatusHandler)
        )
    }
}