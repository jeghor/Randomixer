package com.example.randomixer

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val LAUNCH_CODE = 1

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mixButton = findViewById<Button>(R.id.mix_button)
        mixButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            val randomArray = ArrayRandom.randomFieldIntArray(ArrayRandom.randomNumbOfElem()) //using Singleton
            intent.putExtra("array",randomArray)
            startActivityForResult(intent, LAUNCH_CODE)
            Empty.setEmpty(1)
        }

        val arrayObserver = ArrayObserver()
        arrayObserver.addUser(User("first_observer"))
        arrayObserver.updateArray()
    }

    @SuppressLint("SetTextI18n")
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== LAUNCH_CODE){
            if (resultCode == Activity.RESULT_OK){
                val cal1Text = findViewById<TextView>(R.id.calc_1)
                cal1Text.text = "average = ${data?.getStringExtra("average")}"
                val cal2Text = findViewById<TextView>(R.id.calc_2)
                cal2Text.text = "summary = ${data?.getStringExtra("sum")}"
                val cal3Text = findViewById<TextView>(R.id.calc_3)
                cal3Text.text = "split by two = ${data?.getStringExtra("split")}"
            }
        }
    }
}