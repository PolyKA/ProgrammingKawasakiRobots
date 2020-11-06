package com.github.poluka.kControlLibrary.dsl

import com.github.poluka.kControlLibrary.actions.Command
import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot
import com.github.poluka.kControlLibrary.actions.delay.Delay
import com.github.poluka.kControlLibrary.actions.gripper.CloseGripper
import com.github.poluka.kControlLibrary.actions.gripper.OpenGripper
import com.github.poluka.kControlLibrary.actions.gripper.RotateGripper
import com.github.poluka.kControlLibrary.actions.move.DepartPoint
import com.github.poluka.kControlLibrary.actions.move.MoveByCoordinate
import com.github.poluka.kControlLibrary.actions.move.MoveC
import com.github.poluka.kControlLibrary.actions.move.MoveToPoint
import com.github.poluka.kControlLibrary.actions.program.Program
import com.github.poluka.kControlLibrary.enity.Coordinate
import com.github.poluka.kControlLibrary.enity.TypeOfMovement
import com.github.poluka.kControlLibrary.enity.position.Position

/**
 * DSL метод, за счет которого можно создавать свои программы.
 * @param commands - команды, которые нужно добавить в программу.
 */
fun kProgram(commands: Commands.() -> Unit) = Commands().apply(commands).commands

/**
 * Класс, который позволяет добавлять команды в програму.
 * @author artem241120@gmail.com (Artem Gerasimov)
 */
class Commands: AddCommandToProgram() {
    fun openGripper() = addCommand(OpenGripper())
    fun closeGripper() = addCommand(CloseGripper())

    fun moveByCoordinate(coordinate: Coordinate, distance: Double)
            = addCommand(MoveByCoordinate(coordinate, distance))

    fun moveToPoint(typeOfMovement: TypeOfMovement = TypeOfMovement.LMOVE, position: Position)
            = addCommand(MoveToPoint(typeOfMovement, position))

    fun moveByArc(positionOnArc: Position,
                         endPosition: Position)
                = addCommand(MoveC(positionOnArc, endPosition))

    fun departPoint(typeOfMovement: TypeOfMovement = TypeOfMovement.LMOVE, position: Position,
                    dX: Double  = 0.0, dY: Double = 0.0, dZ: Double = 0.0,
                    dO: Double  = 0.0, dA: Double = 0.0, dT: Double = 0.0)
            = addCommand(DepartPoint(typeOfMovement, position, dX, dY, dZ, dO, dA, dT))

    fun rotateGripper(angleOfRotation: Double) = addCommand(RotateGripper(angleOfRotation))

    fun delay(delayTime: Long) = addCommand(Delay(delayTime))

    operator fun invoke(command: Command) = add(command)

    /**
     * Если требуется добавить не реализованную команду или
     * сохраненную в переменную, то используйте add.
     * @param command - команда, которую требуется добавить в Program.
     */
    fun add(@ExecutedOnTheRobot command: Command) = addCommand(command)
    fun add(@ExecutedOnTheRobot command: Program) = addCommands(command.getAll())
}
