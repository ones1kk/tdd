package com.github.ones1kk.tdd.bullsandcows;

import java.util.List;

public class Calculator {

    private Balls answer;
    private final Balls expected;

    public Calculator(Balls expected) {
        this.expected = expected;
    }

    public void setAnswer(Balls answer) {
        this.answer = answer;
    }

    public boolean calculate() {
        boolean nothing = answer.isNothing(expected);
        if(!nothing) {
            List<Integer> strike = answer.isStrike(expected);
            if(strike.size() == 3) {
                return isFinished(strike.size());
            }
            int ball = answer.isBall(expected);
            String text = String.format("스트라이크 : %s 볼 : %s ", strike.size(), ball);
            System.out.println(text);

            return isFinished(strike.size());
        }
        System.out.println("낫싱");

      return false;
    }

    private boolean isFinished(int strike) {
        return (strike == 3);
    }
}
