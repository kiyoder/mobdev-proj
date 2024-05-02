package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    Button btnIntents1, btnMenu, btnMaps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnLayoutExercise);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainActivity.this, LayoutExercise.class);
                startActivity(int1);
            }


        });

        btn2 = (Button) findViewById(R.id.btnButtonExercise);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(int2);
            }

        });

        btn3 = (Button) findViewById(R.id.btnCalculator);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(int3);
            }
        });

        btn4 = (Button) findViewById(R.id.btnMatchGame);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(MainActivity.this, MatchGameActivity.class);
                Toast.makeText(getApplicationContext(), "Yoshinori L. Kyono Jr. Opening Match Game!", Toast.LENGTH_LONG).show();
                startActivity(int4);
            }


        });


        btnIntents1 = (Button) findViewById(R.id.btnPassingIntents);
        btnIntents1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intIntents1 = new Intent(MainActivity.this, PassingIntentsExercise.class);
                startActivity(intIntents1);
            }

        });

        btnMenu = (Button) findViewById(R.id.btnMenus);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMenu = new Intent(MainActivity.this, MenuExercise.class);
                startActivity(intMenu);
            }

        });

        btnMaps = (Button) findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMaps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:11.96362199175654, 121.92349818190378"));
                startActivity(intMaps);
            }

        });





    }
}