package com.github.ones1kk.tdd.bullsandcows;

import io.github.ones1kk.assertion.core.Asserts;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    private final int count = 1;

    private final int defaultCount = 0;

    public Balls(List<Ball> balls) {
        Asserts.that(balls)
            .isNotNull()
            .isNotEmpty();
        Asserts.that(balls.size())
            .as("the balls size should be always 3.")
            .isEqualTo(3);
        this.balls = balls;
    }

    public int hasBall(Ball ball) {
        for (Ball actual : balls) {
            boolean isBall = actual.isBall(ball);
            if (isBall) {
                return count;
            }
        }
        return defaultCount;
    }

    public int hasStrike(Ball ball) {
        for (Ball actual : balls) {
            boolean isStrike = actual.isStrike(ball);
            if (isStrike) {
                return count;
            }
        }
        return defaultCount;
    }
}
