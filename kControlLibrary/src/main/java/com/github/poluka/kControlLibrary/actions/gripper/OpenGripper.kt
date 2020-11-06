package com.github.poluka.kControlLibrary.actions.gripper

import com.github.poluka.kControlLibrary.actions.Command
import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot

private const val OPEN_GRIPPER = "SERVICE;CLAMP;ON"

@ExecutedOnTheRobot
class OpenGripper: Command {
    override fun run(): String = OPEN_GRIPPER
}