package com.github.ones1kk.tdd.bullsandcows;

import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Balls {

    private static final int ALLOWED_SIZE = 3;

    private final List<Ball> ballList;


    public Balls(List<Ball> ballList) {
        boolean valid = isValidSize(ballList);
        if(!valid) throw new InvalidValueException("only 3 size of ball is allowed.");
        this.ballList = ballList;
    }

    private static boolean isValidSize(List<Ball> ballList) {
        return (ballList.size() == ALLOWED_SIZE);
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
