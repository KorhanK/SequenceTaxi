package com.example.pauline.groupprojecttry;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView sequence = null;
    Random randomInt;

    LinearLayout linearLayoutButtons;

    ArrayAdapter<String> adapter;
    Spinner spinner;

    Thread thread2 = null;

    StringBuilder generatedSequence = new StringBuilder();
    StringBuilder userSequence = new StringBuilder();

    Integer[] nbSequence = {3, 4, 5, 6, 7, 8, 9, 10};

    Integer lengthSequence = 0;

    int countClickButtons = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.nbSequence);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickButton("1");
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickButton("2");
            }
        });

        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickButton("3");
            }
        });

        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickButton("4");
            }
        });
    }

    public void go(View view) {
        lengthSequence = (Integer) spinner.getItemAtPosition(spinner.getSelectedItemPosition());

        randomValueInt(lengthSequence);

        sequence = (TextView) findViewById(R.id.sequence);
        sequence.setText(generatedSequence.toString());

        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            sequence.setText("");

                            userSequence.delete(0, userSequence.length());

                            linearLayoutButtons = (LinearLayout) findViewById(R.id.buttons);
                            linearLayoutButtons.setVisibility(View.VISIBLE);
                        }
                    });
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();

        thread2 = new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            checkSequence();
                        }
                    });
                } catch (InterruptedException e) {
                }
            }
        };
        thread2.start();


    }

    public void randomValueInt(int nb) {
        randomInt = new Random();
        int value;
        for (int i = 0; i < nb; i++) {
            value = randomInt.nextInt(4) + 1;
            generatedSequence.append(value);
        }

    }

    public void checkSequence() {
        if (countClickButtons == lengthSequence || !thread2.isAlive()) {
            if (generatedSequence.toString().equals(userSequence.toString())) {
                alertMessage("Right");
            } else {
                alertMessage("Wrong");
            }
            linearLayoutButtons.setVisibility(View.INVISIBLE);
            thread2.interrupt();
            generatedSequence.delete(0, lengthSequence);
            countClickButtons = 0;
        }
    }

    public void alertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(message);
        alert.setCancelable(false);
        alert.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    public void onClickButton(String valueClick) {
        countClickButtons++;
        userSequence.append(valueClick);
        Toast.makeText(getApplicationContext(), userSequence.toString(), Toast.LENGTH_SHORT).show();
        checkSequence();
    }

}