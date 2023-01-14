package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    InputView inputView = new InputView();
    private static void inputString(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("올바른 입력 테스트")
    @Test
    void right() {
        inputString("513");
        assertThat(inputView.inputView()).isEqualTo("513");
    }

    @DisplayName("아무것도 입력 안 한 경우 예외 테스트")
    @Test
    void emptyException() {
        inputString("\n");
        assertThatThrownBy(() -> {
            assertThat(inputView.inputView());
        }).isInstanceOf(NoSuchElementException.class).hasMessageContaining("공백 입력은 불가합니다.");
    }

    @DisplayName("공백 예외 테스트")
    @Test
    void blankException() {
        inputString("  ");
        assertThatThrownBy(() -> {
            assertThat(inputView.inputView());
        }).isInstanceOf(NoSuchElementException.class).hasMessageContaining("공백 입력은 불가합니다.");
    }

    @DisplayName("숫자가 아닌 문자 입력 시 예외 테스트")
    @Test
    void notNumberException() {
        inputString("E34");
        assertThatThrownBy(() -> {
            assertThat(inputView.inputView());
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자(1~9)만 입력 가능합니다.");
    }

    @DisplayName("0 입력 시 예외 테스트")
    @Test
    void zeroException() {
        inputString("019");
        assertThatThrownBy(() -> {
            assertThat(inputView.inputView());
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자(1~9)만 입력 가능합니다.");
    }

    @DisplayName("요구 길이가 아닌 경우 예외 테스트")
    @Test
    void wrongLengthException() {
        inputString("1945");
        assertThatThrownBy(() -> {
            assertThat(inputView.inputView());
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("문자열 길이가 3이 아니다.");
    }

    @DisplayName("문자 내 중복 체크 예외 테스트")
    @Test
    void overlapException() {
        inputString("666");
        assertThatThrownBy(() -> {
            assertThat(inputView.inputView());
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복 입력은 불가하다.");
    }
}
