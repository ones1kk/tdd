package com.github.ones1kk.tdd.bullsandcows;

public class ResultPrinter {

    private ResultPrinter() {}

    private static final String BOTH  = "%s Ball, %s Strike";

    private static final String ONLY_BALL = "%s Ball";

    private static final String ONLY_STRIKE = "%s Strike";

    public static String print(int ballCount, int strikeCount) {
        String result = "";
        if(isOnlyBall(ballCount, strikeCount)) {
            result = String.format(ONLY_STRIKE, strikeCount);
        }

        if(isBoth(ballCount, strikeCount)) {
            result = String.format(BOTH, ballCount, strikeCount);
        }

        if(isOnlyStrike(ballCount, strikeCount)) {
            result = String.format(ONLY_BALL, ballCount);
        }

        return result;
    }

    private static boolean isBoth(int ballCount, int strikeCount) {
        return ballCount != 0 && strikeCount != 0;
    }

    private static boolean isOnlyStrike(int ballCount, int strikeCount) {
        return ballCount != 0 && strikeCount == 0;
    }

    private static boolean isOnlyBall(int ballCount, int strikeCount) {
        return ballCount == 0 && strikeCount != 0;
    }
}
