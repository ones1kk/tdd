package com.github.ones1kk.tdd.bullsandcows;

import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;

import java.time.temporal.ValueRange;

public class Ball {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    private final int value;

    public Ball(int value) {
        boolean valid = isValidRange(value);
        if(!valid) throw new InvalidValueException("range of value should be between 1 and 9");
        this.value = value;
    }

    private static boolean isValidRange(int value) {
        return ValueRange.of(START_RANGE, END_RANGE).isValidIntValue(value);
    }

    public int getValue() {
        return this.value;
    }

}
