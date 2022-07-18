package com.mixfin.calculator.ui;

import com.mixfin.calculator.model.Calculator;
import com.mixfin.calculator.model.Operator;

import java.text.DecimalFormat;

public class CalculatorPresenter {

    private final DecimalFormat formatter = new DecimalFormat("#.##");

    private final CalculatorView view;
    private final Calculator calculator;

    private double arg1;
    private Double arg2;
    private Operator selectedOperator;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(int digit) {

        if (arg2 == null) {
            arg1 = arg1 * 10 + digit;

            showFormatted(arg1);
        } else {
            arg2 = arg2 * 10 + digit;
            showFormatted(arg2);
        }

    }

    public void onOperatorPressed(Operator operator) {
        if (selectedOperator != null) {
            arg1 = calculator.perform(arg1, arg2, selectedOperator);
            showFormatted(arg1);
        }

        arg2 = 0.0;

        selectedOperator = operator;
    }

    public void onDotPressed() {
    }

    private void showFormatted(double value) {
        view.showResult(formatter.format(value));
    }

    public void onClearPressed() {
        arg1 = 0.0;
        arg2 = 0.0;
        view.showResult("0");
    }

    public void onEqualsPressed() {

    }
}
