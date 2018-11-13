package com.example.poonj.whackamole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class twobythree extends AppCompatActivity {
    private ImageButton mole1,mole2,mole3,mole4,mole5,mole6;
    private int score,position;
    private CountDownTimer timer;
    private TextView scoreText, timeText;
    private Random random;
    private ArrayList<ImageButton> buttons;
    MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twobythree);

        mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.whackamole);
        mediaplayer.setLooping(true);
        mediaplayer.start();

        buttons = new ArrayList<ImageButton>();
        position = 0;
        score = 0;
        random = new Random();
        mole1 = (ImageButton) findViewById(R.id.mole1);
        mole2 = (ImageButton) findViewById(R.id.mole2);
        mole3 = (ImageButton) findViewById(R.id.mole3);
        mole4 = (ImageButton) findViewById(R.id.mole4);
        mole5 = (ImageButton) findViewById(R.id.mole5);
        mole6 = (ImageButton) findViewById(R.id.mole6);
        buttons.add(mole1);
        buttons.add(mole2);
        buttons.add(mole3);
        buttons.add(mole4);
        buttons.add(mole5);
        buttons.add(mole6);
        scoreText = (TextView) findViewById(R.id.scoreValue);
        timeText = (TextView) findViewById(R.id.timeValue);



        for (ImageButton i : buttons) {
            i.setOnClickListener(buttonListener);
        }

        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("" + millisUntilFinished / 1000);
                buttons.get(position).setVisibility(View.INVISIBLE);
                position = random.nextInt(6);
                buttons.get(position).setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                timeText.setText("0");
                buttons.get(position).setVisibility(View.INVISIBLE);
                toFinal();
            }
        };
        timer.start();
    }


    public void toFinal() {
        mediaplayer.stop();
        Intent intent = new Intent(getApplicationContext(), finalScreen.class);
        intent.putExtra("finishedScore", score);
        startActivity(intent);
    }
    private final View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score += 1;
            scoreText.setText("" + score);
            buttons.get(position).setVisibility(View.INVISIBLE);
        }
    };


}
