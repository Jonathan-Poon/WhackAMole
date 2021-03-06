package com.example.poonj.whackamole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.whackamole);
        mediaplayer.setLooping(true);
        mediaplayer.start();

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start2x3();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start3x4();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start4x5();
            }
        });
    }
    public void start2x3() {
        mediaplayer.stop();
        Intent intent = new Intent(this, twobythree.class);
        startActivity(intent);
    }

    public void start3x4() {
        mediaplayer.stop();
        Intent intent = new Intent(this, threebyfour.class);
        startActivity(intent);
    }

    public void start4x5() {
        mediaplayer.stop();
        Intent intent = new Intent(this, fourbyfive.class);
        startActivity(intent);
    }
}
