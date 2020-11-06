package com.github.polyKA.kawasakiControlLibrary.commands.position

import com.github.polyKA.kawasakiControlLibrary.commands.position.positionArray.Position

class HomePosition {
    var position: Position = Position(0.0,0.0,0.0,0.0,0.0, 0.0)
    private set

    fun setHomePosition(x: Double, y: Double, z: Double, dx: Double, dy: Double, dz: Double){
        position = Position(x,y,z,dx, dy, dz)
    }
}