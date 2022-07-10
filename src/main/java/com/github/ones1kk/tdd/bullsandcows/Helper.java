package com.github.ones1kk.tdd.bullsandcows;

import java.util.ArrayList;
import java.util.List;

import static com.github.ones1kk.tdd.bullsandcows.Validator.validateValue;

public class Helper {

    private Balls expected;

    private final Balls answer;

    public Helper(int expected, Balls answer) {
        this.expected = validateValue(expected);
        this.answer = answer;
    }

    public boolean ask() {
        Calculator calculator = new Calculator(expected);
        calculator.setAnswer(answer);

        return calculator.calculate();
    }

}
