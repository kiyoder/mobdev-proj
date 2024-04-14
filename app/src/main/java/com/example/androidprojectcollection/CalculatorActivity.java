package com.example.androidprojectcollection;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Stack;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    int parValue= 0;
    TextView tvResult, tvDisplay;
    MaterialButton btnClear, btnModulo, btnExponent, btnMultiply, btnDivide, btnSubtract, btnAdd, btnEquals, btnDecimal, btnZeroes, btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tvResult = findViewById(R.id.tvResult);
        tvDisplay = findViewById(R.id.tvSolution);

        assignId(btnClear,R.id.btnClear);
        assignId(btnModulo,R.id.btnParenthesis);
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
    private void updateText(String toAdd){
        String oldStr = tvDisplay.getText().toString();
        oldStr += toAdd;
        tvDisplay.setText(oldStr);

    }
    public void doublezeroBTN(View view){
        updateText("0");
    }
    public void zeroBTN(View view){
        updateText("0");
    }
    public void oneBTN(View view){
        updateText("1");
    }
    public void twoBTN(View view){
        updateText("2");
    }
    public void threeBTN(View view){
        updateText("3");
    }
    public void fourBTN(View view){
        updateText("4");
    }
    public void fiveBTN(View view){
        updateText("5");
    }
    public void sixBTN(View view){
        updateText("6");
    }
    public void sevenBTN(View view){
        updateText("7");
    }
    public void eightBTN(View view){
        updateText("8");
    }
    public void nineBTN(View view){
        updateText("9");
    }
    public void addBTN(View view){
        updateText("+");
    }
    public void subBTN(View view){
        updateText("-");
    }
    public void divBTN(View view){
        updateText("");
    }
    public void mulBTN(View view){

    }
    public void expBTN(View view){

    }
    public void parBTN(View view){

    }
    public void resetBTN(View view){
        updateText("");
    }
    public void equalBTN(View view){

    }

    public void decBTN(View view){

    }




    public void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String DataCalc = tvDisplay.getText().toString();

        if(buttonText.equals("AC")){
            tvDisplay.setText("");
            tvResult.setText("");
            parValue = 0;
            return;
        }

        if(buttonText.equals("=")){
            evaluateEquation();
            return;
        }
        if(buttonText.equals("()")){
            if(parValue == 0){
                DataCalc += "(";
                parValue = 1;
                tvDisplay.setText(DataCalc);
            }
            else if(parValue == 1){
                DataCalc += ")";
                parValue = 0;
                tvDisplay.setText(DataCalc);
            }
            return;
        }

        DataCalc += buttonText;
        tvDisplay.setText(DataCalc);
    }

    private void evaluateEquation() {
        String equation = tvDisplay.getText().toString();
        try {
            double result = evaluateExpression(equation);
            tvResult.setText(String.valueOf(result));
        } catch (IllegalArgumentException e) {
            tvResult.setText("Error: " + e.getMessage());
        }
    }

    private double evaluateExpression(String expression) throws IllegalArgumentException {
        try {
            return evaluate(expression);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
            throw new IllegalArgumentException("Invalid equation");
        }
    }

    private double evaluate(String expression) {
        String[] tokens = expression.split("(?<=[-+*/^()])|(?=[-+*/^()])");

        // Convert infix to postfix
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (String token : tokens) {
            char c = token.charAt(0);
            if (Character.isDigit(c) || token.length() > 1 && Character.isDigit(token.charAt(1))) {
                postfix.append(token).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // Discard '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        // Evaluate postfix expression
        Stack<Double> evalStack = new Stack<>();
        for (String token : postfix.toString().split("\\s+")) {
            char c = token.charAt(0);
            if (Character.isDigit(c) || token.length() > 1 && Character.isDigit(token.charAt(1))) {
                evalStack.push(Double.parseDouble(token));
            } else {
                if (c == '^') {
                    double b = evalStack.pop();
                    double a = evalStack.pop();
                    double result = Math.pow(a, b);
                    evalStack.push(result);
                } else {
                    double b = evalStack.pop();
                    double a = evalStack.pop();
                    double result = applyOperation(c, a, b);
                    evalStack.push(result);
                }
            }
        }

        return evalStack.pop();
    }

    private int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else if (op == '^') {
            return 3;
        } else {
            return 0;
        }
    }

    private double applyOperation(char op, double a, double b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

}