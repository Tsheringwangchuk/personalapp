package edu.gcit.newgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class addition_question extends AppCompatActivity {


    Button buttonA, buttonB, buttonC, buttonD, target;
    LinearLayout targetlinearlayout;
    TextView questionText, txtTotalQuesText, txtLevelIndicator;

    QDbHelper qDbHelper;
    Question currentQuestion;
    List<Question> list;
    int correct = 0;
    int wrong = 0;
    int coins = 0;

    int qid =1;


    int sizeofQuiz = 5; // total size of Quiz


    String categoryValue;
    String subcategoryValue;
    int levelsId;
    int UNLOCK_JL2 = 0, UNLOCK_JL3 = 0, UNLOCK_JL4 = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_question);
        questionText = findViewById(R.id.textview1);
        txtTotalQuesText = findViewById(R.id.textviewtotalquestion);
        buttonA = findViewById(R.id.button1);
        buttonB = findViewById(R.id.button2);
        buttonC = findViewById(R.id.button3);
        buttonD = findViewById(R.id.button4);
        txtLevelIndicator = findViewById(R.id.textviewquestionlevel);

        targetlinearlayout = findViewById(R.id.target);

        target = findViewById(R.id.targetbutton1);


        Intent intentLevelsAndCategoryAndSubCategory = getIntent();
        categoryValue = intentLevelsAndCategoryAndSubCategory.getStringExtra("Category");
        subcategoryValue = intentLevelsAndCategoryAndSubCategory.getStringExtra("Subcategory");
        levelsId = intentLevelsAndCategoryAndSubCategory.getIntExtra("Level", 0);

        qDbHelper = new QDbHelper(this);
        qDbHelper.getReadableDatabase();

        list = qDbHelper.getQuestionsByLevelsAndCategoryAndSubCategory(categoryValue,subcategoryValue,levelsId);
        Log.d("length", String.valueOf(list.size()));
        //System.out.print("Hii");


        Collections.shuffle(list);
        currentQuestion = list.get(qid);
        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);

        txtLevelIndicator.setText("Level " + levelsId);

        updateQueAnsOptions();

    }

    private void updateQueAnsOptions() {

        questionText.setText(currentQuestion.getQuestion());
        buttonA.setText(currentQuestion.getOption1());
        buttonB.setText(currentQuestion.getOption2());
        buttonC.setText(currentQuestion.getOption3());
        buttonD.setText(currentQuestion.getOption4());

    }

    private void SetNewQuestion() {
        qid++;
        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);
        currentQuestion = list.get(qid);
        enableOptions();
        updateQueAnsOptions();
    }


    public void buttonA(View view) {


        disableOptions();

        if (currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())) {
            correct++;
            coins = coins + 10;

            Log.i("QuizInfo", "Correct");


            {

                if (qid != sizeofQuiz) {

                    SetNewQuestion();

                } else {
                    finalResult();
                }


            }
        } else {
            wrong++;
            if (qid != sizeofQuiz) {

                SetNewQuestion();

            } else {
                finalResult();
            }
        }
    }

    public void buttonB(View view) {
        disableOptions();

        if (currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())) {
            correct++;
            coins = coins + 10;

            Log.i("QuizInfo", "Correct");
            {

                if (qid != sizeofQuiz) {

                    SetNewQuestion();

                } else {
                    finalResult();
                }


            }
        } else {
            wrong++;
            if (qid != sizeofQuiz) {

                SetNewQuestion();

            } else {
                finalResult();
            }
        }
    }


    public void buttonC(View view) {
        disableOptions();

        if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())) {
            correct++;
            coins = coins + 10;

            Log.i("QuizInfo", "Correct");

            {

                if (qid != sizeofQuiz) {

                    SetNewQuestion();

                } else {
                    finalResult();
                }
            }
        } else {
            wrong++;
            if (qid != sizeofQuiz) {

                SetNewQuestion();

            } else {
                finalResult();
            }
        }
    }

    public void buttonD(View view) {

        disableOptions();

        if (currentQuestion.getOption4().equals(currentQuestion.getAnswerNr())) {
            correct++;
            coins = coins + 10;

            Log.i("QuizInfo", "Correct");
            {

                if (qid != sizeofQuiz) {
                    SetNewQuestion();
                } else {
                    finalResult();
                }
            }
        } else {
            wrong++;
            if (qid != sizeofQuiz) {

                SetNewQuestion();

            } else {
                finalResult();
                //Log.d("msg", "error");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //countDownTimer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //countDownTimer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //countDownTimer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //countDownTimer.cancel();
        finish();
    }


    private void disableOptions() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

    }

    private void enableOptions() {
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);

    }


    private void finalResult(){

        unLockTheLevels();

        Intent resultIntent = new Intent(addition_question.this,Result.class);
        resultIntent.putExtra(Constants.TOTAL_QUESTIONS,sizeofQuiz);
        resultIntent.putExtra(Constants.COINS,coins);
        resultIntent.putExtra(Constants.WRONG,wrong);
        resultIntent.putExtra(Constants.CORRECT,correct);
        resultIntent.putExtra("Category",categoryValue);
        resultIntent.putExtra("Subcategory", subcategoryValue);
        resultIntent.putExtra("Level",levelsId);
        startActivity(resultIntent);
        finish();


    }
    private void unLockTheLevels() {

        //unLockdragLevels();
        //unLockKotlinLevels();
        //unLockPythonLevels();
        unLockmathLevels();

    }

    private void unLockmathLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("Category_2")) {
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_JL2 = correct;
            if (UNLOCK_JL2 >= 3) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_MATHADD_LEVEL_2, 1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_MATHADD_LEVEL_2, "Unlock");
                editor1.apply();
            }
        } else if (levelsId == 2 && categoryValue.equals("Category_2")) {
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_JL3 = correct;
            if (UNLOCK_JL3 >= 3) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_MATHADD_LEVEL_3, 1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_MATHADD_LEVEL_3, "Unlock");
                editor1.apply();
            }
        } else if (levelsId == 3 && categoryValue.equals("Category_2")) {
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_JL4 = correct;
            if (UNLOCK_JL4 >= 3) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_MATHADD_LEVEL_4, 1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_MATHADD_LEVEL_4, "Unlock");
                editor1.apply();
            }
        }

    }
}
