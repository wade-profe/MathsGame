package com.example.mathsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathsgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding : ActivityMainBinding
    val ADD = 1
    val SUBTRACT = 2
    val MULTI = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.buttonAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, NewGameActivity::class.java)
            intent.putExtra("challengeType", ADD)
            startActivity(intent)
        }
        mainBinding.buttonSub.setOnClickListener {
            val intent = Intent(this@MainActivity, NewGameActivity::class.java)
            intent.putExtra("challengeType", SUBTRACT)
            startActivity(intent)
        }
        mainBinding.buttonMulti.setOnClickListener {
            val intent = Intent(this@MainActivity, NewGameActivity::class.java)
            intent.putExtra("challengeType", MULTI)
            startActivity(intent)
        }
    }
}