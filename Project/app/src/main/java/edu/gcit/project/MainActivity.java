package edu.gcit.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    MediaPlayer matchsound, dragsound, spellingsound,mathsound;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.opennavdrawer,
        R.string.closenavdrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        matchsound = MediaPlayer.create(MainActivity.this, R.raw.match);
        dragsound = MediaPlayer.create(MainActivity.this, R.raw.drag);
        spellingsound = MediaPlayer.create(MainActivity.this, R.raw.spelling);
        mathsound = MediaPlayer.create(MainActivity.this, R.raw.math);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void matchingpage(View view) {
        matchsound.start();
        Intent match = new Intent(MainActivity.this, Matching.class);
        startActivity(match);
    }

    public void draganddroppage(View view) {
        dragsound.start();
        Intent drag = new Intent(MainActivity.this, draganddrop.class);
        startActivity(drag);
    }

    public void spellingpage(View view) {
        spellingsound.start();
        Intent spellwrite = new Intent(MainActivity.this, spelling.class);
        startActivity(spellwrite);
    }

    public void mathpage(View view) {
        mathsound.start();
        Intent maths = new Intent(MainActivity.this, Math.class);
        startActivity(maths);
    }
}