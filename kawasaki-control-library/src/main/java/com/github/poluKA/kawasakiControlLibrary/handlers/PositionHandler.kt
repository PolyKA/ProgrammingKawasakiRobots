package com.github.polyKA.kawasakiControlLibrary.handlers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.art241111.tcpClient.handlers.HandlerImp

class PositionArray(x: Double, y: Double, z: Double, dx: Double, dy: Double, dz: Double){
    val array: List<Double> = listOf(x, y, z, dx, dy, dz)

    companion object{
        fun positionArrayFromString(text: String): PositionArray {
            val text2= text.substringAfter(";").substringBeforeLast(";")

            val position = getDoubleArrayFromString(text2)
            return PositionArray(x = position[0],
                                 y = position[1],
                                 z = position[2],
                                 dx = position[3],
                                 dy = position[4],
                                 dz = position[5],
                                )
//            return PositionArray(0.0,0.0,0.0,0.0,0.0,0.0)
        }

        private fun getDoubleArrayFromString(position: String):MutableList<Double>
                = position.split(";")
            .map{value ->
                String.format("%.2f",value.trim().toDouble())
                    .replace(",",".")
                    .toDouble()
            } as MutableList<Double>
    }
}

class PositionHandler: HandlerImp {
    private val position: MutableLiveData<PositionArray> = MutableLiveData()
    fun getPosition(): LiveData<PositionArray> = position

    init {
        position.value = PositionArray(0.0,0.0,0.0,0.0,0.0,0.0)
    }

    private var positionStr = ""

    override fun handle(text: String) {
        val text2 = text
        if(text2.substringBefore(";").trim() == "POINT"){
            val newPosition = positionParsing(text)
            if(newPosition != null){
                position.postValue(newPosition)
            }
        }
    }

    private fun positionParsing(position: String): PositionArray? =
        if(isNewValue(position)){
            PositionArray.positionArrayFromString(positionStr)
        } else{
             null
        }

    private fun isNewValue(position: String): Boolean =
        if(positionStr == "" || positionStr != position){
            positionStr = position
            true
        } else false
}