package com.example.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        val intent:Intent = getIntent()
        val radios:RadioGroup = findViewById(R.id.languages)
        val button:Button = findViewById(R.id.button)
        button.setOnClickListener(){
            intent.putExtra("actualLanguage", radios.checkedRadioButtonId.toString())
            finish()
        }
    }
}
