package com.example.randomixer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mixButton = findViewById<Button>(R.id.mix_button)
        mixButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            val randomArray = ArrayRandom.randomFieldIntArray(ArrayRandom.randomNumbOfElem()) //using Singleton
            intent.putExtra("array",randomArray)
            startActivity(intent)
            Empty.setEmpty(1)
        }

        val arrayObserver = ArrayObserver()
        arrayObserver.addUser(User("first_observer"))
        arrayObserver.updateArray()
    }
}