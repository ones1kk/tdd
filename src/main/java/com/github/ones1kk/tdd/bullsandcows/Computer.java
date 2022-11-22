package com.github.ones1kk.tdd.bullsandcows;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final Balls answer;

    private int ballCount;
    private int strikeCount;

    private Computer(Balls answer) {
        this.answer = answer;
    }

    public static Computer createGame(Balls answer) {
        return new Computer(answer);
    }
    
}

