package edu.gcit.dzongkhatypinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class Technologyterms extends AppCompatActivity {
    ImageView buttonA;
    TextView questionText, txtTotalQuesText, txtLevelIndicator;
    EditText editText1;

    QDbHelper qDbHelper;
    Question currentQuestion;
    List<Question> list;
    int correct = 0;
    int wrong = 0;
    int coins = 0;

    int qid = 1;


    int sizeofQuiz = 5; // total size of Quiz


    String categoryValue;
    //int levelsId;
    //int UNLOCK_JL2 = 0, UNLOCK_JL3 = 0, UNLOCK_JL4 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technologyterms);

        editText1 = (EditText) findViewById(R.id.spellingedit);
        questionText = findViewById(R.id.textview1);
        txtTotalQuesText = findViewById(R.id.textviewtotalquestion);


        //txtLevelIndicator = findViewById(R.id.textviewquestionlevel);


        Intent intentCategory = getIntent();
        categoryValue = intentCategory.getStringExtra("Category");
        //subcategoryValue = intentLevelsAndCategoryAndSubCategory.getStringExtra("Subcategory");
        //levelsId = intentLevelsAndCategory.getIntExtra("Level", 0);

        qDbHelper = new QDbHelper(this);
        qDbHelper.getReadableDatabase();

        list = qDbHelper.getQuestionsByCategory(categoryValue);
//        Log.d("length", String.valueOf(list.size()));
//        System.out.print("Hii");


        Collections.shuffle(list);
        currentQuestion = list.get(qid);
        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);

        //txtLevelIndicator.setText("Level " + levelsId);

        updateQueAnsOptions();


        buttonA = findViewById(R.id.buttoncheck1);
        buttonA.setOnClickListener(v -> {
            //disableOptions();
            //Log.d("hello", "error");
            String answer = currentQuestion.getAnswerNr();
            String name = editText1.getEditableText().toString();
            if (name.isEmpty()) {
                //displayToast("it should not be null");
            } else if (name.equals(answer)) {
                correct++;
//                correct();
//                MediaPlayer myMedia = MediaPlayer.create(SpellingQuestion.this, R.raw.correct);
//                myMedia.start();
                coins = coins + 10;
                //Log.i("QuizInfo", "Correct");
                {
                    if (qid != sizeofQuiz) {
                        SetNewQuestion();

                    }
//                    else {
//                        finalResult();
//                    }


                }
            } else {
                wrong++;
                //wrong();
                // MediaPlayer myMedia = MediaPlayer.create(SpellingQuestion.this, R.raw.wrong);
                //myMedia.start();
                if (qid != sizeofQuiz) {
                    SetNewQuestion();

                }
//                else {
//                    finalResult();
//                }
            }
            editText1.setText("");


        });
    }

    //    public void correct()
//    {
//        ImageView i = new ImageView(getApplicationContext());
//        i.setImageResource(R.drawable.correct);
//
//        Toast toast = new Toast(getApplicationContext());
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setView(i);
//        toast.show();
//    }
//    public void wrong()
//    {
//        //ImageView i = new ImageView(getApplicationContext());
//        //i.setImageResource(R.drawable.wrong);
//
//        Toast toast = new Toast(getApplicationContext());
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setView(i);
//        toast.show();
//    }
    private void updateQueAnsOptions() {

        questionText.setText(currentQuestion.getQuestion());
        //buttonA.setText(currentQuestion.getOption1());

    }

    private void SetNewQuestion() {
        qid++;
        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);
        currentQuestion = list.get(qid);
        //enableOptions();
        updateQueAnsOptions();
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



//    private void finalResult() {
//
//        //unLockTheLevels();
//
//        Intent resultIntent = new Intent(SpellingQuestion.this, MainActivity.class);
//        resultIntent.putExtra(Constants.TOTAL_QUESTIONS, sizeofQuiz);
//        resultIntent.putExtra(Constants.COINS, coins);
//        resultIntent.putExtra(Constants.WRONG, wrong);
//        resultIntent.putExtra(Constants.CORRECT, correct);
//        resultIntent.putExtra("Category", categoryValue);
//        //resultIntent.putExtra("Level", levelsId);
//        startActivity(resultIntent);
//        finish();
//
//
//    }


}
