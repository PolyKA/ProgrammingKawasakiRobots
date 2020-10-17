package com.github.polyKA.kawasakiControlLibrary

import com.github.art241111.tcpClient.Client
import com.github.polyKA.kawasakiControlLibrary.commands.Move
import com.github.polyKA.kawasakiControlLibrary.handlers.PositionHandler


class KawasakiRobot {
    private val client = Client()
    private val positionHandler = PositionHandler()

    val position = positionHandler.getPosition()
    val statusRobot = client.getConnectStatus()

    val move = Move(client.getSender())

    fun connect(address: String, port: Int){
        client.connect(address, port)
        setPositionHandler()
    }

    fun disconnect(){
        client.disconnect()
    }

    fun sendCommand(command: String){
        client.send(command)
    }

    private fun setPositionHandler(){
        client.addHandlers(
            listOf(positionHandler)
        )
    }
}