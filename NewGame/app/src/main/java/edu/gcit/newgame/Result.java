package edu.gcit.newgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    Button btPlayAgain, btPlayScreen, btPlayNextLevel;
    TextView txtTotalQuesion, txtCoins, txtWrongQues, txtCorrectQues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btPlayAgain = findViewById(R.id.bt_PlayAgainR);
        btPlayScreen = findViewById(R.id.bt_PlayScreenR);
        btPlayNextLevel = findViewById(R.id.bt_PlayNextLevelR);

        txtCoins = findViewById(R.id.txtCoinsR);
        txtCorrectQues = findViewById(R.id.txtCorrectR);
        txtWrongQues = findViewById(R.id.txtWrongR);
        txtTotalQuesion = findViewById(R.id.txtTotalQuestionsR);


        Intent intent = getIntent();

        int totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0);
        int coins = intent.getIntExtra(Constants.COINS, 0);
        int correct = intent.getIntExtra(Constants.CORRECT, 0);
        int wrong = intent.getIntExtra(Constants.WRONG, 0);
        final String categoryValue = intent.getStringExtra("Category");
        final String subcategoryvalue = intent.getStringExtra("Subcategory");
        //Log.d("error", subcategoryonevalue);
        //final String subcategoryonevalue ="Subcategory_1";
//        final String subcategorytwovalue = "Subcategory_2";
//        final String subcategorythreevalue = "Subcategory_3";
        //Log.d("me",subcategoryvalue);
        final int levelsId = intent.getIntExtra("Level", 0);

        //Log.d("key", intent.getStringExtra("Category"));
        txtTotalQuesion.setText(String.valueOf(totalQuestions));
        txtCoins.setText(String.valueOf(coins));
        txtCorrectQues.setText(String.valueOf(correct));
        txtWrongQues.setText(String.valueOf(wrong));


        btPlayScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, PlayScreen.class);
                startActivity(intent);
                finish();
            }
        });

        btPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
//            public void onClick(View view) {
//
//
//                Intent intent = new Intent(Result.this, MainQuestion.class);
//                intent.putExtra("Category", categoryValue);
//                intent.putExtra("Level", levelsId);
//                startActivity(intent);
//                finish();
//            }
            public void onClick(View view) {


                if (categoryValue.equals("Category_1")) {
                    Intent intent = new Intent(Result.this,MainQuestion.class);
                    intent.putExtra("Category", categoryValue);
                    intent.putExtra("Level", levelsId);
                    startActivity(intent);
                    finish();
                } else if ((categoryValue.equals("Category_2")) && (subcategoryvalue.equals("Subcategory_1"))) {

                    Intent intent = new Intent(Result.this, addition_question.class);
                    intent.putExtra("Category", categoryValue);
                    intent.putExtra("Subcategory", subcategoryvalue);
                    intent.putExtra("Level", levelsId);
                    startActivity(intent);
                    finish();
                }else if ((categoryValue.equals("Category_2")) && (subcategoryvalue.equals("Subcategory_2"))) {
                    Intent intent = new Intent(Result.this, subtraction_question.class);
                    intent.putExtra("Category", categoryValue);
                    intent.putExtra("Subcategory", subcategoryvalue);
                    intent.putExtra("Level", levelsId);
                    startActivity(intent);
                    finish();
                }else if ((categoryValue.equals("Category_2")) && (subcategoryvalue.equals("Subcategory_3"))) {
                    Intent intent = new Intent(Result.this, multiplication_question.class);
                    intent.putExtra("Category", categoryValue);
                    intent.putExtra("Subcategory", subcategoryvalue);
                    intent.putExtra("Level", levelsId);
                    startActivity(intent);
                    finish();
                } else if ((categoryValue.equals("Category_2")) && (subcategoryvalue.equals("Subcategory_4"))) {
                    Intent intent = new Intent(Result.this, division_question.class);
                    intent.putExtra("Category", categoryValue);
                    intent.putExtra("Subcategory", subcategoryvalue);
                    intent.putExtra("Level", levelsId);
                    startActivity(intent);
                    finish();
                }
                else if (categoryValue.equals("Category_3")) {
                    Intent intent = new Intent(Result.this, SpellingQuestion.class);
                    intent.putExtra("Category", categoryValue);
                    intent.putExtra("Level", levelsId);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btPlayNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (categoryValue.equals("Category_1")) {
                    Intent intent = new Intent(Result.this,Catonelevel.class);
                    intent.putExtra("Category", categoryValue);
                    startActivity(intent);
                    finish();
               } else if ((categoryValue.equals("Category_2")) && (subcategoryvalue.equals("Subcategory_1"))) {

                   Intent intent = new Intent(Result.this, additionlevel.class);
                   intent.putExtra("Category", categoryValue);
                   intent.putExtra("Subcategory", subcategoryvalue);
                   startActivity(intent);
                   finish();
                }else if ((categoryValue.equals("Category_2")) && (subcategoryvalue.equals("Subcategory_2"))) {
                    Intent intent = new Intent(Result.this, subtractionlevel.class);
                    intent.putExtra("Category", categoryValue);
                    intent.putExtra("Subcategory", subcategoryvalue);
                    startActivity(intent);
                    finish();
                }else if ((categoryValue.equals("Category_2")) && (subcategoryvalue.equals("Subcategory_3"))) {
                    Intent intent = new Intent(Result.this, multiplicationlevel.class);
                    intent.putExtra("Category", categoryValue);
                    intent.putExtra("Subcategory", subcategoryvalue);
                    startActivity(intent);
                    finish();
                } else if ((categoryValue.equals("Category_2")) && (subcategoryvalue.equals("Subcategory_4"))) {
                    Intent intent = new Intent(Result.this, divisionlevel.class);
                    intent.putExtra("Category", categoryValue);
                    intent.putExtra("Subcategory", subcategoryvalue);
                    startActivity(intent);
                    finish();
                }
                else if (categoryValue.equals("Category_3")) {
                    Intent intent = new Intent(Result.this, SpellingLevel.class);
                    intent.putExtra("Category", categoryValue);
                    startActivity(intent);
                   finish();
              }
            }
        });

    }
}

