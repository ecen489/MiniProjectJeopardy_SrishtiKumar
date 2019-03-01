package com.example.jeopardy1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity
{
    int questionValue = 0;
    public int questionCtr = 0;
    public ArrayList<Tuple> questionList = new ArrayList<>();
    String correct = "0";
    Question q;
    TextView textView;

    // Radiobuttons
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        q = new Question();
        questionList = q.createQuestionList();
        textView = ((TextView) findViewById(R.id.textView_question));
        textView.setText("True or False: " + questionList.get(questionCtr).getCapital() + " is the capital of " + questionList.get(questionCtr).getState());

        radioGroup = ((RadioGroup) findViewById(R.id.radioGroup));
        radioButton = ((RadioButton) findViewById(R.id.radioButtonTrue));

        Intent forwardIntent = getIntent();
        questionValue = forwardIntent.getIntExtra("questionValue", -1);

        Button buttonPress = (Button) findViewById(R.id.buttonPress);
        buttonPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = radioGroup.getCheckedRadioButtonId(); // Get selected radio button from radioGroup

                radioButton = (RadioButton) findViewById(selectedId); // Find the radiobutton by returned id

                correct = "0";
                if (radioButton.getText().toString().equalsIgnoreCase(questionList.get(questionCtr).getAnswer())) {
                    correct = "1";
                }

                Intent backIntent = new Intent();
                setResult(RESULT_OK, backIntent);
                backIntent.putExtra("Answer", correct);
                backIntent.putExtra("questionValue", questionValue);
                finish();
            }
        });
        questionCtr++;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("correct", correct);
        outState.putInt("questionValue", questionValue);
        outState.putInt("questionCtr", questionCtr);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        correct = savedInstanceState.getString("correct");
        questionValue = savedInstanceState.getInt("questionValue");
        questionCtr = savedInstanceState.getInt("questionCtr");
    }
}
