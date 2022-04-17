package baseball;

import baseball.domain.BaseBallAnswer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallAnswerTest {

    @DisplayName("야구 게임의 정답이 서로 다른 숫자가 생성되었는지 확인한다.")
    @Test
    public void create_different_number_test() {
        BaseBallAnswer baseBallAnswer = new BaseBallAnswer();
        List<Integer> answer = baseBallAnswer.getAnswer();
        Set<Integer> answerSet = new HashSet<>(answer);
        assertThat(answer.size()).isEqualTo(answerSet.size());
    }
}
