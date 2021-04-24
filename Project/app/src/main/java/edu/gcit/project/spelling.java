package edu.gcit.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class spelling extends AppCompatActivity {
    MediaPlayer clocksound;
    EditText textAnswer;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spelling);
        clocksound = MediaPlayer.create(spelling.this, R.raw.clock);

        textAnswer = (EditText) findViewById(R.id.editTextTextPersonName2);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = textAnswer.getEditableText().toString();
                if(name.isEmpty()){
                    textAnswer.setText("It cannot be empty..");
                }
                else if((name.contains("clock"))||(name.contains("Clock"))){
                    //textAnswer.setText("Congrats..");
                    //textAnswer.setHighlightColor("Congrats..");
                    textAnswer.setTextColor(Color.GREEN);
                }
                else{
                    //textAnswer.setText("Try again..");
                    textAnswer.setTextColor(Color.RED);
                }
            }
        });
    }

    public void clockphoto(View view) {
        clocksound.start();

    }
}