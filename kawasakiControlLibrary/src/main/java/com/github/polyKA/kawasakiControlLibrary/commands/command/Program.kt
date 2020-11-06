package com.github.polyKA.kawasakiControlLibrary.commands.command

import com.github.art241111.tcpClient.writer.Sender
import com.github.polyKA.kawasakiControlLibrary.commands.command.implementation.Command
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Program: Command {
    val commands = mutableListOf<Command>()

    override fun run(sender: Sender) {
        if(commands.isNotEmpty()){
            GlobalScope.launch {
                commands.forEach {
                    it.run(sender)
                    delay(100L)
                }
            }
        }
    }
}