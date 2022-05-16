package com.mainafelix.quizapp
object  Constants{
    const val USER_NAME: String = "user_name"
    const val  TOTAL_QUESTIONS :String ="total_question"
    const val   CORRECT_ANSWERS:String = "correct_answers"

    //create one constants which will contain all the questions"
    fun getQuestion():ArrayList<Question>{
        // create an array of questions
        val  questionsList = ArrayList<Question>()
        val que1 = Question(1,"what country does this flag belong to?",R.drawable.belgium,"Argentima","Belgium","mauritius","Kenya",2)
        val que2 = Question(2,"what country does this flag belong to?",R.drawable.bangladesh,"bangladesh","Nigeria","uganda","tanzania",1)
        val que3= Question(3,"what country does this flag belong to?",R.drawable.zimbambwe,"Zambia","Usa","belgium","zibambwe",4)
        val que4 = Question(4,"what country does this flag belong to?",R.drawable.belgium,"Argentima","Belgium","mauritius","Kenya",1)
        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)

        return  questionsList
    }
}
