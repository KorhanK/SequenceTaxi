package com.example.pauline.groupprojecttry;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GamePage extends AppCompatActivity {

    Controller controller;


    //JSON json = new JSON();
   // Player player;

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;

    ArrayList<ImageView> images;

    Handler handler1;
    Handler handler2;
    Runnable r1;
    Runnable r2;
    LinearLayout linearLayoutButtons;

    //Sequence sequence;
    int countClickButtons = 0;
    //int level;
    boolean finishedHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        controller = new Controller(this);

        linearLayoutButtons = (LinearLayout) findViewById(R.id.buttons);
        images = new ArrayList<>();

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        image6 = (ImageView) findViewById(R.id.image6);
        image7 = (ImageView) findViewById(R.id.image7);
        image8 = (ImageView) findViewById(R.id.image8);

        startSequence();
    }


    public void imageSetter(ArrayList<Integer> sequence){
        int total = sequence.size();
        //total += 2;
        for (int i = 0; i < total; i++) {
            if (sequence.get(i) == 1)
                images.get(i).setBackgroundResource(R.drawable.left_white);
            else if (sequence.get(i) == 2)
                images.get(i).setBackgroundResource(R.drawable.up_button);
            else if (sequence.get(i) == 3)
                images.get(i).setBackgroundResource(R.drawable.down_button);
            else if (sequence.get(i) == 4)
                images.get(i).setBackgroundResource(R.drawable.right_button);
        }
    }

    public void imageCleaner(){
        for (int i = 0; i < controller.getSequenceOfNumber().size(); i++)
            images.get(i).setBackground(null);
    }

    public void alertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(message);
        alert.setCancelable(false);
        alert.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                dialog.cancel();
                startSequence();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    public void onClickButton(int valueClick) {
        countClickButtons++;
        //Toast.makeText(getApplicationContext(), String.valueOf(countClickButtons), Toast.LENGTH_SHORT).show();
        controller.sequenceSetUserInputs(valueClick);
        checkSequence();
    }

    public void checkSequence() {
        if (countClickButtons == controller.getPlayerLevel() + 2 || finishedHandler) {

            if (controller.checkSequence()) {
                alertMessage("Right");
                controller.upLevel();
            } else {
                alertMessage("Wrong");
            }
            linearLayoutButtons.setVisibility(View.INVISIBLE);
            handler2.removeCallbacks(r2);
            countClickButtons = 0;
            controller.clearSequence(this);
        }
    }

//    public void upLevel() {
//        player.setLevel(level + 1);
//        json.savePlayer(this, player);
//        //Toast.makeText(getApplicationContext(), String.valueOf(player.getLevel()), Toast.LENGTH_SHORT).show();
//    }


    public void startSequence() {
        linearLayoutButtons.setVisibility(View.VISIBLE);
        TextView lives = findViewById(R.id.lives);
        lives.setText(String.valueOf(controller.getPlayerLives()));

        TextView coins = findViewById(R.id.coins);
        coins.setText(String.valueOf(controller.getPlayerCoins()));
        controller.createSequence();


        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);

        imageSetter(controller.getSequenceOfNumber());

        handler1 = new Handler();
        r1 = new Runnable() {
            @Override
            public void run() {
                imageCleaner();
                linearLayoutButtons.setVisibility(View.VISIBLE);
            }
        };
        handler1.postDelayed(r1, 4000);

        finishedHandler = false;
        handler2 = new Handler();
        r2 = new Runnable() {
            @Override
            public void run() {
                finishedHandler = true;
                checkSequence();
            }
        };
        handler2.postDelayed(r2, 10000);


        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickButton(1);
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickButton(2);
            }
        });

        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickButton(3);
            }
        });

        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickButton(4);
            }
        });

    }

}
