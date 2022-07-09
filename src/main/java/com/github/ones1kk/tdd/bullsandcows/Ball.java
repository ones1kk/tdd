package com.github.ones1kk.tdd.bullsandcows;

import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;

import java.time.temporal.ValueRange;

public class Ball {

    private int value;

    public Ball(int value) {
        boolean valid = isValidRange(value);
        if(!valid) throw new InvalidValueException("range of value should be between 1 and 9");
    }

    private static boolean isValidRange(int value) {
        return ValueRange.of(1, 9).isValidIntValue(value);
    }

}
