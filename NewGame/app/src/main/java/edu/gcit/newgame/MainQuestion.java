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


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;



public class MainQuestion extends AppCompatActivity {


    Button buttonA, buttonB, buttonC, buttonD, target;
    LinearLayout targetlinearlayout;
    TextView questionText, txtTotalQuesText, txtLevelIndicator;

    QDbHelper qDbHelper;
    Question currentQuestion;
    List<Question> list;
    int correct = 0;
    int wrong = 0;
    int coins = 0;

    int qid = 1;

    int sizeofQuiz = 5; // total size of Quiz


    String categoryValue;
    //String subcategoryValue;
    int levelsId;
    int UNLOCK_JL2 = 0, UNLOCK_JL3 = 0, UNLOCK_JL4 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_question);

        questionText = findViewById(R.id.textview1);
        txtTotalQuesText = findViewById(R.id.textviewtotalquestion);
        buttonA = findViewById(R.id.button1);
        buttonB = findViewById(R.id.button2);
        buttonC = findViewById(R.id.button3);
        buttonD = findViewById(R.id.button4);
        txtLevelIndicator = findViewById(R.id.textviewquestionlevel);

        targetlinearlayout = findViewById(R.id.target);

        target = findViewById(R.id.targetbutton1);

        targetlinearlayout.setOnDragListener(dragListenre);
        buttonA.setOnLongClickListener(longClickListener);
        buttonB.setOnLongClickListener(longClickListener);
        buttonC.setOnLongClickListener(longClickListener);
        buttonD.setOnLongClickListener(longClickListener);

        Intent intentLevelsAndCategory = getIntent();
        categoryValue = intentLevelsAndCategory.getStringExtra("Category");
        // subcategoryValue = intentLevelsAndCategoryAndSubCategory.getStringExtra("Subcategory");
        levelsId = intentLevelsAndCategory.getIntExtra("Level", 0);

        qDbHelper = new QDbHelper(this);
        qDbHelper.getReadableDatabase();


        list = qDbHelper.getQuestionsByLevelsAndCategory(categoryValue, levelsId);


        Collections.shuffle(list);
        currentQuestion = list.get(qid);
        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);

        txtLevelIndicator.setText("Level " + levelsId);

        updateQueAnsOptions();

    }

    //drag
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText(" ", " ");

            View.DragShadowBuilder myshadowbulider = new View.DragShadowBuilder(v);
            v.startDrag(data, myshadowbulider, v, 0);

            return true;
        }
    };

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


    View.OnLongClickListener longclickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", " ");
            View.DragShadowBuilder myShadwoBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadwoBuilder, v, 0);

            return true;
        }
    };

    View.OnDragListener dragListenre = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            Log.d("this is: ", "else part");
            switch (dragEvent) {
                case DragEvent.ACTION_DROP: {
                    disableOptions();

                    String sid = currentQuestion.getAnswerNr();
                    String ans = getResources().getResourceEntryName(view.getId());
                    Log.d("chosen one: ", ans);
                    Log.d("correct one: ", sid);
                    Log.d("ans is: ", "if part");
                    if (ans.equals(sid) && v.getId() == R.id.target) {
                        Log.d("ans is: ", "if part part");
                        correct++;
                        coins = coins + 10;

                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        newParent.addView(view);
                    } else {
                        //Toast.makeText("message", "Your answer is wrong",Toast.LENGTH_SHORT).show();
                        Log.d("else called: ", "yes yes");
                        wrong++;

                        //MediaPlayer myMedia = MediaPlayer.create(draganddrop.this, R.raw.wrong);
                        //myMedia.start();
                    }

                    if (qid != sizeofQuiz) {
                        SetNewQuestion();
                    } else {
                        target.setVisibility(View.GONE);
                        finalResult();
                    }

                }
                break;
            }
            return true;
        }
    };

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


    private void finalResult() {

        unLockTheLevels();

        Intent resultIntent = new Intent(MainQuestion.this, Result.class);
        resultIntent.putExtra(Constants.TOTAL_QUESTIONS, sizeofQuiz);
        resultIntent.putExtra(Constants.COINS, coins);
        resultIntent.putExtra(Constants.WRONG, wrong);
        resultIntent.putExtra(Constants.CORRECT, correct);
        resultIntent.putExtra("Category", categoryValue);
        resultIntent.putExtra("Level", levelsId);
        startActivity(resultIntent);
        finish();


    }

    private void unLockTheLevels() {

        unLockdragLevels();
        //unLockKotlinLevels();
        //unLockPythonLevels();

    }

    private void unLockdragLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("Category_1")) {
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_JL2 = correct;
            if (UNLOCK_JL2 >= 3) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_CAT_LEVEL_2, 1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_DRAG_LEVEL_2, "Unlock");
                editor1.apply();
            }
        } else if (levelsId == 2 && categoryValue.equals("Category_1")) {
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_JL3 = correct;
            if (UNLOCK_JL3 >= 3) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_CAT_LEVEL_3, 1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_DRAG_LEVEL_3, "Unlock");
                editor1.apply();
            }
        } else if (levelsId == 3 && categoryValue.equals("Category_1")) {
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_JL4 = correct;
            if (UNLOCK_JL4 >= 3) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_CAT_LEVEL_4, 1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_DRAG_LEVEL_4, "Unlock");
                editor1.apply();
            }
        }

    }
}
