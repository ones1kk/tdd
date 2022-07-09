package com.github.ones1kk.tdd.bullsandcows;

import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;

import static com.github.ones1kk.tdd.bullsandcows.Validator.isValidRange;

public class Ball {

    private final int value;

    public Ball(int value) {
        boolean valid = isValidRange(value);
        if(!valid) throw new InvalidValueException("range of value should be between 1 and 9");
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
