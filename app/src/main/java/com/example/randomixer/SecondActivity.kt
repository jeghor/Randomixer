package com.example.randomixer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

const val TAG = "Calculations"

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val averageTextView = findViewById<TextView>(R.id.average_text)
        val sumTextView = findViewById<TextView>(R.id.sum_all_text)
        val splitTextView = findViewById<TextView>(R.id.split_set_text)
        val allNumbersTextView = findViewById<TextView>(R.id.all_numbers)

        val array = intent.getIntArrayExtra("array") as IntArray
        Log.i(TAG,"--------------------New calculations--------------------")
        averageTextView.text = "${averageOfNumbers(array)}"
        Log.i(TAG,"Average number of array is ${averageOfNumbers(array)}")
        sumTextView.text = "${summaryOfAll(array)}"
        Log.i(TAG,"Summary of all numbers in array is ${summaryOfAll(array)}")
        splitTextView.text = "${splitByTwo(array)}"
        Log.i(TAG,"Split two parts in array by two is ${splitByTwo(array)}")
        allNumbersTextView.text = outputNumbers(array)
        Log.i(TAG,"Numbers in array: ${array.contentToString()}")
    }
}

private fun averageOfNumbers(array: IntArray): Int{
    var summary = 0
    for (element in array){
        summary+=element
    }
    return summary/array.size
}

private fun summaryOfAll(array: IntArray):Int{
    var summary = 0
    for (element in array) summary+=element
    return summary
}

private fun splitByTwo(array: IntArray):Int{
    val halfOfArray = array.size/2
    var sumFirstPart = 0
    var resSecondPart = 0
    var index = 0
    while (index<array.size){
        if (index<halfOfArray){
            sumFirstPart+=array[index]
            index++
        } else{
            resSecondPart+=array[index]
            index++
        }
    }
    return sumFirstPart/resSecondPart
}

private fun outputNumbers(array: IntArray):String{
    var numbersText = ""
    var counter = 0
    while (counter<array.size) {
        numbersText += "${array[counter]} "
        counter++
    }
    return numbersText
}