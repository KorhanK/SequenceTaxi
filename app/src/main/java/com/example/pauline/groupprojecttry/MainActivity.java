//package com.example.pauline.groupprojecttry;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.Spinner;
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//
//    Sequence sequence;
//
//    LinearLayout linearLayoutButtons;
//    ArrayAdapter<String> adapter;
//    Spinner spinner;
//
//    Thread thread2 = null;
//
//    Integer[] nbSequence = {3, 4, 5, 6, 7, 8};
//
//    Integer lengthSequence = 0;
//
//    int countClickButtons = 0;
//
//    ImageView image1;
//    ImageView image2;
//    ImageView image3;
//    ImageView image4;
//    ImageView image5;
//    ImageView image6;
//    ImageView image7;
//    ImageView image8;
//
//    ArrayList<ImageView> images;
//
//    Button goButton;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        linearLayoutButtons = (LinearLayout) findViewById(R.id.buttons);
//        images = new ArrayList<>();
//
//        ownedStylesSpinner = findViewById(R.id.ownedStylesSpinner);
//        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.nbSequence);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        image1 = (ImageView) findViewById(R.id.image1);
//        image2 = (ImageView) findViewById(R.id.image2);
//        image3 = (ImageView) findViewById(R.id.image3);
//        image4 = (ImageView) findViewById(R.id.image4);
//        image5 = (ImageView) findViewById(R.id.image5);
//        image6 = (ImageView) findViewById(R.id.image6);
//        image7 = (ImageView) findViewById(R.id.image7);
//        image8 = (ImageView) findViewById(R.id.image8);
//
//        goButton = (Button) findViewById(R.id.goButton);
//
//        final Button button1 = findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                onClickButton(1);
//            }
//        });
//
//        final Button button2 = findViewById(R.id.button2);
//        button2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                onClickButton(2);
//            }
//        });
//
//        final Button button3 = findViewById(R.id.button3);
//        button3.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                onClickButton(3);
//            }
//        });
//
//        final Button button4 = findViewById(R.id.button4);
//        button4.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                onClickButton(4);
//            }
//        });
//       go();
//    }
//
//    public void go() {
//        lengthSequence = (Integer) ownedStylesSpinner.getItemAtPosition(ownedStylesSpinner.getSelectedItemPosition());
//
//        sequence = new Sequence(lengthSequence);
//
//        goButton.setVisibility(View.INVISIBLE);
//
//        images.add(image1);
//        images.add(image2);
//        images.add(image3);
//        images.add(image4);
//        images.add(image5);
//        images.add(image6);
//        images.add(image7);
//        images.add(image8);
//
//        imageSetter(sequence.sequenceOfNumbers);
//
//        Thread thread = new Thread() {
//
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(4000);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            imageCleaner();
//                            linearLayoutButtons.setVisibility(View.VISIBLE);
//                        }
//                    });
//                } catch (InterruptedException e) {
//                }
//            }
//        };
//        thread.start();
//
//        thread2 = new Thread() {
//
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            checkSequence();
//                        }
//                    });
//                } catch (InterruptedException e) {
//                }
//            }
//        };
//        thread2.start();
//    }
//
//    public void imageSetter(ArrayList<Integer> sequence){
//
//        for (int i = 0; i < sequence.size(); i++) {
//            if (sequence.get(i) == 1)
//                images.get(i).setBackgroundResource(R.drawable.left_button);
//            else if (sequence.get(i) == 2)
//                images.get(i).setBackgroundResource(R.drawable.up_button);
//            else if (sequence.get(i) == 3)
//                images.get(i).setBackgroundResource(R.drawable.down_button);
//            else if (sequence.get(i) == 4)
//                images.get(i).setBackgroundResource(R.drawable.right_button);
//        }
//    }
//
//    public void imageCleaner(){
//        for (int i = 0; i < sequence.sequenceOfNumbers.size(); i++)
//        images.get(i).setBackground(null);
//    }
//
//
//    public void alertMessage(String message) {
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        alert.setMessage(message);
//        alert.setCancelable(false);
//        alert.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog,int id) {
//                dialog.cancel();
//            }
//        });
//        AlertDialog alertDialog = alert.create();
//        alertDialog.show();
//    }
//
//    public void onClickButton(int valueClick) {
//        countClickButtons++;
//        sequence.setUserInputs(valueClick);
//        checkSequence();
//
//    }
//
//    public void changeSet(View v){
//        findViewById(R.id.button1).setBackgroundResource(R.drawable.one);
//        findViewById(R.id.button2).setBackgroundResource(R.drawable.two);
//        findViewById(R.id.button3).setBackgroundResource(R.drawable.three);
//        findViewById(R.id.button4).setBackgroundResource(R.drawable.four);
//    }
//
//    public void checkSequence() {
//
//        try {
//            if (countClickButtons == lengthSequence || !thread2.isAlive()) {
//
//                if (sequence.check()) {
//                    alertMessage("Right");
//                } else {
//                    alertMessage("Wrong");
//                }
//                linearLayoutButtons.setVisibility(View.INVISIBLE);
//                thread2.interrupt();
//                countClickButtons = 0;
//                sequence.clearSequence();
//                goButton.setVisibility(View.VISIBLE);
//            }
//        }
//        catch(Exception e){
//        }
//
//    }
//
//    public void gamePage(View view) {
//        Intent intent = new Intent(this, GamePage.class);
//        startActivity(intent);
//    }
//}
//
