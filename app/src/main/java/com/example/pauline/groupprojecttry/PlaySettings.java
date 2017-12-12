package com.example.pauline.groupprojecttry;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlaySettings extends AppCompatActivity {

    Controller controller;
    Spinner ownedStylesSpinner;
    Spinner availableStylesSpinner;
    Player player;
    JSON json = new JSON();
    ArrayList<Integer> boughtStyles;
    List<String> stylesOwned = new ArrayList<>();
    List<String> stylesAvailable = new ArrayList<>();
    int selectedStylePos = 0;
    TextView coins;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_settings);

        controller = new Controller(this);
        player = json.loadPlayer(this);
        mContext = this;

        //update remaining lives of the player from json
        TextView lives = findViewById(R.id.lives);
        lives.setText(String.valueOf(controller.getPlayerLives()));

        //update remaining coins of the player from json
        coins = findViewById(R.id.coins);
        coins.setText(String.valueOf(controller.getPlayerCoins()));

        /* initiate a Switch */
        //Switch simpleSwitch = (Switch) findViewById(R.id.sound);

        /* set the current state of a Switch */
        //simpleSwitch.setChecked(true);

        // Spinner element for styles owned
        ownedStylesSpinner = findViewById(R.id.spinner);

        //second ownedStylesSpinner for bought styles
        availableStylesSpinner = findViewById(R.id.spinner2);

        addBoughtStyles();
        prepareOwnedStylesSpinner();
        prepareAvailableStylesSpinner();
    }

    private void addBoughtStyles() {
        // Add the bought styles
        boughtStyles = player.getBoughtStyles();
        int preferedStyle = player.getPreferedStyle();
        int i = 0;
        for (Integer id : boughtStyles) {
            Style boughtStyle = Style.build(id);
            stylesOwned.add(boughtStyle.getName());
            if (id == preferedStyle) {
                selectedStylePos = i;
            }
            i++;
        }
    }

    private void prepareOwnedStylesSpinner() {
        // Creating adapter for ownedStylesSpinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stylesOwned);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to ownedStylesSpinner
        ownedStylesSpinner.setAdapter(dataAdapter);
        ownedStylesSpinner.setSelection(selectedStylePos);
        ownedStylesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String item = ownedStylesSpinner.getItemAtPosition(position).toString();
                Style boughtStyle = Style.build(item);
                player.setPreferedStyle(boughtStyle.getId());

                //save json
                json.savePlayer(mContext, player);

                // Showing selected ownedStylesSpinner item
                Toast.makeText(ownedStylesSpinner.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    private void prepareAvailableStylesSpinner() {
        //Manage the second adapter to add the styles not bought
        List<Style> allStyle = controller.allStyles();

        for (Style style : allStyle) {
            if (!controller.isStyleBought(style.getId())) {
                stylesAvailable.add(style.getName());
            }
        }

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stylesAvailable);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        availableStylesSpinner.setAdapter(dataAdapter2);
    }

    public void buyStyle(View view) {

        if (availableStylesSpinner.getSelectedItem() == null) {
            Toast.makeText(ownedStylesSpinner.getContext(), "No more style to buy!", Toast.LENGTH_LONG).show();
        } else if (controller.canPay(20)) {
                player.paidCoins(20);
                coins.setText(String.valueOf(player.getCoins()));

                String valueSpinner = (String) availableStylesSpinner.getItemAtPosition(availableStylesSpinner.getSelectedItemPosition());

                Style boughtStyle = Style.build(valueSpinner);
                boughtStyles.add(boughtStyle.getId());
                player.addBoughtStyle(boughtStyle.getId());

                stylesOwned.clear();
                stylesAvailable.clear();
                json.savePlayer(this, player);
                controller = new Controller(this);
                player = json.loadPlayer(this);

                addBoughtStyles();

                List<Style> allStyle = controller.allStyles();

                for (Style style : allStyle) {
                    if (!controller.isStyleBought(style.getId())) {
                        stylesAvailable.add(style.getName());
                    }
                }

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stylesOwned);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ownedStylesSpinner.setAdapter(dataAdapter);

                ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stylesAvailable);
                dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                availableStylesSpinner.setAdapter(dataAdapter2);
        } else {
            Toast.makeText(ownedStylesSpinner.getContext(), "You can't buy! You need more money!", Toast.LENGTH_LONG).show();
        }

    }

    public void exit(View view) {
        Intent intent = new Intent(this, StartPageActivity.class);
        startActivity(intent);
    }
}
