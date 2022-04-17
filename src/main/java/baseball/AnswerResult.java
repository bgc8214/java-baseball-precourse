package baseball;

import java.util.List;
import java.util.Objects;

public class AnswerResult {

    private static final int FINISH_STRIKE_COUNT = 3;

    private int ballCount;

    public int strikeCount;

    public AnswerResult() {
    }

    public AnswerResult(int strikeCount, int ballCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public void addBallCount(int compareNumber, int answerNumber, List<Integer> answer) {
        if (compareNumber != answerNumber && answer.contains(answerNumber)) {
            ballCount++;
        }
    }

    public void addStrikeCount(int compareNumber, int answerNumber) {
        if (compareNumber == answerNumber) {
            strikeCount++;
        }
    }

    public boolean isCorrectAnswer() {
        return strikeCount == FINISH_STRIKE_COUNT;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + "스트라이크";
        }
        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + "볼";
        }
        return strikeCount + "스트라이크 " + ballCount + "볼";
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
