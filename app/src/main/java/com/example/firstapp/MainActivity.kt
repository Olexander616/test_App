package com.example.firstapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var sharePref : SharedPreferences
    private val key_for_number: String = "key_for_number"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharePref = getSharedPreferences("myFile", MODE_PRIVATE)
        Log.d("MyTag", "onCreate")
        val myButtonMinus = findViewById<Button>(R.id.MyButtonMinus)
        val myButton = findViewById<Button>(R.id.MyButton)
        //myButton.text = "Sum plus 1"
        val myText = findViewById<TextView>(R.id.myTextView)
        var counter = getNumber()
        myText.text = counter.toString()
        myButton.setOnClickListener{
           //Log.d("MyTag", "Click button")
            counter+=1
            myText.text = counter.toString()
            saveNumber(counter)
        }
        myButtonMinus.setOnClickListener{
            //Log.d("MyTag", "Click button")
            counter-=1
            myText.text = counter.toString()
            saveNumber(counter)

        }

    }

   private fun saveNumber(number: Int) {
        val editor = sharePref.edit()
        editor.putInt(key_for_number, number)
        editor.commit()
    }

   private fun getNumber(): Int{
        return sharePref.getInt(key_for_number, 0)
    }

    // SharedPreference - ключ значення
    // Database -база данних. Таблиця і залежності між ними
    // File
}