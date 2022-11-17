package com.github.ones1kk.tdd.bullsandcows;

import io.github.ones1kk.assertion.core.Asserts;

public class Ball {

    private final int value;

    private final int position;

    public Ball(int value, int position) {
        Asserts.that(value)
            .as("The value of ball should be greater than or equal to 1 and less than or equal to 9.")
            .isNotNull()
            .isGreaterThanOrEqualTo(1)
            .isLessThanOrEqualTo(9);

        Asserts.that(position)
            .as("The position of ball should be greater than or equal to 1 and less than or equal to 3.")
            .isNotNull()
            .isGreaterThanOrEqualTo(1)
            .isLessThanOrEqualTo(3);
        this.value = value;
        this.position = position;
    }

    public boolean isStrike(Ball ball) {
        return isEqualValue(ball) && isEqualPosition(ball);
    }

    public boolean isBall(Ball ball) {
        return isEqualValue(ball) && !isEqualPosition(ball);
    }

    private boolean isEqualValue(Ball ball) {
        return this.value == ball.value;
    }

    private boolean isEqualPosition(Ball ball) {
        return this.position == ball.position;
    }

}
