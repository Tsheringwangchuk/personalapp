package edu.gcit.newgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonA, buttonB, buttonC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA = findViewById(R.id.cat1);
        buttonB = findViewById(R.id.cat2);
        buttonC = findViewById(R.id.cat3);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.cat1:

                createLevelsFordrag();
                Intent intentJava = new Intent(MainActivity.this, Catonelevel.class);
                intentJava.putExtra("Category", Question.CATEGORY_ONE);
                startActivity(intentJava);
                finish();
                break;

            case R.id.cat2:
                //createLevelsFormath();
                Intent intentKotlin = new Intent(MainActivity.this, Sub_Category.class);
                intentKotlin.putExtra("Category", Question.CATEGORY_TWO);
                startActivity(intentKotlin);
                finish();
                break;

            case R.id.cat3:
                createLevelsForspelling();
                Intent intentFlutter = new Intent(MainActivity.this, SpellingLevel.class);
                intentFlutter.putExtra("Category", Question.CATEGORY_THREE);
                startActivity(intentFlutter);
                finish();
                break;

//
//            case R.id.bt_Dart:
//
////                Intent intentDart = new Intent(CategoryActivity.this,JavaLevelsActivity.class);
////                intentDart.putExtra("Category",TriviaQuestion.CATEGORY_PYTHON);
////                startActivity(intentDart);
////                finish();
//                break;
        }

    }
    //Drag and Drop
    public void createLevelsFordrag() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_CAT_LEVEL_1, 1);
        editor.putString(Constants.KEY_CAT_DRAG_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_DRAG_LEVEL_1, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_CAT_LEVEL_1, 1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_CAT_LEVEL_2, 0);
            editor.putInt(Constants.KEY_CAT_LEVEL_3, 0);
            editor.putInt(Constants.KEY_CAT_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_DRAG_LEVEL_2, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_CAT_LEVEL_1, 1);
            editor.putInt(Constants.KEY_CAT_LEVEL_2, 1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_CAT_LEVEL_3, 0);
            editor.putInt(Constants.KEY_CAT_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_DRAG_LEVEL_3, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_CAT_LEVEL_1, 1);
            editor.putInt(Constants.KEY_CAT_LEVEL_2, 1);
            editor.putInt(Constants.KEY_CAT_LEVEL_3, 1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_CAT_LEVEL_4, 0);
        }
    else if (sharedPreferences.getString(Constants.KEY_CAT_DRAG_LEVEL_4, "N/A").equals("Unlock")) {

        editor.putInt(Constants.KEY_CAT_LEVEL_1, 1);
        editor.putInt(Constants.KEY_CAT_LEVEL_2, 1);
        editor.putInt(Constants.KEY_CAT_LEVEL_3, 1);
        editor.putInt(Constants.KEY_CAT_LEVEL_4, 1);  ///  Unlock Level 4
//        editor.putInt(Constants.KEY_CAT_LEVEL_5, 0);
//        editor.putInt(Constants.KEY_CAT_LEVEL_6, 0);
        }
    }

    //Math section
//    public void createLevelsFormath() {
//
//        SharedPreferences sharedPreferences =
//                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
//                        Context.MODE_PRIVATE);
//
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(Constants.KEY_MATH_LEVEL_1, 1);
//        editor.putString(Constants.KEY_CAT_MATH_LEVEL_1, "Unlock");
//        editor.apply();
//
//        if (sharedPreferences.getString(Constants.KEY_CAT_MATH_LEVEL_1, "N/A").equals("Unlock")) {
//
//            editor.putInt(Constants.KEY_MATH_LEVEL_1, 1);   ///  Unlock Level 1
//            editor.putInt(Constants.KEY_MATH_LEVEL_2, 0);
//            editor.putInt(Constants.KEY_MATH_LEVEL_3, 0);
//            editor.putInt(Constants.KEY_MATH_LEVEL_4, 0);
//
//        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATH_LEVEL_2, "N/A").equals("Unlock")) {
//
//            editor.putInt(Constants.KEY_MATH_LEVEL_1, 1);
//            editor.putInt(Constants.KEY_MATH_LEVEL_2, 1);   ///  Unlock Level 2
//            editor.putInt(Constants.KEY_MATH_LEVEL_3, 0);
//            editor.putInt(Constants.KEY_MATH_LEVEL_4, 0);
//
//        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATH_LEVEL_3, "N/A").equals("Unlock")) {
//
//            editor.putInt(Constants.KEY_MATH_LEVEL_1, 1);
//            editor.putInt(Constants.KEY_MATH_LEVEL_2, 1);
//            editor.putInt(Constants.KEY_MATH_LEVEL_3, 1);   ///  Unlock Level 3
//            editor.putInt(Constants.KEY_MATH_LEVEL_4, 0);
//        }
//        else if (sharedPreferences.getString(Constants.KEY_CAT_MATH_LEVEL_4, "N/A").equals("Unlock")) {
//
//            editor.putInt(Constants.KEY_MATH_LEVEL_1, 1);
//            editor.putInt(Constants.KEY_MATH_LEVEL_2, 1);
//            editor.putInt(Constants.KEY_MATH_LEVEL_3, 1);
//            editor.putInt(Constants.KEY_MATH_LEVEL_4, 1);  ///  Unlock Level 4
//        }
//    }

    //Spelling
    public void createLevelsForspelling() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_SPELL_LEVEL_1, 1);
        editor.putString(Constants.KEY_CAT_SPELLING_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_SPELLING_LEVEL_1, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_SPELL_LEVEL_1, 1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_SPELL_LEVEL_2, 0);
            editor.putInt(Constants.KEY_SPELL_LEVEL_3, 0);
            editor.putInt(Constants.KEY_SPELL_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_SPELLING_LEVEL_2, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_SPELL_LEVEL_1, 1);
            editor.putInt(Constants.KEY_SPELL_LEVEL_2, 1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_SPELL_LEVEL_3, 0);
            editor.putInt(Constants.KEY_SPELL_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_SPELLING_LEVEL_3, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_SPELL_LEVEL_1, 1);
            editor.putInt(Constants.KEY_SPELL_LEVEL_2, 1);
            editor.putInt(Constants.KEY_SPELL_LEVEL_3, 1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_SPELL_LEVEL_4, 0);
        }
        else if (sharedPreferences.getString(Constants.KEY_CAT_SPELLING_LEVEL_4, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_SPELL_LEVEL_1, 1);
            editor.putInt(Constants.KEY_SPELL_LEVEL_2, 1);
            editor.putInt(Constants.KEY_SPELL_LEVEL_3, 1);
            editor.putInt(Constants.KEY_SPELL_LEVEL_4, 1);  ///  Unlock Level 4
        }
    }
}