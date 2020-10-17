package com.github.polyKA.kawasakiControlLibrary.commands

import com.github.art241111.tcpClient.writer.SenderImp

class Move(private val sender: SenderImp) {
    /**
     * Moving the robot along the x coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByX(position: Int) =
            sender.send(MoveCommand.MOVE_BY_X.command + position)

    /**
     * Moving the robot along the y coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByY(position: Double) =
            sender.send(MoveCommand.MOVE_BY_Y.command + position)

    /**
     * Moving the robot along the z coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByZ(position: Double) =
            sender.send(MoveCommand.MOVE_BY_Z.command + position)

    /**
     * Moving the robot along the dx coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByDX(position: Double) =
            sender.send(MoveCommand.MOVE_BY_DX.command + position)

    /**
     * Moving the robot along the dy coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByDY(position: Double) =
            sender.send(MoveCommand.MOVE_BY_DY.command + position)

    /**
     * Moving the robot along the dz coordinate.
     * @param position - the distance to be moved.
     */
    fun moveByDZ(position: Double) =
            sender.send(MoveCommand.MOVE_BY_DZ.command + position)

    /**
     * Closing the robot's grip
     */
    fun closeGripper() =
            sender.send(MoveCommand.CLOSE_GRIPPER.command)

    /**
     * Open the robot's grip
     */
    fun openGripper() =
            sender.send(MoveCommand.OPEN_GRIPPER.command)

    /**
     * Move to the desired point
     * @param position - the distance to be moved.
     */
    fun moveToPoint(typeOfMovement: String, position: String) =
            sender.send("${MoveCommand.MOVE_TO_POINT.command}$typeOfMovement;$position")
}