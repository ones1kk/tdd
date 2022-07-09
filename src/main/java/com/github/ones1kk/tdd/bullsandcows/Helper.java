package com.github.ones1kk.tdd.bullsandcows;

import static com.github.ones1kk.tdd.bullsandcows.Validator.validateValue;

public class Helper {

    private Balls balls;

    public Helper(int expected) {
        this.balls = validateValue(expected);
    }

    public String ask() {
        return "";
    }
}
