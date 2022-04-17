package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class BaseBallGameManager {

    private BaseBallNumber baseBallNumber;

    private boolean isFinished = false;

    public BaseBallGameManager() {
        baseBallNumber = new BaseBallNumber();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void checkUserAnswer(String userAnswer) {
        validateInteger(userAnswer);
        validateAnswerSize(userAnswer);
        validateDifferentNumber(userAnswer);
        isFinished = baseBallNumber.findAnswerResult(Integer.valueOf(userAnswer)).isCorrectAnswer();
        enterRetryGame(isFinished);
    }

    private void enterRetryGame(boolean isFinished) {
        if (isFinished) {
            System.out.println("3개의 숫자를 모두 맞혔습니다. 게임 끝!");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            String retryAnswer = Console.readLine();
            prepareNextGame(retryAnswer);
        }
    }

    private void prepareNextGame(String retryAnswer) {
        if (retryAnswer.equals("2")) {
            return;
        }
        isFinished = false;
        baseBallNumber = new BaseBallNumber();
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
