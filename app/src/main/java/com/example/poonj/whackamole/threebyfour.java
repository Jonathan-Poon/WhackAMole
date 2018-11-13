package com.example.poonj.whackamole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class threebyfour extends AppCompatActivity {
    private ImageButton mole7,mole8,mole9,mole10,mole11,mole12,mole13,mole14,mole15,mole16,mole17,mole18;
    private int score,position;
    private CountDownTimer timer;
    private TextView scoreText, timeText;
    private Random random;
    private ArrayList<ImageButton> buttons;
    MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threebyfour);

        mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.whackamole);
        mediaplayer.setLooping(true);
        mediaplayer.start();

        buttons = new ArrayList<ImageButton>();
        position = 0;
        score = 0;
        random = new Random();
        mole7 = (ImageButton) findViewById(R.id.mole7);
        mole8 = (ImageButton) findViewById(R.id.mole8);
        mole9 = (ImageButton) findViewById(R.id.mole9);
        mole10 = (ImageButton) findViewById(R.id.mole10);
        mole11 = (ImageButton) findViewById(R.id.mole11);
        mole12 = (ImageButton) findViewById(R.id.mole12);
        mole13 = (ImageButton) findViewById(R.id.mole13);
        mole14 = (ImageButton) findViewById(R.id.mole14);
        mole15 = (ImageButton) findViewById(R.id.mole15);
        mole16 = (ImageButton) findViewById(R.id.mole16);
        mole17 = (ImageButton) findViewById(R.id.mole17);
        mole18 = (ImageButton) findViewById(R.id.mole18);
        buttons.add(mole7);
        buttons.add(mole8);
        buttons.add(mole9);
        buttons.add(mole10);
        buttons.add(mole11);
        buttons.add(mole12);
        buttons.add(mole13);
        buttons.add(mole14);
        buttons.add(mole15);
        buttons.add(mole16);
        buttons.add(mole17);
        buttons.add(mole18);
        scoreText = (TextView) findViewById(R.id.score2);
        timeText = (TextView) findViewById(R.id.time2);

        for (ImageButton i : buttons) {
            i.setOnClickListener(buttonListener);
        }

        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time: " + millisUntilFinished / 1000);
                buttons.get(position).setVisibility(View.INVISIBLE);
                position = random.nextInt(12);
                buttons.get(position).setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                timeText.setText("Time: 0");
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
            scoreText.setText("Score: " + score);
            buttons.get(position).setVisibility(View.INVISIBLE);
        }
    };
}
