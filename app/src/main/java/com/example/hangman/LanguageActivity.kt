package com.example.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class LanguageActivity : AppCompatActivity() {
    lateinit var numberFormat: String
    override fun onCreate(savedInstanceState: Bundle?) {
        numberFormat = intent.getStringExtra(getString(R.string.numberFormatKey)) ?: "English"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        when(numberFormat){
            "English" -> findViewById<RadioButton>(R.id.English).isChecked = true
            "Polish" -> findViewById<RadioButton>(R.id.Polish).isChecked = true
            else -> findViewById<RadioButton>(R.id.English).isChecked = true
        }
        val button:Button = findViewById(R.id.button)
        button.setOnClickListener(){
            applyChanges()
            finish()

        }
    }

    private fun applyChanges() {
        val returnIntent = Intent()
        if(findViewById<RadioButton>(R.id.English).isChecked) {
            returnIntent.putExtra(getString(R.string.numberFormatKey), "English")
        } else {
            returnIntent.putExtra(getString(R.string.numberFormatKey), "Polish")
        }
        setResult(RESULT_OK,returnIntent)
    }
}
