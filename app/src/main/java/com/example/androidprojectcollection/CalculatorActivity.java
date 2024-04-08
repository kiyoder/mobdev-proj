package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult, tvSolution;
    MaterialButton btnClear, btnModulo, btnExponent, btnMultiply, btnDivide, btnSubtract, btnAdd, btnEquals, btnDecimal, btnZeroes, btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tvResult = findViewById(R.id.tvResult);
        tvSolution = findViewById(R.id.tvSolution);

        assignId(btnClear,R.id.btnClear);
        assignId(btnModulo,R.id.btnModulo);
        assignId(btnExponent,R.id.btnExponent);
        assignId(btnMultiply,R.id.btnMultiply);
        assignId(btnDivide,R.id.btnDivide);
        assignId(btnSubtract,R.id.btnSubtract);
        assignId(btnAdd,R.id.btnAdd);
        assignId(btnEquals,R.id.btnEquals);
        assignId(btnZero,R.id.btnZero);
        assignId(btnZeroes,R.id.btnDoubleZero);
        assignId(btnOne,R.id.btnOne);
        assignId(btnTwo,R.id.btnTwo);
        assignId(btnThree,R.id.btnThree);
        assignId(btnFour,R.id.btnFour);
        assignId(btnFive,R.id.btnFive);
        assignId(btnSix,R.id.btnSix);
        assignId(btnSeven,R.id.btnSeven);
        assignId(btnEight,R.id.btnEight);
        assignId(btnNine,R.id.btnNine);
        assignId(btnDecimal,R.id.btnDecimal);




    }

    void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String DataCalc = tvSolution.getText().toString();

        if(buttonText.equals("AC")){
            tvSolution.setText("");
            tvResult.setText("0");
            return;
        }

        if(buttonText.equals("=")){
            tvResult.setText(tvSolution.getText());
            return;
        }

        DataCalc += buttonText;
        tvSolution.setText(DataCalc);

    }
}