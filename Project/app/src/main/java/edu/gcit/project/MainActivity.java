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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //sounds in a app for category
    MediaPlayer matchsound, dragsound, spellingsound,mathsound;
    //nagivation_drawer
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar on action bar
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.opennavdrawer,
        R.string.closenavdrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        Log.d("Msg:","I am here");

        //sounds for category
        matchsound = MediaPlayer.create(MainActivity.this, R.raw.match);
        dragsound = MediaPlayer.create(MainActivity.this, R.raw.drag);
        spellingsound = MediaPlayer.create(MainActivity.this, R.raw.spelling);
        mathsound = MediaPlayer.create(MainActivity.this, R.raw.math);
    }

    //navigation drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.share:
                try
                {
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    String message = "share this app";
                    share.putExtra(Intent.EXTRA_SUBJECT, "message");
                    share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                    Log.d("Checking","https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                    startActivity(Intent.createChooser(share, "Share With"));

                }
                catch (Exception e)
                {
                    Toast.makeText(this, "Unable to share this app", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rate:
                try
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));

                }
                catch (Exception r)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details/?id="+getPackageName())));
                }
                break;

            case R.id.feedback:
                try
                {
                    Intent feedback = new Intent(this, Mainfeedback.class);
                    startActivity(feedback);
                }
                catch (Exception e)
                {
                    Log.d("Msg:","It is not working");
                }
                break;

            case R.id.about:
                try
                {
                    Intent about = new Intent(this, Developer_page.class);
                    startActivity(about);
                }
                catch (Exception r)
                {
                    Log.d("Msg:","It is not working");
                }
                break;

            case R.id.exit:
                try
                {
                   finish();
                    //System system;
                    System.exit(0);
                }
                catch (Exception r)
                {
                    Log.d("Msg:","It is not working");
                }
                break;
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    //redirect to match page
    public void matchingpage(View view) {
        matchsound.start();
        Intent match = new Intent(MainActivity.this, Matching.class);
        startActivity(match);
    }
    //redirect to draganddrop page
    public void draganddroppage(View view) {
        dragsound.start();
        Intent drag = new Intent(MainActivity.this, draganddrop.class);
        startActivity(drag);
    }
    //redirect to spellingwriting page
    public void spellingpage(View view) {
        spellingsound.start();
        Intent spellwrite = new Intent(MainActivity.this, spelling.class);
        startActivity(spellwrite);
    }
    //redirect to math page
    public void mathpage(View view) {
        mathsound.start();
        //Intent maths = new Intent(MainActivity.this, Math.class);
        //startActivity(maths);
    }
}