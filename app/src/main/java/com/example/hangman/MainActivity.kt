package com.example.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var stringArray: Array<String>
    val MAX_MISTAKES = 10
    val wordToFind = ""
    val usedLetters:CharArray = charArrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stringArray = resources.getStringArray(R.array.words)
        val hangmanView:ImageView = findViewById(R.id.hangmanView)
    }
    fun getRandomWord():String{
        val number = (0..stringArray.size).random()
        return stringArray[number]
    }
}