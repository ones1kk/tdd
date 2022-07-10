package com.github.ones1kk.tdd.bullsandcows;

import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.github.ones1kk.tdd.bullsandcows.Validator.isValidSize;

public class Balls {

    private final List<Ball> ballList;

    public Balls(List<Ball> ballList) {
        boolean valid = isValidSize(ballList);
        if (!valid) throw new InvalidValueException("only 3 size of ball is allowed.");
        this.ballList = ballList;
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    public int sort() {
        String joined = ballList
                .stream()
                .map(Ball::getValue)
                .map(Objects::toString)
                .collect(Collectors.joining());
        return Integer.parseInt(joined);
    }

    public boolean isNothing(Balls expected) {
        boolean result = true;
        for (Ball answer : ballList) {
            result = isResult(expected, result, answer);
        }
        return result;
    }

    private boolean isResult(Balls expected, boolean result, Ball answer) {
        for (Ball ball : expected.getBallList()) {
            if (answer.getValue() == ball.getValue()) {
                result = false;
                break;
            }
        }
        return result;
    }

    public List<Integer> isStrike(Balls expected) {
        int count = 0;
        List<Integer> index = new ArrayList<>();
        addIndex(expected, count, index);
        return index;
    }

    private void addIndex(Balls expected, int count, List<Integer> index) {
        for (int i = 0; i < ballList.size(); i++) {
            count = getStrikeCount(expected, count, i, index);
        }
    }

    private int getStrikeCount(Balls expected, int count, int i, List<Integer> index) {
        if (ballList.get(i).getValue() == expected.getBallList().get(i).getValue()) {
            index.add(i);
            count++;
        }
        return count;
    }

    public int isBall(Balls expected) {
        int count = 0;
        List<Integer> strike = isStrike(expected);
        List<Integer> removedAnswer = getIntegers(ballList);
        List<Integer> removedExpected = getIntegers(expected.getBallList());
        remove(strike, removedAnswer, removedExpected);

        for (int i = 0; i < removedAnswer.size(); i++) {
            count = getBallCount(count, removedAnswer, removedExpected, i);
        }

        return count;
    }

    private int getBallCount(int count, List<Integer> removedAnswer, List<Integer> removedExpected, int i) {
        for (Integer integer : removedExpected) {
            if (removedAnswer.get(i).intValue() == integer.intValue()) {
                count++;
            }
        }
        return count;
    }

    private void remove(List<Integer> strike, List<Integer> removedAnswer, List<Integer> removedExpected) {
        strike.forEach(index -> removedAnswer.remove(index.intValue()));
        strike.forEach(index -> removedExpected.remove(index.intValue()));
    }

    private List<Integer> getIntegers(List<Ball> ballList) {
        return ballList.stream()
                .map(Ball::getValue)
                .collect(Collectors.toList());
    }

}
