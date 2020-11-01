package com.github.poluka.kControlLibrary

import com.github.art241111.tcpClient.Client
import com.github.art241111.tcpClient.writer.Sender
import com.github.poluka.kControlLibrary.actions.Command
import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot
import com.github.poluka.kControlLibrary.actions.delay.Delay
import com.github.poluka.kControlLibrary.actions.program.Program
import com.github.poluka.kControlLibrary.enity.position.Position
import com.github.poluka.kControlLibrary.handlers.PositionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class KRobot {
    private val client = Client()
    private val sender: Sender = client.getSender()
    private val positionHandler = PositionHandler()

    val position = positionHandler.getPosition()
    val statusRobot = client.getConnectStatus()

    var homePosition = Position(0.0,515.0,242.0,90.0,180.0,0.0)

    fun run(@ExecutedOnTheRobot command: Command){
        sender.send(command.run())
    }

    fun run(@ExecutedOnTheRobot program: Program){
        program.forEach {
            this.run(it)
        }
    }

    fun connect(address: String, port: Int){
        client.connect(address, port, 300L)
        setPositionHandler()
    }

    fun disconnect(){
        client.disconnect()
    }

    private fun setPositionHandler(){
        client.addHandlers(
            listOf(positionHandler)
        )
    }
}