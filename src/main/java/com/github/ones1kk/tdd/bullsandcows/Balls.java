package com.github.ones1kk.tdd.bullsandcows;

import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;

import java.util.List;

public class Balls {

    private List<Ball> ballList;

    public Balls(List<Ball> ballList) {
        boolean valid = isValidSize(ballList);
        if(!valid) throw new InvalidValueException("only 3 size of ball is allowed.");
    }

    private static boolean isValidSize(List<Ball> ballList) {
        return (ballList.size() == 3);
    }

    public int sort() {
        String joined = ballList
                .stream()
                .map(Ball::getValue)
                .map(Objects::toString)
                .collect(Collectors.joining());
        return Integer.parseInt(joined);
    }
}
