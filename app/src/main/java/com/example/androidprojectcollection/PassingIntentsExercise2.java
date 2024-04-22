package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PassingIntentsExercise2 extends AppCompatActivity {
    Button btnReturn;
    private EditText eFName2, eLName2, eGender2, eBDay2, ePNum2, eEmail2, eAddress2, eNationality2, eReligion2, eProgram2, eYearLvl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        eFName2 = findViewById(R.id.editTextFirstName);
        eLName2 = findViewById(R.id.editTextLastName);
        eGender2 = findViewById(R.id.editTextGender);

        eBDay2 = findViewById(R.id.editTextBirthday);
        ePNum2 = findViewById(R.id.editTextPhoneNumber);
        eEmail2 = findViewById(R.id.editTextEmailAddress);
        eAddress2 = findViewById(R.id.editTextAddress);
        eNationality2 = findViewById(R.id.editTextNationality);
        eReligion2 = findViewById(R.id.editTextReligion);
        eProgram2 = findViewById(R.id.editTextProgram);
        eYearLvl2 = findViewById(R.id.editTextYearLvl);

        Intent receive = getIntent();

        String fname = receive.getStringExtra("fname-key");
        String lname = receive.getStringExtra("lname-key");
        String gender = receive.getStringExtra("gender-key");
        String birthday = receive.getStringExtra("birthday-key");
        String pnumber = receive.getStringExtra("pnumber-key");
        String email = receive.getStringExtra("email-key");
        String address = receive.getStringExtra("address-key");
        String nationality = receive.getStringExtra("nationality-key");
        String religion = receive.getStringExtra("religion-key");
        String program = receive.getStringExtra("program-key");
        String yearlevel = receive.getStringExtra("yearlevel-key");

        eFName2.setText(fname);
        eLName2.setText(lname);
        eGender2.setText(gender);

        eBDay2.setText(birthday);
        ePNum2.setText(pnumber);
        eEmail2.setText(email);
        eAddress2.setText(address);
        eNationality2.setText(nationality);
        eReligion2.setText(religion);
        eProgram2.setText(program);
        eYearLvl2.setText(yearlevel);




    }


}