package com.example.randomixer

import java.util.LinkedList
import java.util.logging.Handler

class ArrayObserver() {
    private val users: MutableList<ArrayBehavior> =LinkedList()
    var arrayStateBoolean = true

    fun addUser(arrayBehavior: ArrayBehavior){
        users.add(arrayBehavior)
    }

    fun removeUser(arrayBehavior: ArrayBehavior){
        users.remove(arrayBehavior)
    }

    fun updateArray(){
        users.forEach {
            it.arrayState()
        }
        val handler = android.os.Handler()
        handler.postDelayed({
            updateArray()
        } ,2000)
    }
}