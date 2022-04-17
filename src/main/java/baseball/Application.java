package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        BaseBallGameManager baseBallGameManager = new BaseBallGameManager();
        while (!baseBallGameManager.isFinished()) {
            System.out.print("숫자를 입력해주세요 : ");
            String userAnswer = Console.readLine();
            baseBallGameManager.checkUserAnswer(userAnswer);
        }
    }
}
