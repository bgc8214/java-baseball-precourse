package baseball.view;

import baseball.domain.BaseBallGameManager;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String enterAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String userAnswer = Console.readLine();
        BaseBallGameManager.validate(userAnswer);
        return userAnswer;
    }

    public static String enterRetryAnswer() {
        String retryAnswer;
        System.out.println("3개의 숫자를 모두 맞혔습니다. 게임 종료!");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        do {
            retryAnswer = Console.readLine();
        } while (!retryAnswer.equals(BaseBallGameManager.END_GAME_ANSWER) && !retryAnswer.equals(BaseBallGameManager.RETRY_GAME_ANSWER));
        return retryAnswer;
    }
}
