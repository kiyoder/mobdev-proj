package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;

    boolean textAdded = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);
        btnChanger = findViewById(R.id.btnTransformingButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        /*if(item.getItemId() == R.id.mChange){
            Toast.makeText(this, "Change CLicked", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.mReset){
            Toast.makeText(this, "Reset CLicked", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.mExit){
            finish();
        }
        return true;*/

        switch (item.getItemId()) {
            case R.id.mChange:
                Toast.makeText(this, "Change CLicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mChangeColor:
                btnChanger.setBackgroundColor(Color.BLACK);
                Toast.makeText(this, "Color Changed to Black!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mAddText:
                textAdded = true;
                btnChanger.setText("Text Added!");
                Toast.makeText(this, "Text Added!", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.mChangeTextColor:

                if(textAdded){
                    btnChanger.setTextColor(Color.RED);
                }
                else Toast.makeText(this, "No text found!", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.mBoldText:

                if(textAdded){
                    btnChanger.setTypeface(null, Typeface.BOLD);
                }
                else Toast.makeText(this, "No text found!", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.mIncreaseSize:

                if(textAdded){
                    btnChanger.setTextSize(36);
                }
                else Toast.makeText(this, "No text found!", Toast.LENGTH_SHORT).show();

                return true;




            case R.id.mReset:
                textAdded = false;

                Toast.makeText(this, "Reset CLicked", Toast.LENGTH_SHORT).show();
                btnChanger.setBackgroundColor(Color.GREEN);
                btnChanger.setText("");
                btnChanger.setTextColor(Color.WHITE);
                btnChanger.setTextSize(18);
                btnChanger.setTypeface(null, Typeface.NORMAL);
                return true;

            case R.id.mExit:
                finish();
                return true;
        }

        return true;
    }

}