package com.github.polyKA.kawasakiControlLibrary.commands.command.implementation

import com.github.art241111.tcpClient.writer.Sender

interface Command {
    fun run(sender: Sender)
}