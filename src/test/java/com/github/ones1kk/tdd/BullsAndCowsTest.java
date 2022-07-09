package com.github.ones1kk.tdd;

import com.github.ones1kk.tdd.bullsandcows.Ball;
import com.github.ones1kk.tdd.bullsandcows.exception.InvalidValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
