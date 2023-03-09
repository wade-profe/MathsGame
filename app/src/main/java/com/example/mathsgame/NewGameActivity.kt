package com.example.mathsgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mathsgame.databinding.ActivityNewGameBinding
import java.util.*
import kotlin.random.Random

class NewGameActivity : AppCompatActivity() {

    lateinit var gameBinding: ActivityNewGameBinding
    var correctAnswer = 0
    var score = 0
    var life = 3

    lateinit var timer : CountDownTimer
    private val startTimerInMillis : Long = 60000
    var timeLeftInMillis : Long = startTimerInMillis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameBinding = ActivityNewGameBinding.inflate(layoutInflater)
        val view = gameBinding.root
        setContentView(view)
        startTimer()
        gameContinue()

        gameBinding.buttonOk.setOnClickListener {
            val input = gameBinding.editTextAnswer.text.toString()
            if (input == "") {
                Toast.makeText(
                    applicationContext,
                    "Please write an answer or click the next button",
                    Toast.LENGTH_LONG
                ).show()
            } else if(input.toInt() == correctAnswer){
                gameBinding.textViewQuestion.text = "Correct!"
                gameBinding.scoreInt.text = (++score).toString()

            } else{
                gameBinding.textViewQuestion.text = "Wrong! The correct answer was $correctAnswer. Press the Next button"
                gameBinding.lifeInt.text = (--life).toString()
            }

        }

        gameBinding.buttonNext.setOnClickListener {
            if(life>0){
                gameContinue()
            } else{
                endGame()
            }

        }
    }

    @SuppressLint("SetTextI18n")
    fun gameContinue() {

        when(intent.getIntExtra("challengeType", 1)){
            1 -> {
                val number1 = Random.nextInt(0, 100)
                val number2 = Random.nextInt(0, 100)

                gameBinding.textViewQuestion.text = "$number1 + $number2"
                gameBinding.editTextAnswer.text.clear()
                correctAnswer = number1 + number2
            }
            2 -> {
                val number1 = Random.nextInt(10, 100)
                val number2 = Random.nextInt(0, number1)

                gameBinding.textViewQuestion.text = "$number1 - $number2"
                gameBinding.editTextAnswer.text.clear()
                correctAnswer = number1 - number2
            }
            3 -> {
                val number1 = Random.nextInt(0, 10)
                val number2 = Random.nextInt(0, 10)

                gameBinding.textViewQuestion.text = "$number1 x $number2"
                gameBinding.editTextAnswer.text.clear()
                correctAnswer = number1 * number2
            }
        }
    }

    fun startTimer()
    {
        timer = object : CountDownTimer(timeLeftInMillis,1000){

            override fun onTick(millisUntilFinished : Long) {
                timeLeftInMillis = millisUntilFinished
                updateText()
            }

            override fun onFinish() {
                endGame()
                Toast.makeText(
                    applicationContext,
                    "Your time is up",
                    Toast.LENGTH_LONG
                ).show()
            }
        }.start()
    }

    fun updateText()
    {
        val remainingTime : Int = (timeLeftInMillis / 1000).toInt()
        gameBinding.timeInt.text = String.format(Locale.getDefault(),"%02d",remainingTime)
    }

    fun endGame(){
        timer.cancel()
        val intent = Intent(this@NewGameActivity, ResultActivity::class.java)
        intent.putExtra("score", score)
        startActivity(intent)
        finish()
    }


}