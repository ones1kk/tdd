package com.github.ones1kk.tdd.bullsandcows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @Test
    @DisplayName("create test")
    void create() {
        Ball ball = new Ball(1, 1);

        assertThat(ball).isInstanceOf(Ball.class);
        assertThat(ball).extracting("value")
            .isEqualTo(1);
        assertThat(ball).extracting("position")
            .isEqualTo(1);
    }

    @Nested
    @DisplayName("create validation test")
    class createValidation {

        @ParameterizedTest
        @DisplayName("the value of ball should be greater than or equal to 1 and less than or equal to 9")
        @ValueSource(ints = {-1, 0, 10, 11, Integer.MAX_VALUE})
        void value_range(int value) throws Exception {
            assertThatThrownBy(() -> new Ball(value, 1)).isInstanceOf(Exception.class);
        }

        @ParameterizedTest
        @DisplayName("the position of ball should be greater than or equal to 1 and less than or equal to 9")
        @ValueSource(ints = {-1, 0, 4, 5, Integer.MAX_VALUE})
        void position_range(int position) throws Exception {
            assertThatThrownBy(() -> new Ball(1, position)).isInstanceOf(Exception.class);
        }
    }

    @Nested
    class ValueValidation {


        @Test
        void isBallTest() {
            Ball ball = new Ball(1, 1);

        }
    }
}