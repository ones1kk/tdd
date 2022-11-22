package com.github.ones1kk.tdd.bullsandcows;

import static com.github.ones1kk.tdd.bullsandcows.Message.BOTH;
import static com.github.ones1kk.tdd.bullsandcows.Message.END;
import static com.github.ones1kk.tdd.bullsandcows.Message.NOTHING;
import static com.github.ones1kk.tdd.bullsandcows.Message.ONLY_BALL;
import static com.github.ones1kk.tdd.bullsandcows.Message.ONLY_STRIKE;

import io.github.ones1kk.assertion.core.Asserts;

public class ResultPrinter {

    private final int ballCount;

    private final int strikeCount;

    private String result;

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
            result = END.getValue();
        }

        if (isNothing()) {
            result = NOTHING.getValue();
        }

        if (isOnlyBall()) {
            result = String.format(ONLY_BALL.getValue(), strikeCount);
        }

        if (isBoth()) {
            result = String.format(BOTH.getValue(), ballCount, strikeCount);
        }

        if (isOnlyStrike()) {
            result = String.format(ONLY_STRIKE.getValue(), ballCount);
        }
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
