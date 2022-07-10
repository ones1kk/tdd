package com.github.ones1kk.tdd.bullsandcows;

import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Player {

    private Balls answer;

    Scanner scanner = new Scanner(System.in);

    public Game create() {
        Balls answer = Creator.createAnswer(3);
        String number = answer.getBallList()
                .stream()
                .map(Ball::getValue)
                .map(Objects::toString)
                .collect(Collectors.joining());

        System.out.println("정답 = " + number);
        this.answer = answer;
        return new Game(scanner, answer);
    }

    static class Game {

        private final Scanner scanner;

        private final Balls answer;

        public Game(Scanner scanner, Balls answer) {
            this.scanner = scanner;
            this.answer = answer;
        }

        public void play() {
            System.out.print("숫자를 입력해 주세요 : ");
            int input = scanner.nextInt();
            call(input, answer);
        }

        private void call(int input, Balls answer) {
            Helper helper = new Helper(answer);
            boolean flag = helper.ask(input);
            if (!flag) play();

            ask();
        }

        private void ask() {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int input = scanner.nextInt();
            choice(input);
        }

        private void choice(int input) {
            if (input == 2) {
                System.out.println("게임이 종료 되었습니다.");
                scanner.close();
                System.exit(1);
            }
            if (input == 1) {
                Player player = new Player();
                player.create().play();
            }
        }

    }

}
