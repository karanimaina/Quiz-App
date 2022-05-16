package com.mainafelix.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mainafelix.quizapp.databinding.ActivityMain1Binding

class MainActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityMain1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMain1Binding.inflate(layoutInflater)
        val view  = binding.root
        setContentView(view)
        binding.

    }
}