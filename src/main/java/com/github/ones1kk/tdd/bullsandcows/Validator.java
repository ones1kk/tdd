package com.github.ones1kk.tdd.bullsandcows;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Validator {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int ALLOWED_SIZE = 3;

    public static boolean isValidRange(int value) {
        return ValueRange.of(START_RANGE, END_RANGE).isValidIntValue(value);
    }

    public static boolean isValidSize(List<Ball> ballList) {
        return (ballList.size() == ALLOWED_SIZE);
    }

    public static Balls validateValue(int expected) {
        List<Integer> numbers = digits(expected);
        List<Ball> ballList = new ArrayList<>();
        for (int value : numbers) {
            ballList.add(new Ball(value));
        }
        return new Balls(ballList);
    }

    private static List<Integer> digits(int expected) {
        List<Integer> digits = new ArrayList<>();
        while (expected > 0) {
            digits.add(expected % 10);
            expected /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

}
