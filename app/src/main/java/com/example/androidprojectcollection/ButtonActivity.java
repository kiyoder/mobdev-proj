package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class ButtonActivity extends AppCompatActivity {

    String colorArr[] = {"#61039b","#cb3b41","#4e3922","#e8782d"};
    Button change1;
    Button modify1;

    Button toastmsg1;

    Button modify2;

    Button modify3;

    ConstraintLayout bck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);


        change1 = (Button) findViewById(R.id.btnChange);

        change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        modify1 = (Button) findViewById(R.id.btnModify);

        modify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modify1.setAlpha(0);
            }
        });

        toastmsg1 = (Button) findViewById(R.id.btnToastMessage);
        toastmsg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "This a toast message", Toast.LENGTH_LONG).show();
            }
        });

        modify2 = (Button) findViewById(R.id.btnChangeButtonColor);
        modify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random i = new Random();
                int c = i.nextInt(4-1) + 1;

                modify2.setBackgroundColor(Color.parseColor(colorArr[c]));
                modify2.setTextColor(Color.WHITE);
            }
        });


        modify3 = (Button) findViewById(R.id.btnChangeBackground);
        bck = (ConstraintLayout) findViewById(R.id.activity_button);

        modify3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random i = new Random();
                int c = i.nextInt(4-1) + 1;



                bck.setBackgroundColor(Color.parseColor(colorArr[c]));
            }
        });




    }
}