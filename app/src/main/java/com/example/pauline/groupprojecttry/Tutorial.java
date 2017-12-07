package com.example.pauline.groupprojecttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Tutorial extends AppCompatActivity {

    //Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        //goBackButton = (Button)findViewById(R.id.goBackStartPageButton);


       // goBackButton.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
               // Intent intent =  new Intent(Tutorial.this, StartPageActivity.class); // Change the mainActivity to the game page
               // startActivity(intent);
            }
       // });


    //}

    public void goBack(View view){
       Intent intent =  new Intent(Tutorial.this, StartPageActivity.class);
       startActivity(intent);
    }
}
