package baseball;

import baseball.model.BaseballGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BaseBallTest {

    private BaseballGameResult matchNumber(String number, String input) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int idx = 0; idx < input.length(); idx++) {
            char currentChar = input.charAt(idx);

            if (number.contains(String.valueOf(currentChar))) {
                if (number.indexOf(currentChar) == idx) {
                    strikeCount++;

                } else {
                    ballCount++;
                }
            }
        }

        return new BaseballGameResult(ballCount, strikeCount);
    }

    @Test
    @DisplayName("Ball 1개")
    void oneBallTest() {
        // given
        String number = "123";
        String input = "416";

        // when
        BaseballGameResult matchingCount = matchNumber(number, input);

        // then
        assertThat(matchingCount.getBallCount()).isEqualTo(1);
        assertThat(matchingCount.getStrikeCount()).isZero();
    }

    @Test
    @DisplayName("Ball 2개")
    void twoBallTest() {
        // given
        String number = "123";
        String input = "412";

        // when
        BaseballGameResult matchingCount = matchNumber(number, input);

        // then
        assertThat(matchingCount.getBallCount()).isEqualTo(2);
        assertThat(matchingCount.getStrikeCount()).isZero();
    }

    @Test
    @DisplayName("Ball 3개")
    void threeBallTest() {
        // given
        String number = "123";
        String input = "312";

        // when
        BaseballGameResult matchingCount = matchNumber(number, input);

        // then
        assertThat(matchingCount.getBallCount()).isEqualTo(3);
        assertThat(matchingCount.getStrikeCount()).isZero();
    }

    @Test
    @DisplayName("Strike 1개")
    void oneStrikeTest() {
        // given
        String number = "123";
        String input = "196";

        // when
        BaseballGameResult matchingCount = matchNumber(number, input);

        // then
        assertThat(matchingCount.getBallCount()).isZero();
        assertThat(matchingCount.getStrikeCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("Strike 2개")
    void twoStrikeTest() {
        // given
        String number = "123";
        String input = "125";

        // when
        BaseballGameResult matchingCount = matchNumber(number, input);

        // then
        assertThat(matchingCount.getBallCount()).isZero();
        assertThat(matchingCount.getStrikeCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("Strike 3개")
    void threeStrikeTest() {
        // given
        String number = "123";
        String input = "123";

        // when
        BaseballGameResult matchingCount = matchNumber(number, input);

        // then
        assertThat(matchingCount.getBallCount()).isZero();
        assertThat(matchingCount.getStrikeCount()).isEqualTo(3);
    }

}
