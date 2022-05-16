package com.mainafelix.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import com.mainafelix.quizapp.databinding.ActivityQuizUi2Binding

class QuizUiActivity2 : AppCompatActivity() {
  private lateinit var binding: ActivityQuizUi2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityQuizUi2Binding.inflate(layoutInflater)
        val view =  binding.root
        setContentView(view)

    }
}