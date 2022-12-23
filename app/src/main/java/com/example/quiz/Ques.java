package com.example.quiz;

public class Ques {
    // answerResId will store question
    private int questionsid;

    // answerTrue will store correct answer
    // of the question provided
    private int correctanswerid;

    public Ques(int questionsid, int correctanswerid)
    {
        // setting the values through
        // arguments passed in constructor
        this.questionsid = questionsid;
        this.correctanswerid = correctanswerid;
    }

    // returning the question passed
    public int getQuestionId()
    {
        return questionsid;
    }

    // setting the question passed
    public void setAnswerResId(int correctanswerid)
    {
        this.correctanswerid = correctanswerid;
    }

    // returning the correct answer
    // of question
    public int isAnswerTrue()
    {
        return correctanswerid;
    }

    // setting the correct
    // ans of question
    public void setAnswerTrue(int answerTrue)
    {
        this.correctanswerid = answerTrue;
    }
}
