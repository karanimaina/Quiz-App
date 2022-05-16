package com.mainafelix.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val tvName = findViewById<TextView>(R.id.tv_name)
        val btnFinish = findViewById<Button>(R.id.btn_finish)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val userName = intent.getStringExtra(Constants.USER_NAME)
        tvName .text = userName
        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        tvScore.text = "your score is $correctAnswers out of $totalQuestion"
        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }
}