package com.example.androidprojectcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PassingIntentsExercise extends AppCompatActivity {

    private Button submitButton;
    private EditText eFName, eLName, eBDay, ePNum, eEmail, eAddress, eNationality, eReligion, eProgram;
    private RadioButton rbMale, rbFemale, rbOthers, rbLvl1, rbLvl2, rbLvl3, rbLvl4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        eFName = findViewById(R.id.edittxtFName);
        eLName = findViewById(R.id.edittextLName);
        rbMale = findViewById(R.id.radMale);
        rbMale = findViewById(R.id.radMale);
        rbFemale = findViewById(R.id.radFemale);
        rbOthers = findViewById(R.id.radOthers);

        eBDay = findViewById(R.id.editTextDate);
        ePNum = findViewById(R.id.editTextPhone);
        eEmail = findViewById(R.id.editTextEmailAddress);
        eAddress = findViewById(R.id.editTextAddress);
        eNationality = findViewById(R.id.editTextNationality);
        eReligion = findViewById(R.id.editTextReligion);
        eProgram = findViewById(R.id.editTextProgram);


        rbLvl1 = findViewById(R.id.radLvl1);
        rbLvl2 = findViewById(R.id.radLvl2);
        rbLvl3 = findViewById(R.id.radLvl3);
        rbLvl4 = findViewById(R.id.radLvl4);



        submitButton = findViewById(R.id.btnSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FName = eFName.getText().toString();
                String LName = eLName.getText().toString();
                String gender;

                if(rbMale.isChecked()) gender = "Male";
                else if(rbFemale.isChecked()) gender = "Female";
                else if(rbOthers.isChecked()) gender = "Others";
                else gender = "Unknown";


                String BDay = eBDay.getText().toString();
                String PNum = ePNum.getText().toString();
                String EMail = eEmail.getText().toString();
                String Address = eAddress.getText().toString();
                String Nationality = eNationality.getText().toString();
                String Religion = eReligion.getText().toString();
                String Program = eProgram.getText().toString();

                String yrLvl;

                if(rbLvl1.isChecked()) yrLvl = "Male";
                else if(rbLvl2.isChecked()) yrLvl = "2";
                else if(rbLvl3.isChecked()) yrLvl = "3";
                else if(rbLvl4.isChecked()) yrLvl = "4";
                else yrLvl = "0";

                Intent Pass = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                Pass.putExtra("fname-key", FName);
                Pass.putExtra("lname-key", LName);
                Pass.putExtra("gender-key", gender);
                Pass.putExtra("pnumber-key", PNum);
                Pass.putExtra("email-key", EMail);
                Pass.putExtra("address-key", Address);
                Pass.putExtra("nationality-key", Nationality);
                Pass.putExtra("religion-key", Religion);
                Pass.putExtra("program-key", Program);
                Pass.putExtra("yearlevel-key", yrLvl);


                Toast.makeText(PassingIntentsExercise.this, "Submit button clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}