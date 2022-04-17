package baseball;

import java.util.Arrays;

public class BaseBallNumber {

    private BaseBallAnswer baseBallAnswer;

    public BaseBallNumber(int userAnswer) {
        baseBallAnswer = new BaseBallAnswer(userAnswer);
    }

    public BaseBallNumber() {
        baseBallAnswer = new BaseBallAnswer();
    }

    public AnswerResult findAnswerResult(int userAnswer) {
        AnswerResult answerResult = baseBallAnswer.makeAnswerResult(userAnswer);
        System.out.println(answerResult);
        return answerResult;
    }

    public void printAnswer() {
        System.out.println(Arrays.toString(baseBallAnswer.getAnswer().toArray()));
    }
}
