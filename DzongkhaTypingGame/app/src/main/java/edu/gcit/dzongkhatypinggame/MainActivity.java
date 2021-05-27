package edu.gcit.dzongkhatypinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView buttonA, buttonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=(ImageView) findViewById(R.id.cat1);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.color);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);

        ImageView imageView2=(ImageView) findViewById(R.id.cat2);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.it);
        RoundedBitmapDrawable roundedBitmapDrawable2= RoundedBitmapDrawableFactory.create(getResources(), bitmap2);
        roundedBitmapDrawable2.setCircular(true);
        imageView2.setImageDrawable(roundedBitmapDrawable2);


        buttonA = findViewById(R.id.cat1);
        buttonB = findViewById(R.id.cat2);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cat1:
                //createLevelsFormath();
                Intent intentKotlin = new Intent(MainActivity.this, Color.class);
                intentKotlin.putExtra("Category", Question.CATEGORY_ONE);
                startActivity(intentKotlin);
//                MediaPlayer myMedia1 = MediaPlayer.create(MainCategory.this, R.raw.math);
//                myMedia1.start();
                finish();
                break;

            case R.id.cat2:
                Intent intentFlutter = new Intent(MainActivity.this, Technologyterms.class);
                intentFlutter.putExtra("Category", Question.CATEGORY_TWO);
                startActivity(intentFlutter);
//                MediaPlayer myMedia2 = MediaPlayer.create(MainCategory.this, R.raw.spelling);
//                myMedia2.start();
                finish();
                break;
        }

    }



}