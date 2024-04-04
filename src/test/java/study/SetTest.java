package study;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void firstRequest() {
        // given

        // when

        // then
//        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void secondRequest(int number) {
        // given

        // when

        // then
//        assertThat(numbers.contains(number)).isTrue();
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    void thirdRequest(int number, boolean expected) {
        // given

        // when

        // then
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
