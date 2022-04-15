package com.example.hangman

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random
import java.util.*
import kotlin.random.Random.Default.nextInt

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gallows = findViewById(R.id.hangmanView)
        stringArray = resources.getStringArray(R.array.words)
        gallows.setImageResource(R.drawable.hangman_gray)
        wordToFindTv = findViewById(R.id.word)
        usedLettersTv = findViewById(R.id.usedLetters)
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
        restart.setOnClickListener{startGame()}
        a.setOnClickListener{touchLetter('a')}
        b.setOnClickListener{touchLetter('b')}
        c.setOnClickListener{touchLetter('c')}
        d.setOnClickListener{touchLetter('d')}
        e.setOnClickListener{touchLetter('e')}
        f.setOnClickListener{touchLetter('f')}
        g.setOnClickListener{touchLetter('g')}
        h.setOnClickListener{touchLetter('h')}
        i.setOnClickListener{touchLetter('i')}
        j.setOnClickListener{touchLetter('j')}
        k.setOnClickListener{touchLetter('k')}
        l.setOnClickListener{touchLetter('l')}
        m.setOnClickListener{touchLetter('m')}
        n.setOnClickListener{touchLetter('n')}
        o.setOnClickListener{touchLetter('o')}
        p.setOnClickListener{touchLetter('p')}
        q.setOnClickListener{touchLetter('q')}
        r.setOnClickListener{touchLetter('r')}
        s.setOnClickListener{touchLetter('s')}
        t.setOnClickListener{touchLetter('t')}
        u.setOnClickListener{touchLetter('u')}
        v.setOnClickListener{touchLetter('v')}
        w.setOnClickListener{touchLetter('w')}
        x.setOnClickListener{touchLetter('x')}
        y.setOnClickListener{touchLetter('y')}
        z.setOnClickListener{touchLetter('z')}

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
    fun getRandomWord():String{
        return stringArray[java.util.Random().nextInt(stringArray.size)]
    }

    fun startGame():Void?
    {
        gameOver = false
        mistakes = 0
        wordToFind = getRandomWord()
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

    fun wordFound():Boolean{
        return wordToFind.contentEquals(word.toString())
    }

    fun enter(c:Char):Void?{
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

    fun touchLetter(c:Char):Void?{
        if(mistakes < MAX_MISTAKES && !gameOver && !usedLetters.contains(c))
        {
            usedLettersTv.text = usedLettersTv.text.toString()+c.toString()
            usedLetters.append(c)
            enter(c)
            updatePicture(mistakes)

            if(wordFound()){
                gameOver = true
                val alert = AlertDialog.Builder(this)
                alert.setTitle("You won!")
                alert.setMessage("The word was "+wordToFind)
                alert.setPositiveButton("Restart"){dialog, which->startGame()}
                alert.show()
            }
            else{
                if(mistakes >= MAX_MISTAKES){
                    gameOver = true
                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("You lost!")
                    alert.setMessage("The word was "+wordToFind)
                    alert.setPositiveButton("Restart"){dialog, which->startGame()}
                    alert.show()
                }
            }
        }
        return null
    }
}
