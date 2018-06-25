package com.fr0stsp1re.mediaplayersample;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private MediaPlayer myMediaPlayer;
    private Button playButton;
    private Button pauseButton;
    private Button skipForward;
    private Resources myResources;

    private double startTime = 0;
    private double finalTime = 0;
    private int forwardTime = 15000;
    private int backwardTime = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.play_button);
        pauseButton = (Button) findViewById(R.id.pause_button);
        skipForward = (Button) findViewById(R.id.skip_button);

        myMediaPlayer = MediaPlayer.create(this, R.raw.track1);
        myResources = getResources();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Now playing Fr0stsp1re mix 1", Toast.LENGTH_SHORT).show();
                finalTime = myMediaPlayer.getDuration();
                startTime = myMediaPlayer.getCurrentPosition();
                myMediaPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Paused", Toast.LENGTH_SHORT).show();
                myMediaPlayer.pause();
            }
        });

        skipForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp+forwardTime)<=finalTime){
                    startTime = startTime + forwardTime;
                    myMediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped forward 5seconds",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // TODO create a skip backward method

    }
}
