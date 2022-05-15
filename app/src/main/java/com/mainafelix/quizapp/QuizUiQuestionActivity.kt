package com.mainafelix.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar

class QuizUiQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_ui_question)
        val  questionList = Constants.getQuestion()
        Log.i("Question size","${questionList.size}")
        val currentPosition = 2
        val question:Question?= questionList[currentPosition-1]
        val progressBar  = findViewById<ProgressBar>(R.id.progress_bar)

        progressBar.progress = currentPosition
    }
}