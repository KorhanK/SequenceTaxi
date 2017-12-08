package com.example.pauline.groupprojecttry;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaySettings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Controller controller;
    Spinner spinner;
    Spinner spinner2;
    Player player;
    JSON json = new JSON();
    Button buyButton;
    ArrayList<Integer> boughtStyle;
    List<String> categories2 = new ArrayList<String>();
    List<String> categories;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_settings);

        //buyButton = (Button)findViewById(R.id.buy);
        //buyButton.setVisibility(View.INVISIBLE);


        controller = new Controller(this);
        player = json.loadPlayer(this);
        mContext = this;

        //update remaining lives of the player from json
        TextView lives = findViewById(R.id.lives);
        lives.setText(String.valueOf(controller.getPlayerLives()));

        //update remaining coins of the player from json
        TextView coins = findViewById(R.id.coins);
        coins.setText(String.valueOf(controller.getPlayerCoins()));

        /* initiate a Switch */
        Switch simpleSwitch = (Switch) findViewById(R.id.sound);

        /* set the current state of a Switch */
        simpleSwitch.setChecked(true);

        // Spinner element for categories
        spinner = (Spinner) findViewById(R.id.spinner);

        //second spinner for bought styles
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        categories = new ArrayList<String>();

        //Manage the first spinner to add the bought style
        boughtStyle = player.getBoughtStyle();
        for(int i = 0; i < boughtStyle.size(); i++) {
            if (boughtStyle.get(i) == 0) {
                categories.add("directions");
            }
            if (boughtStyle.get(i) == 1) {
                categories.add("animals");
            }
            if (boughtStyle.get(i) == 2) {
                categories.add("numbers");
            }
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setSelection(player.getPreferedStyle());

        //Manage the second adapter to add the style don't bought



        HashMap<Integer, String> allStyle = new HashMap<>();
        allStyle = controller.allStyle();

        for (int i = 0; i < allStyle.size(); i++) {
            if (!controller.searchBoughtStyle(i)) {
                categories2.add(controller.getStyle(i));
            }
        }

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String item = spinner.getItemAtPosition(position).toString();

                int pos = 0;
                if (item.equals("directions")) {
                    pos = 0;
                }
                if (item.equals("animals")) {
                    pos = 1;
                }
                if (item.equals("numbers")) {
                    pos = 2;
                }

                player.setPreferedStyle(pos);

                //save json
                json.savePlayer(mContext, player);

                // Showing selected spinner item
                Toast.makeText(spinner.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }


    public void buyStyle(View view) {

        String valueSpinner = (String) spinner2.getItemAtPosition(spinner2.getSelectedItemPosition());

        if (valueSpinner.equals("animals")) {
            //if (controller.getPlayerCoins() >= 50) {
                boughtStyle.add(1);
                //player.setCoins(controller.getPlayerCoins() - 50); // this amount can be changed
            //}
        }
        if(valueSpinner.equals("numbers")) {
            //if(controller.getPlayerCoins() >= 50) {
                boughtStyle.add(2);
                //player.setCoins(controller.getPlayerCoins() - 50);
            //}
        }

        //////////////
        categories.clear();
        categories2.clear();
        json.savePlayer(this, player);
        controller = new Controller(this);
        player = json.loadPlayer(this);
        boughtStyle = player.getBoughtStyle();
        for(int i = 0; i < boughtStyle.size(); i++) {
            if (boughtStyle.get(i) == 0) {
                categories.add("directions");
            }
            if (boughtStyle.get(i) == 1) {
                categories.add("animals");
            }
            if (boughtStyle.get(i) == 2) {
                categories.add("numbers");
            }
        }

        HashMap<Integer, String> allStyle = new HashMap<>();
        allStyle = controller.allStyle();

        for (int i = 0; i < allStyle.size(); i++) {
            if (!controller.searchBoughtStyle(i)) {
                categories2.add(controller.getStyle(i));
            }
        }
        //////////////
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);


    }




        @Override
        public void onItemSelected(final AdapterView<?> adapterView, View view, int i, long l) {





        // On selecting a spinner item


        //Cut and paste the following code to the class where you control the spinner
        // Bundle bundle=getIntent().getExtras();
        //String data=bundle.get("data").toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void exit() {
        Intent intent =  new Intent(PlaySettings.this, StartPageActivity.class); // Change the mainActivity to the game page
        //intent.putExtra("data", String.valueOf(spinner.getSelectedItem()));
        startActivity(intent);
    }
}
