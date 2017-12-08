package com.example.pauline.groupprojecttry;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * GameNameActivity is an android interface class that initializes the ProgressBar, progressStatus, textView and handler fields.
 * The class also shows how the app is loading the game
 */
public class GameNameActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 25;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_name);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);
        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display

                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }

                    });
                    try {
                        // Sleep for 200 milliseconds.

                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                nextcall();
            }
        }).start();

    }

    private void nextcall(){
        Intent intent=new Intent(GameNameActivity.this,StartPageActivity.class);
        startActivity(intent);

    }

}

