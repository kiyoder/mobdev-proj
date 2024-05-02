package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MapsExercise extends AppCompatActivity {

    Button btnGMaps;
    Button btnViewImage;

    Button btnShowStreetView;

    Button btnCloseMaps;
    private ImageView imgSetBackground, imgStreetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        imgSetBackground = findViewById(R.id.imgBackground);
        imgStreetView = findViewById(R.id.imgStreetView);


        btnGMaps = (Button) findViewById(R.id.btnOpenGmaps);


        btnGMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMaps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:11.96362199175654, 121.92349818190378"));
                startActivity(intMaps);
            }

        });

        btnViewImage = (Button) findViewById(R.id.btnViewPlace);
        btnViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Set background to "boracay.jpg"
                imgSetBackground.setImageResource(R.drawable.boracay);
            }

        });


        btnShowStreetView = (Button) findViewById(R.id.btnStreetView);
        btnShowStreetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgStreetView.setVisibility(View.VISIBLE);
            }

        });

        btnCloseMaps = (Button) findViewById(R.id.btnCloseMaps);
        btnCloseMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });





    }


}