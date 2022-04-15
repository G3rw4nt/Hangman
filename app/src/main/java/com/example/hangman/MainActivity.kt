package com.example.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var stringArray: Array<String>
    val MAX_MISTAKES = 10
    var mistakes = 0
    var wordToFind:String = ""
    var gameOver:Boolean = true
    lateinit var word: StringBuilder
    lateinit var usedLetters: StringBuilder
    lateinit var usedLettersTv: TextView
    lateinit var wordToFindTv:TextView
    lateinit var gallows:ImageView
    lateinit var spinner: Spinner
    lateinit var spinnerValue:String
    lateinit var actualLanguage:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gallows = findViewById(R.id.hangmanView)
        gallows.setImageResource(R.drawable.hangman_gray)
        wordToFindTv = findViewById(R.id.word)
        usedLettersTv = findViewById(R.id.usedLetters)
        spinner = findViewById(R.id.difficultySpinner)
        stringArray = resources.getStringArray(R.array.words)
        actualLanguage = "English"
        val restart:FloatingActionButton = findViewById(R.id.restartButton)
        val a: Button = findViewById(R.id.a)
        val b: Button = findViewById(R.id.b)
        val c: Button = findViewById(R.id.c)
        val d: Button = findViewById(R.id.d)
        val e: Button = findViewById(R.id.e)
        val f: Button = findViewById(R.id.f)
        val g: Button = findViewById(R.id.g)
        val h: Button = findViewById(R.id.h)
        val i: Button = findViewById(R.id.i)
        val j: Button = findViewById(R.id.j)
        val k: Button = findViewById(R.id.k)
        val l: Button = findViewById(R.id.l)
        val m: Button = findViewById(R.id.m)
        val n: Button = findViewById(R.id.n)
        val o: Button = findViewById(R.id.o)
        val p: Button = findViewById(R.id.p)
        val q: Button = findViewById(R.id.q)
        val r: Button = findViewById(R.id.r)
        val s: Button = findViewById(R.id.s)
        val t: Button = findViewById(R.id.t)
        val u: Button = findViewById(R.id.u)
        val v: Button = findViewById(R.id.v)
        val w: Button = findViewById(R.id.w)
        val x: Button = findViewById(R.id.x)
        val y: Button = findViewById(R.id.y)
        val z: Button = findViewById(R.id.z)
        restart.setOnClickListener{newGame()}
        a.setOnClickListener{clickLetter('a')}
        b.setOnClickListener{clickLetter('b')}
        c.setOnClickListener{clickLetter('c')}
        d.setOnClickListener{clickLetter('d')}
        e.setOnClickListener{clickLetter('e')}
        f.setOnClickListener{clickLetter('f')}
        g.setOnClickListener{clickLetter('g')}
        h.setOnClickListener{clickLetter('h')}
        i.setOnClickListener{clickLetter('i')}
        j.setOnClickListener{clickLetter('j')}
        k.setOnClickListener{clickLetter('k')}
        l.setOnClickListener{clickLetter('l')}
        m.setOnClickListener{clickLetter('m')}
        n.setOnClickListener{clickLetter('n')}
        o.setOnClickListener{clickLetter('o')}
        p.setOnClickListener{clickLetter('p')}
        q.setOnClickListener{clickLetter('q')}
        r.setOnClickListener{clickLetter('r')}
        s.setOnClickListener{clickLetter('s')}
        t.setOnClickListener{clickLetter('t')}
        u.setOnClickListener{clickLetter('u')}
        v.setOnClickListener{clickLetter('v')}
        w.setOnClickListener{clickLetter('w')}
        x.setOnClickListener{clickLetter('x')}
        y.setOnClickListener{clickLetter('y')}
        z.setOnClickListener{clickLetter('z')}



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.languageSettings ->{
                val intent = Intent(this@MainActivity, LanguageActivity::class.java)
                actualLanguage = intent.getStringExtra("actualLanguage").toString()
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    fun updatePicture(mistakes:Int):Void?
    {
        when(mistakes){
            0 -> gallows.setImageResource(R.drawable.hangman0)
            1 -> gallows.setImageResource(R.drawable.hangman1)
            2 -> gallows.setImageResource(R.drawable.hangman2)
            3 -> gallows.setImageResource(R.drawable.hangman3)
            4 -> gallows.setImageResource(R.drawable.hangman4)
            5 -> gallows.setImageResource(R.drawable.hangman5)
            6 -> gallows.setImageResource(R.drawable.hangman6)
            7 -> gallows.setImageResource(R.drawable.hangman7)
            8 -> gallows.setImageResource(R.drawable.hangman8)
            9 -> gallows.setImageResource(R.drawable.hangman9)
            10 -> gallows.setImageResource(R.drawable.hangman10)
            else -> gallows.setImageResource(R.drawable.hangman_gray)

        }
        return null
    }
    fun getRandomWord(difficulty:String):String{
        lateinit var finalWord:String
        when(difficulty){
            "Easy" ->{
                var word:String = "template"
                while(word.length > 5){
                    word = stringArray[java.util.Random().nextInt(stringArray.size)]
                }
                finalWord = word
            }
            "Normal" ->{
                var word:String = "tmp"
                while(word.length <= 5 || word.length >= 10){
                    word = stringArray[java.util.Random().nextInt(stringArray.size)]
                }
                finalWord = word
            }
            "Hard" ->{
                var word:String = "temp"
                while(word.length < 10){
                    word = stringArray[java.util.Random().nextInt(stringArray.size)]
                }
                finalWord = word
            }
        }
        return finalWord
    }

    fun newGame():Void?
    {
        gameOver = false
        mistakes = 0
        spinnerValue = spinner.selectedItem.toString()
        wordToFind = getRandomWord(spinnerValue)
        word = java.lang.StringBuilder(wordToFind.length)
        usedLetters = java.lang.StringBuilder(26)
        word.append(wordToFind)
        for(i in word.indices)
        {
            word[i] = '_'
        }
        updatePicture(mistakes)
        wordToFindTv.text = word.toString()
        usedLettersTv.text = "Used Letters: "
        return null
    }

    fun isWordFound():Boolean{
        return wordToFind.contentEquals(word.toString())
    }

    fun letterCheck(c:Char):Void?{
        if(wordToFind.contains(c)){
            var index = wordToFind.indexOf(c)

            while (index >= 0){
                word[index] = c
                index = wordToFind.indexOf(c, index+1)
            }
            wordToFindTv.text = word.toString()
        }
        else{
            mistakes++
        }
        return null
    }

    fun clickLetter(c:Char):Void?{
        if(mistakes < MAX_MISTAKES && !gameOver && !usedLetters.contains(c))
        {
            usedLettersTv.text = usedLettersTv.text.toString()+c.toString()
            usedLetters.append(c)
            letterCheck(c)
            updatePicture(mistakes)

            if(isWordFound()){
                gameOver = true
                val alert = AlertDialog.Builder(this)
                alert.setTitle("You won!")
                alert.setMessage("The word was "+wordToFind)
                alert.setPositiveButton("Restart"){dialog, which->newGame()}
                alert.show()
            }
            else{
                if(mistakes >= MAX_MISTAKES){
                    gameOver = true
                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("You lost!")
                    alert.setMessage("The word was "+wordToFind)
                    alert.setPositiveButton("Restart"){dialog, which->newGame()}
                    alert.show()
                }
            }
        }
        return null
    }
}
