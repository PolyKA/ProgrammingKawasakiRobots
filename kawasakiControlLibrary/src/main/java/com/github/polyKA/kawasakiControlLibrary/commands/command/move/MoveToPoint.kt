package com.github.polyKA.kawasakiControlLibrary.commands.command.move

import com.github.art241111.tcpClient.writer.Sender
import com.github.polyKA.kawasakiControlLibrary.commands.MoveCommand
import com.github.polyKA.kawasakiControlLibrary.commands.command.implementation.Command
import com.github.polyKA.kawasakiControlLibrary.commands.position.positionArray.Position

class MoveToPoint(private val typeOfMovement: TypeOfMovement = TypeOfMovement.LMOVE,
                  private val position: Position): Command {

    override fun run(sender: Sender) {
        sender.send("${MoveCommand.MOVE_TO_POINT.command}$typeOfMovement;$position")
    }
}