package com.github.poluka.kControlLibrary.actions.delay

import com.github.poluka.kControlLibrary.actions.Command

data class Delay(val delayTime: Long): Command {
    override fun run(): String = "Delay:$delayTime"
}