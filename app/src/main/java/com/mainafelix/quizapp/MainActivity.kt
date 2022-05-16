package com.mainafelix.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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
                Toast.makeText(this, "please enter your name",Toast.LENGTH_LONG).show()
            }else{
                val intent =Intent(this,QuizUiQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,editTextName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}