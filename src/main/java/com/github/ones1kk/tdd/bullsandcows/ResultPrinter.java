package com.github.ones1kk.tdd.bullsandcows;

import io.github.ones1kk.assertion.core.Asserts;

public class ResultPrinter {

    private final int ballCount;

    private final int strikeCount;

    private String result;

    private static final String BOTH = "%s Ball, %s Strike";

    private static final String ONLY_BALL = "%s Ball";

    private static final String ONLY_STRIKE = "%s Strike";

    private static final String NOTHING = "Nothing";

    private static final String END = "You got all 3 numbers right!\n Game Over";

    public ResultPrinter(int ballCount, int strikeCount) {
        Asserts.that(ballCount + strikeCount)
            .as("The sum of ballCount and strikeCount should be less than or equal to 3. but it's not(ballCount{}, strikeCount{})",
                ballCount, strikeCount)
            .isLessThanOrEqualTo(3);
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public String write() {
        if (isEnd()) {
            result = END;
        }

        if (isNothing()) {
            result = NOTHING;
        }

        if (isOnlyBall()) {
            result = String.format(ONLY_BALL, strikeCount);
        }

        if (isBoth()) {
            result = String.format(BOTH, ballCount, strikeCount);
        }

        if (isOnlyStrike()) {
            result = String.format(ONLY_STRIKE, ballCount);
        }
        System.out.println(result);
        return result;
    }

    private boolean isBoth() {
        return ballCount > 0 && strikeCount > 0;
    }

    private boolean isOnlyStrike() {
        return ballCount == 0 && strikeCount > 0 && strikeCount < 3;
    }

    private boolean isOnlyBall() {
        return ballCount > 0 && strikeCount == 0;
    }

    private boolean isEnd() {
        return ballCount + strikeCount == 3;
    }

    private boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }
}
