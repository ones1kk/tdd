package com.github.ones1kk.tdd.bullsandcows;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallsTest {

    List<Ball> ballList = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        ballList.add(new Ball(1, 1));
        ballList.add(new Ball(2, 2));
        ballList.add(new Ball(3, 3));
    }

    @Test
    @DisplayName("create test")
    void create() {
        Balls balls = new Balls(ballList);

        assertThat(balls).isNotNull();
        assertThat(balls).extracting("balls")
            .asList()
            .isNotEmpty();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5})
    @DisplayName("create validation test")
    void balls_range(int index) {
        List<Ball> source = Stream.generate(() -> new Ball(1, 2))
            .limit(index)
            .collect(toList());

        assertThatThrownBy(() -> new Balls(source)).isInstanceOf(Exception.class);
    }

    @Nested
    @DisplayName("Balls hasBall() & hasStrike() test")
    class MatchTest {

        @Test
        @DisplayName("hasBall success test")
        void hasBall_success() {
            List<Ball> ballList = new ArrayList<>();
            ballList.add(new Ball(6, 1));
            ballList.add(new Ball(2, 2));
            ballList.add(new Ball(7, 3));

            Balls balls = new Balls(ballList);
            Ball ball = new Ball(6, 3);

            int ballCount = balls.hasBall(ball);

            assertThat(ballCount).isEqualTo(1);
        }

        @Test
        @DisplayName("hasBall fail test because of strike")
        void hasBall_fail_01() {
            List<Ball> ballList = new ArrayList<>();
            ballList.add(new Ball(6, 1));
            ballList.add(new Ball(2, 2));
            ballList.add(new Ball(7, 3));

            Balls balls = new Balls(ballList);
            Ball ball = new Ball(6, 1);

            int ballCount = balls.hasBall(ball);

            assertThat(ballCount).isEqualTo(0);
        }

        @Test
        @DisplayName("hasBall fail test because of not all matched")
        void hasBall_fail_02() {
            List<Ball> ballList = new ArrayList<>();
            ballList.add(new Ball(6, 1));
            ballList.add(new Ball(2, 2));
            ballList.add(new Ball(7, 3));

            Balls balls = new Balls(ballList);
            Ball ball = new Ball(1, 1);

            int ballCount = balls.hasBall(ball);

            assertThat(ballCount).isEqualTo(0);
        }

        @Test
        @DisplayName("hasStrike success test")
        void hasStrike_success() {
            List<Ball> ballList = new ArrayList<>();
            ballList.add(new Ball(6, 1));
            ballList.add(new Ball(2, 2));
            ballList.add(new Ball(7, 3));

            Balls balls = new Balls(ballList);
            Ball ball = new Ball(6, 1);

            int strikeCount = balls.hasStrike(ball);

            assertThat(strikeCount).isEqualTo(1);
        }

        @Test
        @DisplayName("hasBall fail test because of ball")
        void hasStrike_fail_01() {
            List<Ball> ballList = new ArrayList<>();
            ballList.add(new Ball(6, 1));
            ballList.add(new Ball(2, 2));
            ballList.add(new Ball(7, 3));

            Balls balls = new Balls(ballList);
            Ball ball = new Ball(6, 3);

            int strikeCount = balls.hasStrike(ball);

            assertThat(strikeCount).isEqualTo(0);
        }

        @Test
        @DisplayName("hasBall fail test because of not all matched")
        void hasStrike_fail_02() {
            List<Ball> ballList = new ArrayList<>();
            ballList.add(new Ball(6, 1));
            ballList.add(new Ball(2, 2));
            ballList.add(new Ball(7, 3));

            Balls balls = new Balls(ballList);
            Ball ball = new Ball(1, 3);

            int strikeCount = balls.hasStrike(ball);

            assertThat(strikeCount).isEqualTo(0);
        }
    }

}