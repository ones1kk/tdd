package com.github.ones1kk.tdd.bullsandcows;

import io.github.ones1kk.assertion.core.Asserts;

public class Ball {

    private final int value;

    private final int position;

    public Ball(int value, int position) {
        this.value = value;
        this.position = position;
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
    }
}
