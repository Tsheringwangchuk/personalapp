package edu.gcit.project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MatchingLevel1 extends AppCompatActivity
{
    ImageView imageView;
    ImageView curView=null;
    private int countPair=0;
    final int[] drawable = new int[]{R.drawable.chili,R.drawable.cucumber,R.drawable.pumkin,R.drawable.radish,R.drawable.tomato};

    int[] pos={0,1,2,3,4,0,1,2,3,4};
    int currentPos=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_level1);



        GridView gridView=(GridView)findViewById(R.id.gridView);
        ImageAdaptar imageAdaptar=new ImageAdaptar(this);
        gridView.setAdapter(imageAdaptar);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentPos<0)
                {
                    currentPos = position;
                    curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }
                else
                {
                    if(currentPos==position)
                    {
                        ((ImageView)view).setImageResource(R.drawable.icon);
                    }
                    else if (pos[currentPos]!=pos[position])
                    {
                        curView.setImageResource(R.drawable.icon);
                        MediaPlayer mymedia = MediaPlayer.create(MatchingLevel1.this, R.raw.wrong);
                        mymedia.start();
                    }
                    else
                    {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        countPair++;
                        if(countPair==0)
                        {
                            Toast.makeText(getApplicationContext(), "You Win", Toast.LENGTH_SHORT).show();
                        }
                    }
                    currentPos = -1;
                }
            }
        });
    }

}