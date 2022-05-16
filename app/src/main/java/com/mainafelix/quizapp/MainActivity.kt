package com.mainafelix.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mainafelix.quizapp.databinding.ActivityMain1Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMain1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        val view  = binding.root
        setContentView(view)
        binding.btnStart.setOnClickListener {
            if( binding.etName.text.toString().isEmpty()){
                Toast.makeText(this, "please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,QuizUiActivity2::class.java)
                intent.putExtra(Constants.USER_NAME,binding.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}