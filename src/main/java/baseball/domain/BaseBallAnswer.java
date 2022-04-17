package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BaseBallAnswer {

    private static final int ANSWER_SIZE = 3;

    private List<Integer> answer = new ArrayList<>();

    public BaseBallAnswer(int userAnswer) {
        Stack<Integer> answerStack = new Stack();
        while (userAnswer > 0) {
            answerStack.push(userAnswer % 10);
            userAnswer = userAnswer / 10;
        }
        while (!answerStack.empty()) {
            answer.add(answerStack.pop());
        }
    }

    public BaseBallAnswer() {
        while (answer.size() != ANSWER_SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            addNumber(number);
        }
    }

    private void addNumber(int number) {
        if (answer.contains(number)) {
            return;
        }
        answer.add(number);
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public AnswerResult makeAnswerResult(int userAnswer) {
        AnswerResult answerResult = new AnswerResult();
        for (int i = 2; i >= 0; i--) {
            int answerNumber = userAnswer % 10;
            answerResult.addStrikeCount(answer.get(i), answerNumber);
            answerResult.addBallCount(answer.get(i), answerNumber, answer);
            userAnswer = userAnswer / 10;
        }
        return answerResult;
    }

}
