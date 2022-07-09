package com.github.ones1kk.tdd;

import com.github.ones1kk.tdd.bullsandcows.Ball;
import com.github.ones1kk.tdd.bullsandcows.Balls;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    private Balls balls;

    public Helper(int expected) {
        validateValue(expected);
    }

    private void validateValue(int expected) {
       List<Integer> numbers = digits(expected);
        List<Ball> ballList = new ArrayList<>();
        for (int value : numbers) {
            ballList.add(new Ball(value));
        }
        this.balls = new Balls(ballList);
    }

    List<Integer> digits(int expected) {
        List<Integer> digits = new ArrayList<>();
        while(expected > 0) {
            digits.add(expected % 10);
            expected /= 10;
        }
        return digits;
    }

}
