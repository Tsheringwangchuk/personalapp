package edu.gcit.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class Developer_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_page);

        ImageView imageView=(ImageView) findViewById(R.id.app_logo);
        ImageView imageView1=(ImageView) findViewById(R.id.col_logo);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.collegelogo);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        RoundedBitmapDrawable roundedBitmapDrawable1= RoundedBitmapDrawableFactory.create(getResources(), bitmap1);
        roundedBitmapDrawable.setCircular(true);
        roundedBitmapDrawable1.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);
        imageView1.setImageDrawable(roundedBitmapDrawable1);
     }
}