package com.github.poluka.kControlLibrary.actions.gripper

import com.github.poluka.kControlLibrary.actions.Command
import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot

private const val CLOSE_GRIPPER = "SERVICE;CLAMP;OFF"

@ExecutedOnTheRobot
 class CloseGripper: Command {
    override fun run(): String = CLOSE_GRIPPER
}