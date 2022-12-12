package com.example.randomixer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mixButton = findViewById<Button>(R.id.mix_button)

        mixButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            val randomArray = IntArray(randomNumbOfElem())
            var counter = 0
            while (counter< randomArray.size){
                randomArray[counter] = Random.nextInt(500)
                counter++
            }
            intent.putExtra("array",randomArray)
            startActivity(intent)
        }
    }
}

fun randomNumbOfElem(): Int {
    var elCount = Random.nextInt(26)
    while(elCount%2!= 0){
        elCount = Random.nextInt(26)
    }
    return elCount
}