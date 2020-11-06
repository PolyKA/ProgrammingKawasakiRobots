package com.github.polyKA.kawasakiControlLibrary.commands

import com.github.art241111.tcpClient.writer.Sender
import com.github.polyKA.kawasakiControlLibrary.commands.command.gripper.CloseGripper
import com.github.polyKA.kawasakiControlLibrary.commands.command.move.MoveByCoordinate
import com.github.polyKA.kawasakiControlLibrary.commands.command.gripper.OpenGripper
import com.github.polyKA.kawasakiControlLibrary.coordinates.Coordinate

class Move(private val sender: Sender) {
    /**
     * Moving the robot along the x coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByX(position: Double) = MoveByCoordinate(Coordinate.X, position).run(sender)

    /**
     * Moving the robot along the y coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByY(position: Double) = MoveByCoordinate(Coordinate.Y, position).run(sender)

    /**
     * Moving the robot along the z coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByZ(position: Double) = MoveByCoordinate(Coordinate.Z, position).run(sender)

    /**
     * Moving the robot along the dx coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByDX(position: Double) = MoveByCoordinate(Coordinate.DX, position).run(sender)

    /**
     * Moving the robot along the dy coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByDY(position: Double) = MoveByCoordinate(Coordinate.DY, position).run(sender)

    /**
     * Moving the robot along the dz coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByDZ(position: Double) = MoveByCoordinate(Coordinate.DZ, position).run(sender)

    /**
     * Closing the robot's grip
     */
    fun closeGripper() = CloseGripper().run(sender)

    /**
     * Open the robot's grip
     */
    fun openGripper() = OpenGripper().run(sender)

    /**
     * Move to the desired point
     * @param position - the distance to be moved.
     */
//    fun moveToPoint(typeOfMovement: String, position: String) =
//            MoveToPoint(typeOfMovement, position).run(sender)


}