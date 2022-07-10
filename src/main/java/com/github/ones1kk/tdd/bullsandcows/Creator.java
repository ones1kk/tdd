package com.github.ones1kk.tdd.bullsandcows;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Creator {

    public static Balls createAnswer(int bound) {
        int number = Integer.parseInt(createAnswerNumber(bound));
        return Validator.validateValue(number);
    }

    private static String createAnswerNumber(int bound) {
        SecureRandom secureRandom = new SecureRandom();
        return IntStream.range(0, bound)
                .mapToObj(i -> secureRandom.nextInt(9) + 1)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
