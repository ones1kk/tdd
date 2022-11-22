package com.github.ones1kk.tdd.bullsandcows;

import io.github.ones1kk.assertion.core.Asserts;
import java.util.List;

public class Balls {

    private final List<Ball> ballList;

    private final int count = 1;

    private final int defaultCount = 0;

    public Balls(List<Ball> ballList) {
        Asserts.that(ballList)
            .isNotNull()
            .isNotEmpty();
        Asserts.that(ballList.size())
            .as("the balls size should be always 3.")
            .isEqualTo(3);
        this.ballList = ballList;
    }

    public int[] has(List<Ball> ballList) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < this.ballList.size(); i++) {
            is(this.ballList.get(i).isBall(ballList.get(i)), ball);
            is(this.ballList.get(i).isStrike(ballList.get(i)), strike);
        }

        return new int[]{ball, strike};
    }

    private void is(boolean standard, int count) {
        if(standard) {
            count++;
        }
    }

    public int hasBall(Ball ball) {
        for (Ball actual : ballList) {
            boolean isBall = actual.isBall(ball);
            if (isBall) {
                return count;
            }
        }
        return defaultCount;
    }

    public int hasStrike(Ball ball) {
        for (Ball actual : ballList) {
            boolean isStrike = actual.isStrike(ball);
            if (isStrike) {
                return count;
            }
        }
        return defaultCount;
    }
}
