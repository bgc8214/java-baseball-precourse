package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BaseBallGameManagerTest {

    @Test
    public void validate_answer_is_integer() {
        BaseBallGameManager baseBallGameManager = new BaseBallGameManager();
        assertThatThrownBy(() -> baseBallGameManager.checkUserAnswer("숫자 아닌 값 입력"))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    public void validate_answer_is_size_3() {
        BaseBallGameManager baseBallGameManager = new BaseBallGameManager();
        assertThatThrownBy(() -> baseBallGameManager.checkUserAnswer("12345"))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    public void validate_answer_is_different_number() {
        BaseBallGameManager baseBallGameManager = new BaseBallGameManager();
        assertThatThrownBy(() -> baseBallGameManager.checkUserAnswer("111"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
