package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.BaseBallGameManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGameManagerTest {

    @DisplayName("입력한 값이 숫자가 아닌 경우 에러가 난다.")
    @Test
    public void validate_answer_is_integer() {
        assertThatThrownBy(() -> BaseBallGameManager.validate("숫자 아닌 값 입력"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 값이 세 자리가 아닌 경우 에러가 난다.")
    @Test
    public void validate_answer_is_size_3() {
        assertThatThrownBy(() -> BaseBallGameManager.validate("12345"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 값이 서로 다른 숫자가 아닌 경우 에러가 난다.")
    @Test
    public void validate_answer_is_different_number() {
        assertThatThrownBy(() -> BaseBallGameManager.validate("111"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
