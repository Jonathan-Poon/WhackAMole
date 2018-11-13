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

public class fourbyfive extends AppCompatActivity {
    private ImageButton mole19,mole20,mole21,mole22,mole23,mole24,mole25,mole26,mole27,
            mole28,mole29,mole30,mole31,mole32,mole33,mole34,mole35,mole36,mole37,mole38;
    private int score,position;
    private CountDownTimer timer;
    private TextView scoreText, timeText;
    private Random random;
    private ArrayList<ImageButton> buttons;
    MediaPlayer mediaplayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourbyfive);

        mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.whackamole);
        mediaplayer.setLooping(true);
        mediaplayer.start();

        buttons = new ArrayList<ImageButton>();
        position = 0;
        score = 0;
        random = new Random();
        mole19 = (ImageButton) findViewById(R.id.mole19);
        mole20 = (ImageButton) findViewById(R.id.mole20);
        mole21 = (ImageButton) findViewById(R.id.mole21);
        mole22 = (ImageButton) findViewById(R.id.mole22);
        mole23 = (ImageButton) findViewById(R.id.mole23);
        mole24 = (ImageButton) findViewById(R.id.mole24);
        mole25 = (ImageButton) findViewById(R.id.mole25);
        mole26 = (ImageButton) findViewById(R.id.mole26);
        mole27 = (ImageButton) findViewById(R.id.mole27);
        mole28 = (ImageButton) findViewById(R.id.mole28);
        mole29 = (ImageButton) findViewById(R.id.mole29);
        mole30 = (ImageButton) findViewById(R.id.mole30);
        mole31 = (ImageButton) findViewById(R.id.mole31);
        mole32 = (ImageButton) findViewById(R.id.mole32);
        mole33 = (ImageButton) findViewById(R.id.mole33);
        mole34 = (ImageButton) findViewById(R.id.mole34);
        mole35 = (ImageButton) findViewById(R.id.mole35);
        mole36 = (ImageButton) findViewById(R.id.mole36);
        mole37 = (ImageButton) findViewById(R.id.mole37);
        mole38 = (ImageButton) findViewById(R.id.mole38);
        buttons.add(mole19);
        buttons.add(mole20);
        buttons.add(mole21);
        buttons.add(mole22);
        buttons.add(mole23);
        buttons.add(mole24);
        buttons.add(mole25);
        buttons.add(mole26);
        buttons.add(mole27);
        buttons.add(mole28);
        buttons.add(mole29);
        buttons.add(mole30);
        buttons.add(mole31);
        buttons.add(mole32);
        buttons.add(mole33);
        buttons.add(mole34);
        buttons.add(mole35);
        buttons.add(mole36);
        buttons.add(mole37);
        buttons.add(mole38);

        scoreText = (TextView) findViewById(R.id.score3);
        timeText = (TextView) findViewById(R.id.time3);

        for (ImageButton i : buttons) {
            i.setOnClickListener(buttonListener);
        }

        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time: " + millisUntilFinished / 1000);
                buttons.get(position).setVisibility(View.INVISIBLE);
                position = random.nextInt(20);
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
        startActivity(intent);
        intent.putExtra("finishedScore", score);
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
