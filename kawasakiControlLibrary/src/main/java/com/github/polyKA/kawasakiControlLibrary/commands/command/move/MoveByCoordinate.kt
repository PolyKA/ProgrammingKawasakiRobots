package com.github.polyKA.kawasakiControlLibrary.commands.command.move

import com.github.art241111.tcpClient.writer.Sender
import com.github.polyKA.kawasakiControlLibrary.commands.MoveCommand
import com.github.polyKA.kawasakiControlLibrary.commands.command.implementation.Command
import com.github.polyKA.kawasakiControlLibrary.coordinates.Coordinate

/**
 * Moving a certain distance on one axis.
 * @param coordinate - coordinates that are used for moving,
 * @param distance - the distance to which the movement takes place.
 */
class MoveByCoordinate(private val coordinate: Coordinate,
                       private val distance: Double): Command {

    /**
     * Start program.
     * @param sender - sender for sending a message.
     */
    override fun run(sender: Sender) {
        sender.send(MoveCommand.MOVE_BY_COORDINATE.command
                + (coordinate.ordinal + 1)
                + ";"
                + distance)
    }
}