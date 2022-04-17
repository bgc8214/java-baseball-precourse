package baseball;

import java.util.Objects;

public class AnswerResult {

    private int ballCount;

    public int strikeCount;

    public AnswerResult() {
    }

    public AnswerResult(int strikeCount, int ballCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public void addBallCount() {
        ballCount++;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public boolean isCorrectAnswer() {
        return strikeCount == 3;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    @Override
    public String toString() {
        return "스트라이크" + strikeCount +
            " 볼" + ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnswerResult that = (AnswerResult) o;
        return ballCount == that.ballCount && strikeCount == that.strikeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballCount, strikeCount);
    }
}
