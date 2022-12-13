package com.example.randomixer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val averageTextView = findViewById<TextView>(R.id.average_text)
        val sumTextView = findViewById<TextView>(R.id.sum_all_text)
        val splitTextView = findViewById<TextView>(R.id.split_set_text)
        val allNumbersTextView = findViewById<TextView>(R.id.all_numbers)

        val array = intent.getIntArrayExtra("array") as IntArray

        averageTextView.text = averageOfNumbers(array).toString()
        sumTextView.text = summaryOfAll(array).toString()
        splitTextView.text = splitByTwo(array).toString()
        allNumbersTextView.text = outputNumbers(array) //array.contentToString()
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