package com.github.ones1kk.tdd.bullsandcows;

import static com.github.ones1kk.tdd.bullsandcows.Validator.validateValue;

public class Helper {

    private final Balls answer;

    public Helper(Balls answer) {
        this.answer = answer;
    }

    public boolean ask(int number) {
        Balls expected = validateValue(number);
        Calculator calculator = new Calculator(expected);
        calculator.setAnswer(answer);

        return calculator.calculate();
    }

}
