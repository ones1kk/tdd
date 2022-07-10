package com.github.ones1kk.tdd.bullsandcows;

import java.util.Objects;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {

        Balls answer = Creator.createAnswer(3);
        String collect = answer.getBallList()
                .stream()
                .map(Ball::getValue)
                .map(Objects::toString)
                .collect(Collectors.joining());

        System.out.println("collect = " + collect);

        Player player = new Player(answer);

        player.play();
    }
}
