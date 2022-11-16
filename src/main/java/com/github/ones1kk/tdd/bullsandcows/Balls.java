package com.github.ones1kk.tdd.bullsandcows;

import io.github.ones1kk.assertion.core.Asserts;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
        Asserts.that(balls)
            .isNotNull()
            .isNotEmpty();
        Asserts.that(balls.size())
            .as("the balls size should be always 3.")
            .isEqualTo(3);
    }
}
