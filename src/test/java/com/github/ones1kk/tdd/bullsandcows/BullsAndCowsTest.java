package com.github.ones1kk.tdd.bullsandcows;

import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BullsAndCowsTest {

    private int value = 1;
    private List<Ball> validBallList;

    @BeforeEach
    void init() {
        validBallList = Stream.generate(() -> new Ball(value))
                .limit(3)
                .collect(Collectors.toList());
    }


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

        // when
        Balls balls = new Balls(validBallList);

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
        Balls balls = new Balls(validBallList);

        // when
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
        Helper helper = new Helper(new Balls(validBallList));

        //then
        assertThat(helper).isInstanceOf(Helper.class);
    }

    @Test
    @DisplayName("Validate expected value")
    public void test7() throws Exception {
        // given
        Balls balls = new Balls(validBallList);
        // when
        Helper helper = new Helper(balls);

        //then
        assertThat(helper).isInstanceOf(Helper.class);
    }

    @Test
    @DisplayName("Ask what is expected")
    public void test8() throws Exception {
        // given
        int expected = 123;
        Helper helper = new Helper(new Balls(validBallList));

        // when
        boolean result = helper.ask(expected);

        //then
        assertThat(result).isInstanceOf(Boolean.class);
    }

    @Test
    @DisplayName("Balls calculate")
    public void test9() throws Exception {
        // given
        Balls balls = new Balls(validBallList);


        // when
//        boolean result = balls.isFinished(3);

        //then
//        assertThat(result).isInstanceOf(Boolean.class);
    }

    @Test
    @DisplayName("Calculate whether it is nothing or something")
    public void test10() throws Exception {
        // given
        Balls balls = new Balls(validBallList);

        List<Ball> validBallList = new ArrayList<>();
        validBallList.add(new Ball(9));
        validBallList.add(new Ball(8));
        validBallList.add(new Ball(7));
        Balls validExpected = new Balls(validBallList);

        List<Ball> invalidBallList = new ArrayList<>();
        invalidBallList.add(new Ball(1));
        invalidBallList.add(new Ball(1));
        invalidBallList.add(new Ball(1));
        Balls invalidExpected = new Balls(invalidBallList);

        // when
        boolean result1 = balls.isNothing(validExpected);
        boolean result2 = balls.isNothing(invalidExpected);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @Test
    @DisplayName("Calculate whether expected had strike or not")
    public void test11() throws Exception {
        // given
        Balls balls = new Balls(validBallList);

        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(9));
        ballList.add(new Ball(1));
        ballList.add(new Ball(1));
        Balls expected = new Balls(ballList);

        List<Ball> invalidBallList = new ArrayList<>();
        invalidBallList.add(new Ball(9));
        invalidBallList.add(new Ball(8));
        invalidBallList.add(new Ball(7));
        Balls invalidExpected = new Balls(invalidBallList);

        // when
        int count1 = balls.isStrike(expected);
        int count2 = balls.isStrike(invalidExpected);

        //then
        assertThat(count1).isEqualTo(2);
        assertThat(count2).isEqualTo(0);
    }

    @Test
    @DisplayName("Calculate whether expected had ball or not")
    public void test12() throws Exception {
        // given
        List<Ball> answer = new ArrayList<>();
        answer.add(new Ball(1));
        answer.add(new Ball(2));
        answer.add(new Ball(5));
        Balls balls = new Balls(answer);

        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(9));
        ballList.add(new Ball(6));
        ballList.add(new Ball(1));
        Balls expected = new Balls(ballList);

        // when
        int count = balls.isBall(expected);

        //then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("Ask to Calculator for receiving result")
    public void test13() throws Exception {
        // given
        List<Ball> answer = new ArrayList<>();
        answer.add(new Ball(1));
        answer.add(new Ball(2));
        answer.add(new Ball(5));
        Balls balls = new Balls(answer);

        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(9));
        ballList.add(new Ball(6));
        ballList.add(new Ball(1));
        Balls expected = new Balls(ballList);

        // when
        Calculator calculator = new Calculator(expected);
        calculator.setAnswer(balls);
        //then
        calculator.calculate();
    }
}
