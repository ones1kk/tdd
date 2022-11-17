package com.github.ones1kk.tdd.bullsandcows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ResultPrinterTest {

    @Nested
    @DisplayName("create test")
    class CreateTest {

        @Test
        @DisplayName("create success test")
        void create_success() {
            assertThatNoException().isThrownBy(() -> new ResultPrinter(0, 3));
            assertThatNoException().isThrownBy(() -> new ResultPrinter(1, 2));
            assertThatNoException().isThrownBy(() -> new ResultPrinter(2, 1));
            assertThatNoException().isThrownBy(() -> new ResultPrinter(3, 0));
        }

        @Test
        @DisplayName("create fail test, because of exceeding sum limit")
        void create_fail_01() {
            assertThatThrownBy(() -> new ResultPrinter(1, 3)).isInstanceOf(Exception.class);
            assertThatThrownBy(() -> new ResultPrinter(2, 2)).isInstanceOf(Exception.class);
            assertThatThrownBy(() -> new ResultPrinter(3, 1)).isInstanceOf(Exception.class);
            assertThatThrownBy(() -> new ResultPrinter(4, 0)).isInstanceOf(Exception.class);
        }
    }

    @Nested
    class PrintTest {

        @Test
        @DisplayName("print test")
        void print_01() {
            ResultPrinter resultPrinter = new ResultPrinter(1, 2);
            String message = resultPrinter.getResult();

            String expected = String.format("%s Ball, %s Strike", 1, 2);
            assertThat(message).isEqualTo(expected);
        }

        @Test
        @DisplayName("print test, when game is over")
        void print_02() {
            ResultPrinter resultPrinter = new ResultPrinter(0, 3);
            String message = resultPrinter.getResult();

            String expected = "You got all 3 numbers right!\n Game Over";
            assertThat(message).isEqualTo(expected);
        }

        @Test
        @DisplayName("print test, when it's nothing")
        void print_03() {
            ResultPrinter resultPrinter = new ResultPrinter(0, 0);
            String message = resultPrinter.getResult();

            String expected = "Nothing";
            assertThat(message).isEqualTo(expected);
        }
    }
}