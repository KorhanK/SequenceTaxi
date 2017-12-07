package com.example.pauline.groupprojecttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPageActivity extends AppCompatActivity {

    //For what are this buttons?
    //public Button gobtn;
    //public Button exitbtn;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        //For what are this buttons?
        //gobtn = findViewById(R.id.goButton);
        //exitbtn = findViewById(R.id.button2);

    }

    public void goMethod(View view){
        Intent intent= new Intent(StartPageActivity.this,GamePage.class);
        startActivity(intent);
    }

    public void settings(View view) {
        Intent intent = new Intent(this, PlaySettings.class);
        startActivity(intent);
    }

    public void goTutorial(View view) {
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }

}






