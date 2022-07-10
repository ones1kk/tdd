package com.github.ones1kk.tdd.bullsandcows;

import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.github.ones1kk.tdd.bullsandcows.Validator.isValidSize;

public class Balls {

    private final List<Ball> ballList;

    public Balls(List<Ball> ballList) {
        boolean valid = isValidSize(ballList);
        if (!valid) throw new InvalidValueException("only 3 size of ball is allowed.");
        this.ballList = ballList;
    }

    public int sort() {
        String joined = ballList
                .stream()
                .map(Ball::getValue)
                .map(Objects::toString)
                .collect(Collectors.joining());
        return Integer.parseInt(joined);
    }

    public String calculate(Balls expected) {
        return "";
    }

    public boolean isNothing(Balls expected) {
        boolean result = true;
        for (Ball answer : ballList) {
            result = isResult(expected, result, answer);
        }
        return result;
    }

    private boolean isResult(Balls expected, boolean result, Ball answer) {
        for (Ball ball : expected.getBallList()) {
            if (answer.getValue() == ball.getValue()) {
                result = false;
                break;
            }
        }
        return result;
    }

    public int isStrike(Balls expected) {
        int count = 0;
        for(int i = 0; i < ballList.size(); i++) {
            count = getCount(expected, count, i);
        }
        return count;
    }

    private int getCount(Balls expected, int count, int i) {
        if (ballList.get(i).getValue() == expected.getBallList().get(i).getValue()) {
            count++;
        }
        return count;
    }
}
