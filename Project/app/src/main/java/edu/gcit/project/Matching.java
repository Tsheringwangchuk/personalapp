package edu.gcit.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Matching extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);

    }

    public void FirstLevel(View view) {
        Intent obj = new Intent(Matching.this, MatchingLevel1.class);
        startActivity(obj);
    }
}