package com.mainafelix.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout

class QuizUiQuestionActivity : AppCompatActivity(),View.OnClickListener {

    private  var mCurrentPosition:Int = 1
    private var  mQuestionsList:List<Question>? = null
    private var  mSelectedPosition: Int = 0
    private  var correctAnswes:Int = 0
    private var  userName:String?= null
    val tvOptionOne  = findViewById<TextView>(R.id.tv_optionOne)
    val tvOptionTwo  = findViewById<TextView>(R.id.tv_optionTwo)
    val tvOptionThree  = findViewById<TextView>(R.id.tv_optionThree)
    val tvOptionFor  = findViewById<TextView>(R.id.tv_optionFour)
    val progressBar  = findViewById<ProgressBar>(R.id.progress_bar)
    val image  = findViewById<ImageView>(R.id.IvImage)
    val tvQuestion  = findViewById<TextView>(R.id.tv_wuestion)
    val  btnSubmit  = findViewById<Button>(R.id.btnSubmit)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_ui_question)
        userName = intent.getStringExtra(Constants.USER_NAME)


        mQuestionsList = Constants.getQuestion()
        SetQuestion()


        tvOptionOne.setOnClickListener { this }
        tvOptionTwo.setOnClickListener { this }
        tvOptionThree.setOnClickListener { this }
        tvOptionFor.setOnClickListener { this }
        btnSubmit.setOnClickListener { this }





    }

    private fun SetQuestion(){

        val question = mQuestionsList!!.get(mCurrentPosition-1)
        val tvProgress  = findViewById<TextView>(R.id.tv_progress)
        defaultOptinsView()
        if (mCurrentPosition == mQuestionsList!!.size){
            btnSubmit.text=  "FINISH"
        }else {
            btnSubmit.text = "SUBMIR"
        }


        progressBar.progress = mCurrentPosition
        //set the progressbar equivalent to the textview
        tvProgress.text = "$mCurrentPosition"+"/"+ progressBar.max
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
    private fun  defaultOptinsView(){
        //creaete an arraylist of the options we have
        val options = ArrayList<TextView>()
        options.add(0,tvOptionOne)
        options.add(1,tvOptionTwo)
        options.add(2,tvOptionThree)
        options.add(4,tvOptionFor)
        for (option in options){
           option.setTextColor(Color.parseColor("#7A8089"))
         //  typeFace can be Bold default etc
            option.typeface= Typeface.DEFAULT
            // set our option border
            option.background = ContextCompat.getDrawable(this,R.drawable.default_optiom_border)
        }
    }

    override fun onClick(v: View?) {
       when(v?.id){
          R.id.tv_optionOne ->{
              selectedOptionsView(tvOptionOne,1)

           }
           R.id.tv_optionTwo ->{
               selectedOptionsView(tvOptionTwo,2)
           }
           R.id.tv_optionThree ->{
               selectedOptionsView(tvOptionThree,3)

           }
           R.id.tv_optionFour ->{
               selectedOptionsView(tvOptionOne,4)

           }
           R.id.btnSubmit  ->{
             if (mSelectedPosition == 0){
                 mCurrentPosition++

                 when{
                     mCurrentPosition <= mQuestionsList!!.size -> {
                         SetQuestion()
                     }else ->{
                     val intent = Intent(this, ResultActivity::class.java)
                     intent.putExtra(Constants.USER_NAME,userName)
                     intent.putExtra(Constants.CORRECT_ANSWERS,correctAnswes)
                     intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                     startActivity(intent)
                     finish()
                     }
                 }
             }else {
                 //setting the bg for the wromg answer
                 val question = mQuestionsList?.get(mCurrentPosition-1)
                 if(question!!.correctAnswer != mSelectedPosition){
                     answerView(mSelectedPosition,R.drawable.wrong_option_border)
                 } else {
                     mCurrentPosition ++
                 }
                 //settimg the bg for the correct answer
                 answerView(question.correctAnswer, R.drawable.correct_optiom_border)
                 if (mCurrentPosition == mQuestionsList!!.size){
                    btnSubmit.text = "FINISH"
                 }else{
                     btnSubmit.text ="GO TO THE NEXT QUESTION"
                 }
                 mSelectedPosition = 0
             }
           }
       }
    }
    private fun  answerView(answer:Int,drawableView:Int){
        when(answer){
            1 -> {
                tvOptionOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                tvOptionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                tvOptionThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                tvOptionFor.background = ContextCompat.getDrawable(this,drawableView)
            }

        }

    }
     private fun  selectedOptionsView(tv:TextView,selectedOptionNum :Int){
         defaultOptinsView()
         mSelectedPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
         //  typeFace can be Bold default etc
        tv.setTypeface (tv.typeface,Typeface.BOLD)
         // set our option border
         tv.background = ContextCompat.getDrawable(this,R.drawable.select_optiom_border)

     }

}