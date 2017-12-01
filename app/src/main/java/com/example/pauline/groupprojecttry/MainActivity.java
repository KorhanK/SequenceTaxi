//package com.example.pauline.groupprojecttry;
//
//import android.content.DialogInterface;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.Random;
//
//public class MainActivity extends AppCompatActivity {
//
//    TextView sequence = null;
//    Random randomInt;
//
//    LinearLayout linearLayoutButtons;
//
//    ArrayAdapter<String> adapter;
//    Spinner spinner;
//
//    Thread thread2 = null;
//
//    StringBuilder generatedSequence = new StringBuilder();
//    StringBuilder userSequence = new StringBuilder();
//
//    Integer[] nbSequence = {3, 4, 5, 6, 7, 8, 9, 10};
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
//    ImageView image9;
//    ImageView image10;
//
//
//
//    ArrayList<Integer> sequenceOfNumbers;
//    ArrayList<ImageView> images;
//    ArrayList<Integer> userInputs;
//
//    String type = "directions";
//
//    Button goButton;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        sequenceOfNumbers = new ArrayList<>();
//        images = new ArrayList<>();
//
//        spinner = findViewById(R.id.spinner);
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
//        image9 = (ImageView) findViewById(R.id.image9);
//        image10 = (ImageView) findViewById(R.id.image10);
//
//        goButton = (Button) findViewById(R.id.goButton);
//
//        userInputs = new ArrayList<>();
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
//        lengthSequence = (Integer) spinner.getItemAtPosition(spinner.getSelectedItemPosition());
//        goButton.setVisibility(View.INVISIBLE);
//        randomValueInt(lengthSequence);
//
//
//        images.add(image1);
//        images.add(image2);
//        images.add(image3);
//        images.add(image4);
//        images.add(image5);
//        images.add(image6);
//        images.add(image7);
//        images.add(image8);
//        images.add(image9);
//        images.add(image10);
//
//        imageSetter(sequenceOfNumbers);
//
//
//        //sequence = (TextView) findViewById(R.id.sequence);
//        //sequence.setText(generatedSequence.toString());
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
//                            //sequence.setText("");
//
//                            //userSequence.delete(0, userSequence.length());
//                            imageCleaner();
//                            linearLayoutButtons = (LinearLayout) findViewById(R.id.buttons);
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
//
//
//    }
//
//    public void randomValueInt(int nb) {
//        randomInt = new Random();
//        int value;
//        for (int i = 0; i < nb; i++) {
//            value = randomInt.nextInt(4) + 1;
//            //generatedSequence.append(value);
//            sequenceOfNumbers.add(value);
//
//        }
//
//    }
//
//    public void imageSetter(ArrayList<Integer> sequence){
//
//        if(type.equals("directions")) {
//            for (int i = 0; i < sequence.size(); i++) {
//                if (sequence.get(i) == 1)
//                    images.get(i).setBackgroundResource(R.drawable.left_button);
//                else if (sequence.get(i) == 2)
//                    images.get(i).setBackgroundResource(R.drawable.up_button);
//                else if (sequence.get(i) == 3)
//                    images.get(i).setBackgroundResource(R.drawable.down_button);
//                else if (sequence.get(i) == 4)
//                    images.get(i).setBackgroundResource(R.drawable.right_button);
//            }
//        }
//        else if (type.equals("numbers")) {
//            for (int i = 0; i < sequence.size(); i++) {
//                if (sequence.get(i) == 1)
//                    images.get(i).setBackgroundResource(R.drawable.one);
//                else if (sequence.get(i) == 2)
//                    images.get(i).setBackgroundResource(R.drawable.two);
//                else if (sequence.get(i) == 3)
//                    images.get(i).setBackgroundResource(R.drawable.three);
//                else if (sequence.get(i) == 4)
//                    images.get(i).setBackgroundResource(R.drawable.four);
//            }
//        }
//
//    }
//
//    public void imageCleaner(){
//        for (int i = 0; i<sequenceOfNumbers.size(); i++)
//        images.get(i).setBackground(null);
//
//
//    }
//
//    public void checkSequence() {
//
//        try {
//            if (countClickButtons == lengthSequence || !thread2.isAlive()) {
//
//                boolean isCorrect = true;
//                //Log.i("OnClick", String.valueOf(sequenceOfNumbers.size()));
//                for (int i = 0; i < sequenceOfNumbers.size(); i++) {
//
//
//                        if (userInputs.get(i) != sequenceOfNumbers.get(i))
//                            isCorrect = false;
//
//                }
//
//
//                if (isCorrect) {
//                    alertMessage("Right");
//                } else {
//                    alertMessage("Wrong");
//                }
//                linearLayoutButtons.setVisibility(View.INVISIBLE);
//                thread2.interrupt();
//                //generatedSequence.delete(0, lengthSequence);
//                countClickButtons = 0;
//                sequenceOfNumbers.clear();
//                userInputs.clear();
//                goButton.setVisibility(View.VISIBLE);
//                userSequence = null;
//            } else
//                return;
//        }
//        catch(Exception e){
//
//        }
//
//    }
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
//        userInputs.add(valueClick);
//        //userSequence.append(valueClick);
//        //Toast.makeText(getApplicationContext(), userSequence.toString(), Toast.LENGTH_SHORT).show();
//        checkSequence();
//
//    }
//
//    public void changeSet(View v){
//        if(type.equals("directions")) {
//            type = "numbers";
//            findViewById(R.id.button1).setBackgroundResource(R.drawable.one);
//            findViewById(R.id.button2).setBackgroundResource(R.drawable.two);
//            findViewById(R.id.button3).setBackgroundResource(R.drawable.three);
//            findViewById(R.id.button4).setBackgroundResource(R.drawable.four);
//        }
//        else if (type.equals("numbers")) {
//            type = "directions";
//            findViewById(R.id.button1).setBackgroundResource(R.drawable.left_button);
//            findViewById(R.id.button2).setBackgroundResource(R.drawable.up_button);
//            findViewById(R.id.button3).setBackgroundResource(R.drawable.down_button);
//            findViewById(R.id.button4).setBackgroundResource(R.drawable.right_button);
//        }
//
//    }
//}
//
