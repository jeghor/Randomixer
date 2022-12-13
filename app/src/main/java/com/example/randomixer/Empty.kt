package com.example.randomixer

object Empty {
    private var emptyInt: Int = 0
    @JvmStatic
    fun setEmpty(value: Int){
        emptyInt =value
    }
    @JvmStatic
    fun getEmpty():Int = emptyInt
}