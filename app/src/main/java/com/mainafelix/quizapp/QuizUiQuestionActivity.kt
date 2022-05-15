package com.mainafelix.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizUiQuestionActivity : AppCompatActivity() {

    private  var mCurrentPosition:Int = 1
    private var  mQuestions:List<Question>? = null
    private var  mSelectedPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_ui_question)
        val  questionList = Constants.getQuestion()
        Log.i("Question size","${questionList.size}")
        val currentPosition = 2
        val tvProgress  = findViewById<TextView>(R.id.tv_progress)
        val tvOptionOne  = findViewById<TextView>(R.id.tv_optionOne)
        val tvOptionTwo  = findViewById<TextView>(R.id.tv_optionTwo)
        val tvOptionThree  = findViewById<TextView>(R.id.tv_optionThree)
        val tvOptionFor  = findViewById<TextView>(R.id.tv_optionFour)

        val image  = findViewById<ImageView>(R.id.IvImage)
        val tvQuestion  = findViewById<TextView>(R.id.tv_wuestion)

        val question:Question?= questionList[currentPosition-1]
        val progressBar  = findViewById<ProgressBar>(R.id.progress_bar)

        progressBar.progress = currentPosition
        //set the progressbar equivalent to the textview
        tvProgress.text = "$currentPosition"+"/"+ progressBar.max
        //set the Question
        tvQuestion.text =   question!!.question
        //et the image resource to the question
        image.setImageResource(question.image)
        tvOptionOne.text= question.optionOne
        tvOptionOne.text= question.optionTwo
        tvOptionOne.text= question.optionThree
        tvOptionOne.text= question.optionFour
        tvOptionOne.text= question.optionOne



    }
}