package com.github.poluka.kControlLibrary.actions.move

import com.github.poluka.kControlLibrary.actions.Command
import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot
import com.github.poluka.kControlLibrary.enity.position.Position

private const val MOVE_BY_C = "CMOVE"

@ExecutedOnTheRobot
class MoveC(private val positionOnArc: Position,
            private val endPosition: Position):Command {


    override fun run(): String = "$MOVE_BY_C;$positionOnArc;$endPosition"
}