package com.github.polyKA.kawasakiControlLibrary.commands.position

import com.github.polyKA.kawasakiControlLibrary.commands.position.positionArray.Position

class PositionOnPlan {
    private val linkedHashMap: LinkedHashMap<String, Position> = linkedMapOf()

    fun addPosition(name: String, position: Position){
        linkedHashMap[name] = position
    }

    fun getPosition(name: String) = linkedHashMap[name]
}