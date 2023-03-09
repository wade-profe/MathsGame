package com.example.mathsgame

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mathsgame.databinding.ResultActivityBinding

class ResultActivity: AppCompatActivity() {

    lateinit var resultBinding: ResultActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultBinding = ResultActivityBinding.inflate(layoutInflater)
        val view = resultBinding.root
        setContentView(view)
        resultBinding.textViewResult.text = "Score: ${intent.getIntExtra("score", 0)}"
    }
}