package edu.gcit.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class draganddrop extends AppCompatActivity {
    LinearLayout target1;
    Button test1, btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draganddrop);
        target1 = (LinearLayout) findViewById(R.id.target1);
        test1 = (Button) findViewById(R.id.test1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        target1.setOnDragListener(dragListenre);
        btn1.setOnLongClickListener(longclickListener);
        btn2.setOnLongClickListener(longclickListener);
        btn3.setOnLongClickListener(longclickListener);
    }

        View.OnLongClickListener longclickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData data = ClipData.newPlainText("", " ");
                View.DragShadowBuilder myShadwoBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, myShadwoBuilder, v, 0);

                return true;
            }
        };

        View.OnDragListener dragListenre = new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int dragEvent = event.getAction();
                final View view = (View) event.getLocalState();

                switch (dragEvent) {
                    case DragEvent.ACTION_DROP:
                        {
                        if (view.getId() == R.id.btn1 && v.getId() == R.id.target1) {
                            LinearLayout oldparent = (LinearLayout) view.getParent();
                            oldparent.removeView(view);
                            LinearLayout newParent = (LinearLayout) v;
                            test1.setVisibility(View.GONE);
                            newParent.addView(view);
                        } else {
                            MediaPlayer myMedia = MediaPlayer.create(draganddrop.this, R.raw.wrong);
                            myMedia.start();
                        }
                        break;
                    }
                }
                return true;
            }
        };

}