package com.mainafelix.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.inflate
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.mainafelix.quizapp.databinding.ActivityQuizUi2Binding

class QuizUiActivity2 : AppCompatActivity(), View.OnClickListener {
    private  var mCurrentPosition:Int = 1
    private var  mQuestionsList:List<Question>? = null

    private var  mSelectedPosition: Int = 0
    private  var correctAnswes:Int = 0
    private var  userName:String?= null

    private lateinit var binding:ActivityQuizUi2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityQuizUi2Binding.inflate(layoutInflater)
        val view =  binding.root
        setContentView(view)
        userName = intent.getStringExtra(Constants.USER_NAME)


        mQuestionsList = Constants.getQuestion()
        SetQuestion()
        binding.tvOptionOne.setOnClickListener (this)
        binding.tvOptionTwo.setOnClickListener (this)
        binding.tvOptionThree.setOnClickListener (this)
        binding.tvOptionFour.setOnClickListener (this)
        binding.btnSubmit.setOnClickListener(this)

    }
    private fun SetQuestion(){

        val question = mQuestionsList!![mCurrentPosition-1]
        defaultOptinsView()
        if (mCurrentPosition == mQuestionsList!!.size){
           binding.btnSubmit.text = "FINISH"
        }else {
            binding.btnSubmit.text =  "SUBMIT"
        }
        binding.progressBar.progress = mCurrentPosition
        //set the progressbar equivalent to the textview
        binding.tvProgress.text = "$mCurrentPosition"+"/"+ binding.progressBar.max
        //set the Question
        binding.tvWuestion.text =  question!!.question

       binding.IvImage.setImageResource(question.image)
      binding.tvOptionOne.text= question.optionOne
      binding.tvOptionTwo.text= question.optionTwo
      binding.tvOptionThree.text= question.optionThree
      binding.tvOptionFour.text= question.optionFour
    }
    private fun  defaultOptinsView(){
        //creaete an arraylist of the options we have
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)

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
                selectedOptionsView(binding.tvOptionOne,1)

            }
            R.id.tv_optionTwo ->{
                selectedOptionsView(binding.tvOptionTwo,2)
            }
            R.id.tv_optionThree ->{
                selectedOptionsView(binding.tvOptionThree,3)

            }
            R.id.tv_optionFour ->{
                selectedOptionsView(binding.tvOptionOne,4)

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
                       binding.btnSubmit.text = "FINISH"
                    }else{
                        binding.btnSubmit.text  ="GO TO THE NEXT QUESTION"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }
    private fun  answerView(answer:Int,drawableView:Int){
        when(answer){
            1 -> {
               binding.tvOptionOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
               binding.tvOptionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
               binding.tvOptionThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                binding.tvOptionFour.background = ContextCompat.getDrawable(this,drawableView)
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





