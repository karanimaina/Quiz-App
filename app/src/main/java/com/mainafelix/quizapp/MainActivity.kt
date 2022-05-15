package com.mainafelix.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //code for removing the system ui
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val btn = findViewById<Button>(R.id.btnStart)
        val editTextName = findViewById<EditText>(R.id.etName)

        btn.setOnClickListener {
            if (editTextName.toString().isEmpty()){
        }


    }
}