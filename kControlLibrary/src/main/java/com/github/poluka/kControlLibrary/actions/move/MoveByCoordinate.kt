package com.github.poluka.kControlLibrary.actions.move

import com.github.poluka.kControlLibrary.actions.Command
import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot
import com.github.poluka.kControlLibrary.actions.delay.Delay
import com.github.poluka.kControlLibrary.dsl.Program
import com.github.poluka.kControlLibrary.enity.Coordinate

private const val MOVE_BY_COORDINATE = "MOVE;BASE"

/**
 * Moving a certain distance on one axis.
 * @param coordinate - coordinates that are used for moving,
 * @param distance - the distance to which the movement takes place.
 */
@ExecutedOnTheRobot
data class MoveByCoordinate(private val coordinate: Coordinate,
                                     private val distance: Double): Command {

    /**
     * Start program.
     */
    override fun run(): String {
        // Create array with six zero
        val arrayMoving = Array(6) { 0.0 }
        arrayMoving[coordinate.ordinal + 1] = distance
        "$MOVE_BY_COORDINATE;${arrayMoving.joinToString(separator = ";")}"
        return "$MOVE_BY_COORDINATE;${(coordinate.ordinal + 1)};$distance"
    }
}

fun Program.moveByCoordinate(coordinate: Coordinate, distance: Double)
        = doWithCommand(MoveByCoordinate(coordinate, distance))