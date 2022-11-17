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
    @DisplayName("ball isStrike test")
    class isStrikeTest {

        @Test
        @DisplayName("ball.isStrike success test")
        void isStrikeTest_success() {
            Ball actual = new Ball(1, 1);
            Ball expected = new Ball(1, 1);

            boolean isStrike = actual.isStrike(expected);

            assertThat(isStrike).isTrue();
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 3})
        @DisplayName("ball.isStrike fail test, same value & different position")
        void isStrikeTest_fail_01(int position) {
            Ball actual = new Ball(1, 1);
            Ball expected = new Ball(1, position);

            boolean isStrike = actual.isStrike(expected);

            assertThat(isStrike).isFalse();
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9})
        @DisplayName("ball.isStrike fail test, different value & same position")
        void isStrikeTest_fail_02(int value) {
            Ball actual = new Ball(1, 1);
            Ball expected = new Ball(value, 1);

            boolean isStrike = actual.isStrike(expected);

            assertThat(isStrike).isFalse();
        }
    }

    @Nested
    @DisplayName("ball isBall test")
    class isBallTest {

        @Test
        @DisplayName("ball.isBall success test, same value & different position")
        void isBallTest_success() {
            Ball actual = new Ball(1, 1);
            Ball expected = new Ball(1, 3);

            boolean isBall = actual.isBall(expected);

            assertThat(isBall).isTrue();
        }

        @Test
        @DisplayName("ball.isBall fail test, same value & position")
        void isBallTest_fail_01() {
            Ball actual = new Ball(1, 1);
            Ball expected = new Ball(1, 1);

            boolean isBall = actual.isBall(expected);

            assertThat(isBall).isFalse();
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9})
        @DisplayName("ball.isBall fail test, different value & same position")
        void isBallTest_fail_02(int value) {
            Ball actual = new Ball(1, 1);
            Ball expected = new Ball(value, 1);

            boolean isBall = actual.isBall(expected);

            assertThat(isBall).isFalse();
        }
    }
}