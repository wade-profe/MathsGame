package com.example.mathsgame

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mathsgame.databinding.ActivityNewGameBinding
import kotlin.random.Random

class NewGameActivity: AppCompatActivity() {

    lateinit var gameBinding : ActivityNewGameBinding
    var correctAnswer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameBinding = ActivityNewGameBinding.inflate(layoutInflater)
        val view = gameBinding.root
        setContentView(view)

        gameBinding.buttonOk.setOnClickListener {
            val input = gameBinding.editTextAnswer.text.toString()
            if(input == ""){
                Toast.makeText(applicationContext, "Please write an answer or click the next button", Toast.LENGTH_LONG).show()
            }
        }    }

    @SuppressLint("SetTextI18n")
    fun gameContinue(){
        val number1 =  Random.nextInt(0,100)
        val number2 = Random.nextInt(0,100)

        gameBinding.textViewQuestion.text = "$number1 + $number2"
        correctAnswer = number1+number2
    }

    /**
     * CountDownTimer is abstract class to create a timer in kotlin
     * lateinit var timer: CountDownTimer
     * private val startTimeInMillis = 60000
     * var timeLeftInMillis= startTimeInMillis
     * fun startTimer(){ timer = object: CountDownTimer(timeLeftInMillis, 1000){
     * override fun onTick(millisUntilFinished: Long
     *
     * }.start()
     */

}