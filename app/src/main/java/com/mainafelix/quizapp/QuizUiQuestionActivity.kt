package com.mainafelix.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuizUiQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_ui_question)
        val  questionList = Constants.getQuestion()
    }
}