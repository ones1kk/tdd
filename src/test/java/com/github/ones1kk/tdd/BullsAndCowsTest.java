package com.github.ones1kk.tdd;

import com.github.ones1kk.tdd.bullsandcows.Ball;
import com.github.ones1kk.tdd.bullsandcows.Balls;
import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BullsAndCowsTest {

    @Test
    @DisplayName("create Ball class")
    public void test1() throws Exception {
        // given
        int value = 1;

        // when
        Ball ball = new Ball(value);

        //then
        assertThat(ball).isInstanceOf(Ball.class);
    }

    @Test
    @DisplayName("Int value of Ball class is between 1~9 ?")
    public void test2() throws Exception {
        // given
        int invalidValue = 10;
        int validValue = 5;

        // when
        Ball ball = new Ball(validValue);

        //then
        assertThrows(InvalidValueException.class, () -> new Ball(invalidValue));
        assertThat(ball).isInstanceOf(Ball.class);
    }

    @Test
    @DisplayName("create Balls")
    public void test3() throws Exception {
        // given
        int value = 1;
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(value));
        ballList.add(new Ball(value));
        ballList.add(new Ball(value));


        // when
        Balls balls = new Balls(ballList);

        //then
        assertThat(balls).isInstanceOf(Balls.class);

    }

    @Test
    @DisplayName("ballList size is 3 ?")
    public void test4() throws Exception {
        int value = 1;
        List<Ball> invalidBallList = Stream.generate(() -> new Ball(value))
                .limit(1)
                .collect(Collectors.toList());

        List<Ball> validBallList = Stream.generate(() -> new Ball(value))
                .limit(3)
                .collect(Collectors.toList());


        // when
        Balls balls = new Balls(validBallList);

        //then
        assertThrows(InvalidValueException.class, () -> new Balls(invalidBallList));
        assertThat(balls).isInstanceOf(Balls.class);
    }
}
