package baseball;

import baseball.domain.AnswerResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerResultTest {

    @DisplayName("정답 결과에 스트라이크를 추가하고, 동일한 값이 나오는 지 테스트한다.")
    @Test
    public void add_strike_test() {
        AnswerResult answerResult = new AnswerResult(2, 0);
        assertThat(answerResult.getStrikeCount()).isEqualTo(2);
    }

    @DisplayName("정답 결과에 볼 추가하고, 동일한 값이 나오는 지 테스트한다.")
    @Test
    public void add_ball_test() {
        AnswerResult answerResult = new AnswerResult(0, 2);
        assertThat(answerResult.getBallCount()).isEqualTo(2);
    }

    @DisplayName("정답 결과에 3 스트라이크를 추가하고, 동일한 값이 나오는 지 테스트한다.")
    @Test
    public void three_strike_test() {
        AnswerResult answerResult = new AnswerResult(3, 0);

        assertThat(answerResult.isCorrectAnswer()).isEqualTo(true);
    }
}
