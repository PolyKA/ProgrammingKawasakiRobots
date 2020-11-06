package com.github.polyKA.kawasakiControlLibrary.commands.position.positionArray

import com.github.polyKA.kawasakiControlLibrary.coordinates.Coordinate

fun Position.positionArrayFromString(text: String): Position {
        val text2= text.substringAfter(";").substringBeforeLast(";")

        val position = getDoubleArrayFromString(text2)

        this[Coordinate.X]  = position[0]
        this[Coordinate.Y]  = position[1]
        this[Coordinate.Z]  = position[2]
        this[Coordinate.DX] = position[3]
        this[Coordinate.DY] = position[4]
        this[Coordinate.DZ] = position[5]

        return this
    }

    private fun getDoubleArrayFromString(position: String):MutableList<Double>
            = position.split(";")
            .map{value ->
                String.format("%.2f",value.trim().toDouble())
                        .replace(",",".")
                        .toDouble()
            } as MutableList<Double>
