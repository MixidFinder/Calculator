package com.mixfin.calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mixfin.calculator.R;
import com.mixfin.calculator.model.CalculatorImpl;
import com.mixfin.calculator.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView textResult;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        textResult = findViewById(R.id.textResult);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.button1, 1);
        digits.put(R.id.button2, 2);
        digits.put(R.id.button3, 3);
        digits.put(R.id.button4, 4);
        digits.put(R.id.button5, 5);
        digits.put(R.id.button6, 6);
        digits.put(R.id.button7, 7);
        digits.put(R.id.button8, 8);
        digits.put(R.id.button9, 9);
        digits.put(R.id.button0, 0);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitPressed(digits.get(view.getId()));
            }
        };

        findViewById(R.id.button1).setOnClickListener(digitClickListener);
        findViewById(R.id.button2).setOnClickListener(digitClickListener);
        findViewById(R.id.button3).setOnClickListener(digitClickListener);
        findViewById(R.id.button4).setOnClickListener(digitClickListener);
        findViewById(R.id.button5).setOnClickListener(digitClickListener);
        findViewById(R.id.button6).setOnClickListener(digitClickListener);
        findViewById(R.id.button7).setOnClickListener(digitClickListener);
        findViewById(R.id.button8).setOnClickListener(digitClickListener);
        findViewById(R.id.button9).setOnClickListener(digitClickListener);
        findViewById(R.id.button0).setOnClickListener(digitClickListener);

        Map<Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.buttonMinus, Operator.SUB);
        operators.put(R.id.buttonDivide, Operator.DIV);
        operators.put(R.id.buttonMultiply, Operator.MULT);
        operators.put(R.id.buttonPlus, Operator.ADD);


        View.OnClickListener operatorsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorPressed(operators.get(view.getId()));
            }
        };
        findViewById(R.id.buttonMinus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.buttonDivide).setOnClickListener(operatorsClickListener);
        findViewById(R.id.buttonMultiply).setOnClickListener(operatorsClickListener);
        findViewById(R.id.buttonPlus).setOnClickListener(operatorsClickListener);


        findViewById(R.id.buttonDot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDotPressed();
            }
        });

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClearPressed();
            }
        });

        findViewById(R.id.buttonEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onEqualsPressed();
            }
        });


    }

    @Override
    public void showResult(String result) {
        textResult.setText(result);
    }
}