package com.example.poonj.whackamole;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finalScreen extends AppCompatActivity {
    private Button restart,exit;
    private int score;
    private TextView finalScore;
    MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.whackamole);
        mediaplayer.setLooping(true);
        mediaplayer.start();

        finalScore = (TextView) findViewById(R.id.finalScreenScore);
        score = getIntent().getIntExtra("finishedScore",0);
        finalScore.setText("Score: " + score);

        restart = (Button) findViewById(R.id.restart);
        exit = (Button) findViewById(R.id.exit);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer.stop();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer.stop();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
    }
}
