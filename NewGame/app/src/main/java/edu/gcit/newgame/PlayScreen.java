package edu.gcit.newgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import static edu.gcit.newgame.AppController.StopSound;
//import static edu.gcit.newgame.AppController.StopSound;

public class PlayScreen extends AppCompatActivity implements View.OnClickListener {

    Button btPlayQuiz;

    public static Context context;

    long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);


        btPlayQuiz = findViewById(R.id.bt_playQuiz);

        //btSettings.setOnClickListener(this);
        btPlayQuiz.setOnClickListener(this);

        context = getApplicationContext();
        AppController.currentActivity = this;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bt_playQuiz:

                Intent playIntent = new Intent(PlayScreen.this,MainActivity.class);
                startActivity(playIntent);
                finish();
                break;

        }

    }

//    @Override
//    public void onBackPressed() {
//
////        StopSound();
//
//        if (backPressedTime + 2000 > System.currentTimeMillis()){
//
//            new AlertDialog.Builder(this)
//                    .setTitle("Do you want to Exit")
//                    .setNegativeButton("No",null)
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                            setResult(RESULT_OK,new Intent().putExtra("Exit",true));
//                            finish();
//
//                        }
//                    }).create().show();
//
//        }else {
//
//            Toast.makeText(context, "Press Again to Exit", Toast.LENGTH_SHORT).show();
//        }
//
//        backPressedTime = System.currentTimeMillis();
//
//    }
}