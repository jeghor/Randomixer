package com.example.randomixer

import android.util.Log

const val TAG_1 = "State of array"

class User(val name: String): ArrayBehavior {
    override fun arrayState() {
        if (Empty.getEmpty()==0){
            Log.e(TAG_1, "is empty")
        } else {
            Log.e(TAG_1, "is NOT empty")
        }
    }
}