package com.github.poluka.kControlLibrary.actions.move

import com.github.poluka.kControlLibrary.actions.Command
import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot
import com.github.poluka.kControlLibrary.enity.Coordinate
import com.github.poluka.kControlLibrary.enity.TypeOfMovement
import com.github.poluka.kControlLibrary.enity.position.Position

@ExecutedOnTheRobot
data class DepartPoint(val typeOfMovement: TypeOfMovement = TypeOfMovement.LMOVE,
                       val position: Position,
                       val dX: Double = 0.0, val dY: Double = 0.0, val dZ: Double = 0.0,
                       val dO: Double = 0.0, val dA: Double = 0.0, val dT: Double = 0.0): Command {
    override fun run(): String {
        val newPosition = Position(
                x = position[Coordinate.X] + dX,
                y = position[Coordinate.Y] + dY,
                z = position[Coordinate.Z] + dZ,
                o = position[Coordinate.O] + dO,
                a = position[Coordinate.A] + dA,
                t = position[Coordinate.T] + dT)
        return MoveToPoint(typeOfMovement, newPosition).run()
    }
}