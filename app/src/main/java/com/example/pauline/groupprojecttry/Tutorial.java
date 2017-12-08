package com.example.pauline.groupprojecttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tutorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

    }

    public void goBack(View view){
        Intent intent =  new Intent(Tutorial.this, StartPageActivity.class);
        startActivity(intent);
    }
}
