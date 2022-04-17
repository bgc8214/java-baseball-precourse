package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.AnswerResult;
import baseball.domain.BaseBallNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallNumberTest {

    @Test
    public void create_different_number_test() {
        BaseBallNumber baseBallNumber = new BaseBallNumber();
        baseBallNumber.printAnswer();
    }

    @DisplayName("3 스트라이크가 나오는 것을 테스트한다.")
    @Test
    public void validate_strike() {
        BaseBallNumber baseBallNumber = new BaseBallNumber(123);
        AnswerResult answerResult = baseBallNumber.findAnswerResult(123);
        assertThat(answerResult.getStrikeCount()).isEqualTo(3);
    }

    @DisplayName("3 볼이 나오는 것을 테스트한다.")
    @Test
    public void validate_ball() {
        BaseBallNumber baseBallNumber = new BaseBallNumber(123);
        AnswerResult answerResult = baseBallNumber.findAnswerResult(312);
        assertThat(answerResult.getBallCount()).isEqualTo(3);
    }

    @DisplayName("1스트라이크 2볼이 나오는 것을 테스트한다.")
    @Test
    public void validate_strike_and_ball() {
        BaseBallNumber baseBallNumber = new BaseBallNumber(123);
        AnswerResult answerResult = baseBallNumber.findAnswerResult(132);
        assertThat(answerResult.getStrikeCount()).isEqualTo(1);
        assertThat(answerResult.getBallCount()).isEqualTo(2);

    }
}
