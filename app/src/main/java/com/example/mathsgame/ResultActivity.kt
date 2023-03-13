package com.example.mathsgame

import android.content.Intent
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

        resultBinding.buttonAgain.setOnClickListener {
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        resultBinding.buttonExit.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}