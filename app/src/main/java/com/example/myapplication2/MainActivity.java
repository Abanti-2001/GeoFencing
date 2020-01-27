package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.myapplication2.signuppage.SIGNUP;

public class MainActivity extends AppCompatActivity {

     Button button;
     Button button_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_2=(Button) findViewById(R.id.login);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(MainActivity.this , loginpage.class);
                startActivity(login);
            }
        });

        button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(MainActivity.this, SIGNUP.class);
                startActivity(sign);
            }
        });

    }
}

