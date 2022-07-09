package com.github.ones1kk.tdd;

import com.github.ones1kk.tdd.bullsandcows.Ball;
import com.github.ones1kk.tdd.bullsandcows.Balls;
import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
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
        int invalidValue1 = 10;
        int invalidValue2 = -5;
        int validValue = 5;

        // when
        Ball ball = new Ball(validValue);

        //then
        assertThrows(InvalidValueException.class, () -> new Ball(invalidValue1));
        assertThrows(InvalidValueException.class, () -> new Ball(invalidValue2));
        assertThat(ball).isInstanceOf(Ball.class);
    }

    @Test
    @DisplayName("create Balls class")
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
    @DisplayName("Size of ballList is 3 ?")
    public void test4() throws Exception {
        // given
        int value = 1;
        List<Ball> invalidBallList1 = Stream.generate(() -> new Ball(value))
                .limit(1)
                .collect(Collectors.toList());

        List<Ball> invalidBallList2 = Collections.emptyList();

        List<Ball> validBallList = Stream.generate(() -> new Ball(value))
                .limit(3)
                .collect(Collectors.toList());

        // when
        Balls balls = new Balls(validBallList);

        //then
        assertThrows(InvalidValueException.class, () -> new Balls(invalidBallList1));
        assertThrows(InvalidValueException.class, () -> new Balls(invalidBallList2));
        assertThat(balls).isInstanceOf(Balls.class);
    }

    @Test
    @DisplayName("Sort balls")
    public void test5() throws Exception {
        // given
        int value = 1;
        List<Ball> ballList = Stream.generate(() -> new Ball(value))
                .limit(3)
                .collect(Collectors.toList());

        // when
        Balls balls = new Balls(ballList);
        int sorted = balls.sort();

        //then
        assertThat(sorted).isEqualTo(111);

    }

    @Test
    @DisplayName("Create Helper that help to teach what's result of expected value")
    public void test6() throws Exception {
        // given
        int expected = 111;

        // when
        Helper helper = new Helper(expected);

        //then
        assertThat(helper).isInstanceOf(Helper.class);
    }
    
    @Test
    @DisplayName("Validate expected value")
    public void test7() throws Exception {
        // given
        int validExpected = 123;
        int invalidExpected = 111222;

        // when
        Helper helper = new Helper(validExpected);
        
        //then
        assertThrows(InvalidValueException.class, () -> new Helper(invalidExpected));
        assertThat(helper).isInstanceOf(Helper.class);
    }
}
