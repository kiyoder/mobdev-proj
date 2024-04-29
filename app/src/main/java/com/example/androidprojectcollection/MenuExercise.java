package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        if(item.getItemId() == R.id.mChange){
            Toast.makeText(this, "Change CLicked", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.mReset){
            Toast.makeText(this, "Reset CLicked", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.mExit){
            finish();
        }
        return true;
    }
}