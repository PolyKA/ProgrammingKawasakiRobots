package com.github.poluka.kControlLibrary.handlers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.art241111.tcpClient.handlers.HandlerImp
import com.github.poluka.kControlLibrary.enity.position.Position
import com.github.poluka.kControlLibrary.enity.position.positionArrayFromString

class PositionHandler: HandlerImp {
    private val position: MutableLiveData<Position> = MutableLiveData()
    fun getPosition(): LiveData<Position> = position

    init {
        position.value = Position()
    }

    private var positionStr = ""

    override fun handle(text: String) {
        if(text.substringBefore(";").trim() == "POINT"){
            val newPosition = positionParsing(text)
            if(newPosition != null){
                position.postValue(newPosition)
            }
        }
    }

    private fun positionParsing(position: String): Position? =
        if(isNewValue(position)){
            Position().positionArrayFromString(positionStr)
        } else{
             null
        }

    private fun isNewValue(position: String): Boolean =
        if(positionStr == "" || positionStr != position){
            positionStr = position
            true
        } else false
}