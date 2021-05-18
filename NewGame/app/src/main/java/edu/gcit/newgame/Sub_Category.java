package edu.gcit.newgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sub_Category extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4;
    String CategoryValue = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub__category);

        Intent intentVar = getIntent();
        CategoryValue = intentVar.getStringExtra("Category");

        button1 = findViewById(R.id.buttonadd);
        button2 = findViewById(R.id.buttonsub);
        button3 = findViewById(R.id.buttonmul);
        button4 = findViewById(R.id.buttondiv);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (CategoryValue.equals("Category_2")) {


            switch (v.getId()) {


                case R.id.buttonadd:
                    createsubcategorylevel1();
                    Intent intentJavaLevel1 = new Intent(Sub_Category.this, additionlevel.class);
                    intentJavaLevel1.putExtra("Category", Question.CATEGORY_TWO);
                    intentJavaLevel1.putExtra("Subcategory", Question.SUBCATEGORY_ONE);
                    //Subcategory_1
                    startActivity(intentJavaLevel1);
                    finish();
                    break;

                case R.id.buttonsub:
                    createsubcategorylevel2();
                    Intent intentJavaLevel2 = new Intent(Sub_Category.this, subtractionlevel.class);
                    intentJavaLevel2.putExtra("Category", Question.CATEGORY_TWO);
                    intentJavaLevel2.putExtra("Subcategory", Question.SUBCATEGORY_TWO);
                    startActivity(intentJavaLevel2);
                    finish();
                    break;

                case R.id.buttonmul:
                    createsubcategorylevel3();
                    Intent intentJavaLevel3 = new Intent(Sub_Category.this, multiplicationlevel.class);
                    intentJavaLevel3.putExtra("Category", Question.CATEGORY_TWO);
                    intentJavaLevel3.putExtra("Subcategory", Question.SUBCATEGORY_THREE);
                    startActivity(intentJavaLevel3);
                    finish();
                    break;

                case R.id.buttondiv:
                    createsubcategorylevel4();
                    Intent intentJavaLevel4 = new Intent(Sub_Category.this, divisionlevel.class);
                    intentJavaLevel4.putExtra("Category", Question.CATEGORY_TWO);
                    intentJavaLevel4.putExtra("Subcategory", Question.SUBCATEGORY_FOUR);
                    intentJavaLevel4.putExtra("Level", 4);
                    startActivity(intentJavaLevel4);
                    finish();
                    break;


            }

        }
    }

    public void createsubcategorylevel1() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_MATHADD_LEVEL_1, 1);
        editor.putString(Constants.KEY_CAT_MATHADD_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_MATHADD_LEVEL_1, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHADD_LEVEL_1, 1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_MATHADD_LEVEL_2, 0);
            editor.putInt(Constants.KEY_MATHADD_LEVEL_3, 0);
            editor.putInt(Constants.KEY_MATHADD_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHADD_LEVEL_2, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHADD_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHADD_LEVEL_2, 1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_MATHADD_LEVEL_3, 0);
            editor.putInt(Constants.KEY_MATHADD_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHADD_LEVEL_3, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHADD_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHADD_LEVEL_2, 1);
            editor.putInt(Constants.KEY_MATHADD_LEVEL_3, 1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_MATHADD_LEVEL_4, 0);
        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHADD_LEVEL_4, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHADD_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHADD_LEVEL_2, 1);
            editor.putInt(Constants.KEY_MATHADD_LEVEL_3, 1);
            editor.putInt(Constants.KEY_MATHADD_LEVEL_4, 1);  ///  Unlock Level 4
        }
    }

    public void createsubcategorylevel2() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_MATHSUB_LEVEL_1, 1);
        editor.putString(Constants.KEY_CAT_MATHSUB_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_MATHSUB_LEVEL_1, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHSUB_LEVEL_1, 1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_2, 0);
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_3, 0);
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHSUB_LEVEL_2, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHSUB_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_2, 1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_3, 0);
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHSUB_LEVEL_3, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHSUB_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_2, 1);
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_3, 1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_4, 0);
        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHSUB_LEVEL_4, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHSUB_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_2, 1);
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_3, 1);
            editor.putInt(Constants.KEY_MATHSUB_LEVEL_4, 1);  ///  Unlock Level 4
        }
    }


    public void createsubcategorylevel3() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_MATHMUL_LEVEL_1, 1);
        editor.putString(Constants.KEY_CAT_MATHMUL_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_MATHMUL_LEVEL_1, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHMUL_LEVEL_1, 1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_2, 0);
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_3, 0);
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHMUL_LEVEL_2, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHMUL_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_2, 1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_3, 0);
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHMUL_LEVEL_3, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHMUL_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_2, 1);
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_3, 1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_4, 0);
        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHMUL_LEVEL_4, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHMUL_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_2, 1);
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_3, 1);
            editor.putInt(Constants.KEY_MATHMUL_LEVEL_4, 1);  ///  Unlock Level 4
        }
    }


    public void createsubcategorylevel4() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_MATHDIV_LEVEL_1, 1);
        editor.putString(Constants.KEY_CAT_MATHDIV_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_MATHDIV_LEVEL_1, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHDIV_LEVEL_1, 1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_2, 0);
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_3, 0);
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHDIV_LEVEL_2, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHDIV_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_2, 1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_3, 0);
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_4, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHDIV_LEVEL_3, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHDIV_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_2, 1);
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_3, 1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_4, 0);
        } else if (sharedPreferences.getString(Constants.KEY_CAT_MATHDIV_LEVEL_4, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_MATHDIV_LEVEL_1, 1);
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_2, 1);
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_3, 1);
            editor.putInt(Constants.KEY_MATHDIV_LEVEL_4, 1);  ///  Unlock Level 4
        }
    }
}


