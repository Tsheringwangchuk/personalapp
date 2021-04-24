package edu.gcit.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Math extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
    }

    public void sub_Addition(View view) {
        Intent obj1= new Intent(this,startadding.class);
        startActivity(obj1);
    }
}