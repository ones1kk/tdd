package com.github.ones1kk.tdd.bullsandcows;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    void createTest() {
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

}