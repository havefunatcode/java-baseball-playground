package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void firstRequest1() {
        // given
        String inputStr = "1,2";

        // when
        List<String> results = Arrays.asList(inputStr.split(","));

        // then
        assertThat(results).contains("1", "2");
    }

    @Test
    void firstRequest2() {
        // given
        String inputStr = "1";

        // when
        List<String> results = Arrays.asList(inputStr.split(","));

        // then
        assertThat(results).containsExactly("1");
    }

    @Test
    void secondRequest() {
        // given
        String inputStr = "(1,2)";

        // when
        String result = inputStr.substring(1, inputStr.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 여부에 대한 학습 테스트 - jupiter")
    void thirdRequestWithJupiter() {
        // given
        String inputStr = "abc";

        // when
        // then
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            inputStr.charAt(4);
        });
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 여부에 대한 학습 테스트 - assertThatExceptionOfType")
    void thridRequestWithAssertThatExceptionOfType() {
        // given
        String inputStr = "abc";

        // when
        // then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    inputStr.charAt(4);
                }).withMessageContaining("String index out of range");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 여부에 대한 학습 테스트 - assertThatThrownBy")
    void thridRequestWithAssertThatThrownBy() {
        // given
        String inputStr = "abc";

        // when
        // then
        assertThatThrownBy(() -> {
            inputStr.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

}
