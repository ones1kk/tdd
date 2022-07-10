package com.github.ones1kk.tdd.bullsandcows;

import java.util.Scanner;

public class Player {

    private final Balls answer;


    public Player(Balls answer) {
        this.answer = answer;
    }

    public void play() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        Helper helper = new Helper(input, answer);
        helper.ask();

    }

    public void finish(int input) {
        if (input == 2) {
        }
    }

    public void reGame(int input) {
        if (input == 1) {
            play();
        }
    }

}
