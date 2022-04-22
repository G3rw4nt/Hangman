package com.example.hangman

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var stringArray: Array<String>
    val MAX_MISTAKES = 10
    var mistakes = 0
    var wordToFind:String = ""
    var gameOver:Boolean = true
    val REQUEST_CODE:Int = 1
    lateinit var word: StringBuilder
    lateinit var usedLetters: StringBuilder
    lateinit var usedLettersTv: TextView
    lateinit var wordToFindTv:TextView
    lateinit var gallows:ImageView
    lateinit var spinner: Spinner
    lateinit var spinnerValue:String
    lateinit var actualLanguage:String

    lateinit var  a: Button
    lateinit var  b: Button
    lateinit var  c: Button
    lateinit var  d: Button
    lateinit var  e: Button
    lateinit var  f: Button
    lateinit var  g: Button
    lateinit var  h: Button
    lateinit var  i: Button
    lateinit var  j: Button
    lateinit var  k: Button
    lateinit var  l: Button
    lateinit var  m: Button
    lateinit var  n: Button
    lateinit var  o: Button
    lateinit var  p: Button
    lateinit var  q: Button
    lateinit var  r: Button
    lateinit var  s: Button
    lateinit var  t: Button
    lateinit var  u: Button
    lateinit var  v: Button
    lateinit var  w: Button
    lateinit var  x: Button
    lateinit var  y: Button
    lateinit var  z: Button

    private var format: String = "English"


    fun colorReset():Void?
    {
        a.setBackgroundColor(Color.BLUE)
        b.setBackgroundColor(Color.BLUE)
        c.setBackgroundColor(Color.BLUE)
        d.setBackgroundColor(Color.BLUE)
        e.setBackgroundColor(Color.BLUE)
        f.setBackgroundColor(Color.BLUE)
        g.setBackgroundColor(Color.BLUE)
        h.setBackgroundColor(Color.BLUE)
        i.setBackgroundColor(Color.BLUE)
        j.setBackgroundColor(Color.BLUE)
        k.setBackgroundColor(Color.BLUE)
        l.setBackgroundColor(Color.BLUE)
        m.setBackgroundColor(Color.BLUE)
        n.setBackgroundColor(Color.BLUE)
        o.setBackgroundColor(Color.BLUE)
        p.setBackgroundColor(Color.BLUE)
        q.setBackgroundColor(Color.BLUE)
        r.setBackgroundColor(Color.BLUE)
        s.setBackgroundColor(Color.BLUE)
        t.setBackgroundColor(Color.BLUE)
        u.setBackgroundColor(Color.BLUE)
        v.setBackgroundColor(Color.BLUE)
        w.setBackgroundColor(Color.BLUE)
        x.setBackgroundColor(Color.BLUE)
        y.setBackgroundColor(Color.BLUE)
        z.setBackgroundColor(Color.BLUE)


        return null
    }
    private val launchLanguageActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK){
            format = result.data?.getStringExtra(getString(R.string.numberFormatKey)) ?: "English"
            Snackbar.make(findViewById(R.id.mainContainer), format, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun startLanguageActivity() {
        val intent = Intent(this,LanguageActivity::class.java)

        intent.putExtra(getString(R.string.numberFormatKey),format)

        launchLanguageActivity.launch(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gallows = findViewById(R.id.hangmanView)
        gallows.setImageResource(R.drawable.hangman_gray)
        wordToFindTv = findViewById(R.id.word)
        usedLettersTv = findViewById(R.id.usedLetters)
        spinner = findViewById(R.id.difficultySpinner)
        stringArray = resources.getStringArray(R.array.wordsEN)
        actualLanguage = "English"
        val restart:FloatingActionButton = findViewById(R.id.restartButton)
        a = findViewById(R.id.a)
         b = findViewById(R.id.b)
         c = findViewById(R.id.c)
         d = findViewById(R.id.d)
         e = findViewById(R.id.e)
         f = findViewById(R.id.f)
         g = findViewById(R.id.g)
         h = findViewById(R.id.h)
         i = findViewById(R.id.i)
         j = findViewById(R.id.j)
         k = findViewById(R.id.k)
         l = findViewById(R.id.l)
         m = findViewById(R.id.m)
         n = findViewById(R.id.n)
         o = findViewById(R.id.o)
         p = findViewById(R.id.p)
         q = findViewById(R.id.q)
         r = findViewById(R.id.r)
         s = findViewById(R.id.s)
         t = findViewById(R.id.t)
         u = findViewById(R.id.u)
         v = findViewById(R.id.v)
         w = findViewById(R.id.w)
         x = findViewById(R.id.x)
         y = findViewById(R.id.y)
         z = findViewById(R.id.z)
        colorReset()
        restart.setOnClickListener{newGame()}
        a.setOnClickListener{clickLetter('a')
            a.setBackgroundColor(Color.RED)}
        b.setOnClickListener{clickLetter('b')
            b.setBackgroundColor(Color.RED)}
        c.setOnClickListener{clickLetter('c')
            c.setBackgroundColor(Color.RED)}
        d.setOnClickListener{clickLetter('d')
            d.setBackgroundColor(Color.RED)}
        e.setOnClickListener{clickLetter('e')
            e.setBackgroundColor(Color.RED)}
        f.setOnClickListener{clickLetter('f')
            f.setBackgroundColor(Color.RED)}
        g.setOnClickListener{clickLetter('g')
            g.setBackgroundColor(Color.RED)}
        h.setOnClickListener{clickLetter('h')
            h.setBackgroundColor(Color.RED)}
        i.setOnClickListener{clickLetter('i')
            i.setBackgroundColor(Color.RED)}
        j.setOnClickListener{clickLetter('j')
            j.setBackgroundColor(Color.RED)}
        k.setOnClickListener{clickLetter('k')
            k.setBackgroundColor(Color.RED)}
        l.setOnClickListener{clickLetter('l')
            l.setBackgroundColor(Color.RED)}
        m.setOnClickListener{clickLetter('m')
            m.setBackgroundColor(Color.RED)}
        n.setOnClickListener{clickLetter('n')
            n.setBackgroundColor(Color.RED)}
        o.setOnClickListener{clickLetter('o')
            o.setBackgroundColor(Color.RED)}
        p.setOnClickListener{clickLetter('p')
            p.setBackgroundColor(Color.RED)}
        q.setOnClickListener{clickLetter('q')
            q.setBackgroundColor(Color.RED)}
        r.setOnClickListener{clickLetter('r')
            r.setBackgroundColor(Color.RED)}
        s.setOnClickListener{clickLetter('s')
            s.setBackgroundColor(Color.RED)}
        t.setOnClickListener{clickLetter('t')
            t.setBackgroundColor(Color.RED)}
        u.setOnClickListener{clickLetter('u')
            u.setBackgroundColor(Color.RED)}
        v.setOnClickListener{clickLetter('v')
            v.setBackgroundColor(Color.RED)}
        w.setOnClickListener{clickLetter('w')
            w.setBackgroundColor(Color.RED)}
        x.setOnClickListener{clickLetter('x')
            x.setBackgroundColor(Color.RED)}
        y.setOnClickListener{clickLetter('y')
            y.setBackgroundColor(Color.RED)}
        z.setOnClickListener{clickLetter('z')
            z.setBackgroundColor(Color.RED)}

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.languageSettings -> startLanguageActivity()
            else -> return super.onOptionsItemSelected(item)
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
        colorReset()
        gameOver = false
        mistakes = 0
        spinnerValue = spinner.selectedItem.toString()
        if(format.equals("English"))
        {
            stringArray = resources.getStringArray(R.array.wordsEN)
        }
        else if (format.equals("Polish"))
        {
            stringArray = resources.getStringArray(R.array.wordsPL)
        }
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
