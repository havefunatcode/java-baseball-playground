package baseball.model;

public class BaseballGameResult {
    private final int ballCount;
    private final int strikeCount;

    public BaseballGameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
