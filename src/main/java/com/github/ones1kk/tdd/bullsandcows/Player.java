package com.github.ones1kk.tdd.bullsandcows;

import java.util.Scanner;

public class Player {

    private final Balls answer;

    Scanner scanner = new Scanner(System.in);

    public Player(Balls answer) {
        this.answer = answer;
    }

    public boolean play() {
        System.out.print("숫자를 입력해 주세요 : ");

        int input = scanner.nextInt();

        Helper helper = new Helper(input, answer);
        boolean ask = helper.ask();
        if(ask) ask();

        return ask;

    }

    public void ask() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();
        choice(input);
    }

    private void choice(int input) {
        if (input == 2) {
            System.out.println("게임이 종료 되었습니다.");
        }
        if (input == 1) {
            play();
        }
    }

}
