package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class BaseBallGameManager {

    private BaseBallNumber baseBallNumber;
    public static final String RETRY_GAME_ANSWER = "1";
    public static final String END_GAME_ANSWER = "2";
    private boolean isFinished = false;

    public BaseBallGameManager() {
        baseBallNumber = new BaseBallNumber();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean checkUserAnswer(String userAnswer) {
        isFinished = baseBallNumber.findAnswerResult(Integer.valueOf(userAnswer)).isCorrectAnswer();
        return baseBallNumber.findAnswerResult(Integer.valueOf(userAnswer)).isCorrectAnswer();
    }

    public AnswerResult findAnswerResult(String userAnswer) {
        return baseBallNumber.findAnswerResult(Integer.valueOf(userAnswer));
    }

    public static void validate(String userAnswer) {
        validateInteger(userAnswer);
        validateAnswerSize(userAnswer);
        validateDifferentNumber(userAnswer);
    }

    public void prepareNextGame(String retryAnswer) {
        if (retryAnswer.equals(END_GAME_ANSWER)) {
            return;
        }
        if (retryAnswer.equals(RETRY_GAME_ANSWER)) {
            isFinished = false;
            baseBallNumber = new BaseBallNumber();
        }
    }

    private static void validateAnswerSize(String userAnswer) {
        int number = Integer.valueOf(userAnswer);
        if (number < 100 || number >= 1000) {
            throw new IllegalArgumentException("3자리의 숫자를 입력하여주세요.");
        }
    }

    private static void validateDifferentNumber(String userAnswer) {
        int number = Integer.valueOf(userAnswer);
        Set<Integer> answerSet = new HashSet<>();

        while (number > 0) {
            answerSet.add(number % 10);
            number = number / 10;
        }
        if (answerSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리의 숫자를 입력하여주세요.");
        }
    }

    private static void validateInteger(String userAnswer) {
        try {
            Integer.valueOf(userAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다.");
        }
    }
}
