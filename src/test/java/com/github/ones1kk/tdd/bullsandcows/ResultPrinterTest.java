package com.github.ones1kk.tdd.bullsandcows;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultPrinterTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("print test")
    void printTest(int count) {
        String message = ResultPrinter.print(count, count);

        String result = String.format("%s Ball, %s Strike", count, count);
        assertThat(message).isEqualTo(result);
    }

}