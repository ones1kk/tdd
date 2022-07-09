package com.github.ones1kk.tdd;

import com.github.ones1kk.tdd.bullsandcows.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BullsAndCowsTest {

    @Test
    @DisplayName("create Ball class")
    public void test1() throws Exception {
        // given
        int num = 1;

        // when
        Ball ball = new Ball(num);

        //then
        assertThat(ball).isInstanceOf(Ball.class);
    }
}
