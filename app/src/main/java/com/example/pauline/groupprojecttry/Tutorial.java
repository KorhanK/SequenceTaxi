package com.example.pauline.groupprojecttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tutorial extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tutorial);
       //textView=(TextView)findViewById(R.id.tutorial);
    }

    public void goBack(View view){
        String but_text=((Button)view).getText().toString();
    }
}
