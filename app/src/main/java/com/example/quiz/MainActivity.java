package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    // to keep current question and marks track
    private int currentQuestionIndex = 0;
    int marks=0;
    int count=0;



    //declaring the variables
    private ImageView image;
    private TextView question;
    private CheckBox option1;
    private CheckBox option2;
    private CheckBox option3;
    private CheckBox option4;
    private Button nextButton;
    private TextView result;
    private ProgressBar progressBar;
    private int progress=0;
    private TextView questionAttempted;


    //array of questions and answers
    private Ques[] questionBank = new Ques[]{
            // array of objects of class Question
            // providing questions from string
            // resource and the correct ans
            new Ques(R.string.question1, R.string.answer1),
            new Ques(R.string.question2, R.string.answer2),
            new Ques(R.string.question3, R.string.answer3),
            new Ques(R.string.question4, R.string.answer4),
            new Ques(R.string.question5, R.string.answer5),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //finding the views in the java code
        image=(ImageView) findViewById(R.id.quesiton_image);
        question=(TextView) findViewById(R.id.question);
        option1=(CheckBox) findViewById(R.id.option_a);
        option2=(CheckBox) findViewById(R.id.option_b);
        option3=(CheckBox) findViewById(R.id.option_c);
        option4=(CheckBox) findViewById(R.id.option_d);
        nextButton=(Button) findViewById(R.id.next_button);
        result=(TextView) findViewById(R.id.marks);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        questionAttempted=(TextView) findViewById(R.id.question_attempted);


        //applying on click listener on the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to next question
                // limiting question bank range

                if(option1.isChecked()||option2.isChecked()||option3.isChecked()||option4.isChecked()){
                    progress=progress+1;
                    progressBar.setProgress(progress);
                    count=count+1;
                    questionAttempted.setText(count+"/5");
                }


                if (currentQuestionIndex <= 5) {
                    currentQuestionIndex = currentQuestionIndex + 1;
                    option1.setChecked(false);
                    option2.setChecked(false);
                    option3.setChecked(false);
                    option4.setChecked(false);
                    // we are safe now!
                    // last question reached
                    // making buttons
                    // invisible
                    if(currentQuestionIndex==5){
                        result.setText(marks+"/"+"5");
                        result.setTextSize(30);
                        nextButton.setVisibility(View.INVISIBLE);
                    }

                    if (currentQuestionIndex == 4) {
                        updateQuestion();
                        nextButton.setText("RESULT");
                    } else {
                        updateQuestion();
                    }

                }
            }
        });

    }

    private void updateQuestion()
    {
        // setting the textview with new question
        if(currentQuestionIndex<5){
        question.setText(questionBank[currentQuestionIndex].getQuestionId());
        }

        // setting up image for each question
        switch (currentQuestionIndex) {
            case 1:
                image.setImageResource(R.drawable.lalkila);
                option1.setText("Rohan");
                option2.setText("Sohan");
                option3.setText("Maharana Pratap");
                option4.setText("Shah Jahan");
                break;
            case 2:
                image.setImageResource(R.drawable.goldentemple);
                option1.setText("Haryana");
                option2.setText("London");
                option3.setText("Amritsar");
                option4.setText("Antartica");
                break;
            case 3:
                image.setImageResource(R.drawable.qutubminar);
                option1.setText("2019");
                option2.setText("1215");
                option3.setText("2000");
                option4.setText("1500");
                break;
            case 4:
                image.setImageResource(R.drawable.lotustemple);
                option1.setText("Qutub Minar");
                option2.setText("TajMahal");
                option3.setText("Golden Temple");
                option4.setText("Lotus Temple");
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.option_a:
                if (currentQuestionIndex==0 && checked){
                    marks++;
                    break;
                }
                break;
            case R.id.option_b:
                if(currentQuestionIndex==3 && checked){
                    marks++;
                    break;
                }
                break;

            case R.id.option_c:
                if(currentQuestionIndex==2 && checked){
                    marks++;
                    break;
                }
                break;

            case R.id.option_d:
                if((currentQuestionIndex==1 || currentQuestionIndex==4) && checked){
                    marks++;
                    break;
                }
                break;
        }

    }
}