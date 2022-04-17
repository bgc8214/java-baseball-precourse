package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseBallGameManager {

    private BaseBallNumber baseBallNumber;

    public BaseBallGameManager() {
        baseBallNumber = new BaseBallNumber();
    }

    public void checkUserAnswer(String userAnswer) {
        validateInteger(userAnswer);
        validateAnswerSize(userAnswer);
        validateDifferentNumber(userAnswer);
        baseBallNumber.findAnswerResult(Integer.valueOf(userAnswer));
        baseBallNumber.printAnswer();
    }

    private void validateAnswerSize(String userAnswer) {
        int number = Integer.valueOf(userAnswer);
        if (number < 100 || number >= 1000) {
            throw new IllegalArgumentException("3자리의 숫자를 입력하여주세요.");
        }
    }

    private void validateDifferentNumber(String userAnswer) {
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

    private void validateInteger(String userAnswer) {
        try {
            int number = Integer.valueOf(userAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다.");
        }
    }
}
