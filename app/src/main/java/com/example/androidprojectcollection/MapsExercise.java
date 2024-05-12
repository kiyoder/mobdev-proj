package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MapsExercise extends AppCompatActivity {



    ImageButton imgbtnGMaps, imgbtnViewImage, imgbtnStreetView, imgbtnCloseMaps;
    private ImageView imgSetBackground, imgStreetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        imgSetBackground = findViewById(R.id.imgBackground);
        imgStreetView = findViewById(R.id.imgStreetView);



        //NEW IMPLEMENTATION

        imgbtnGMaps = (ImageButton) findViewById(R.id.imgbtnMaps);
        imgbtnGMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMaps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:11.96362199175654, 121.92349818190378"));
                startActivity(intMaps);
            }

        });

        imgbtnViewImage = (ImageButton) findViewById(R.id.imgbtnViewPlace);
        imgbtnViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Set background to "boracay.jpg"
                imgSetBackground.setImageResource(R.drawable.boracay);
            }

        });


        imgbtnStreetView = (ImageButton) findViewById(R.id.imgbtnStreetView);
        imgbtnStreetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgStreetView.setVisibility(View.VISIBLE);
            }

        });

        imgbtnCloseMaps = (ImageButton) findViewById(R.id.imgbtnClose);
        imgbtnCloseMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });





    }


}