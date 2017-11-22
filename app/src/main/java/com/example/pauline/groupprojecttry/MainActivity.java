package com.example.pauline.groupprojecttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView value1 = null;
    TextView value2 = null;
    TextView value3 = null;
    TextView value4 = null;

    LinearLayout linearLayoutButtons = null;

    Integer int1 = 0;
    Integer int2 = 0;
    Integer int3 = 0;
    Integer int4 = 0;

    String valueSave = "";
    String valueButton = "";

    Integer[] arrayInt = {1, 2, 3, 4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go(View view) {
        RandomValueInt();

        value1 = (TextView) findViewById(R.id.value1);
        value2 = (TextView) findViewById(R.id.value2);
        value3 = (TextView) findViewById(R.id.value3);
        value4 = (TextView) findViewById(R.id.value4);
        value1.setText(int1.toString());
        value2.setText(int2.toString());
        value3.setText(int3.toString());
        value4.setText(int4.toString());

        valueSave = int1.toString() + int2.toString() + int3.toString() + int4.toString();

        final Thread t = new Thread() {

            @Override
            public void run() {
                try {
                        Thread.sleep(4000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // TextView update
                                value1.setText("");
                                value2.setText("");
                                value3.setText("");
                                value4.setText("");
                                valueButton = "";
                                linearLayoutButtons = (LinearLayout) findViewById(R.id.buttons);
                                linearLayoutButtons.setVisibility(View.VISIBLE);
                            }
                        });
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();

        final Thread t2 = new Thread() {

            @Override
            public void run() {
                try {
                        Thread.sleep(10000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // TextView update
                                checkSequence();
                            }
                        });
                } catch (InterruptedException e) {
                }
            }
        };
        t2.start();

        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                valueButton = valueButton + "1";
                Toast.makeText(getApplicationContext(), valueButton, Toast.LENGTH_SHORT).show();
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                valueButton = valueButton + "2";
                Toast.makeText(getApplicationContext(), valueButton, Toast.LENGTH_SHORT).show();
            }
        });

        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                valueButton = valueButton + "3";
                Toast.makeText(getApplicationContext(), valueButton, Toast.LENGTH_SHORT).show();
            }
        });

        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                valueButton = valueButton + "4";
                Toast.makeText(getApplicationContext(), valueButton, Toast.LENGTH_SHORT).show();
            }
        });

        final Button ok = findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkSequence();
                t2.interrupt();
            }
        });
    }

    public void RandomValueInt() {
        Random randomInt = new Random();
        int1 = randomInt.nextInt(arrayInt.length) + 1;
        int2 = randomInt.nextInt(arrayInt.length) + 1;
        int3 = randomInt.nextInt(arrayInt.length) + 1;
        int4 = randomInt.nextInt(arrayInt.length) + 1;
    }

    public void checkSequence() {
        if (valueSave.equals(valueButton)) {
            Toast.makeText(getApplicationContext(), "Right!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
        }
        linearLayoutButtons.setVisibility(View.INVISIBLE);
    }
}
