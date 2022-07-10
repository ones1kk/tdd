package com.github.ones1kk.tdd.bullsandcows;

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
            int strike = answer.isStrike(expected);
            int ball = answer.isBall(expected);
            System.out.println("strike = " + strike);
            System.out.println("ball = " + ball);

            return isFinished(strike);
        }
        System.out.println("낫싱");

      return false;
    }

    public boolean isFinished(int strike) {
        return (strike == 3);
    }
}
