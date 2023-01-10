package study;

import calculator.NewCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    NewCalculator calculator = new NewCalculator();
    public static void inputString(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("복합 계산")
    void mixCalTest() {
        inputString("2 + 3 - 0 * 4 / 2");
        assertThat(calculator.execute()).isEqualTo(10);
    }

    @Test
    @DisplayName("더하기 테스트")
    void plusTest() {
        inputString("10 + 5");
        assertThat(calculator.execute()).isEqualTo(15);
    }

    @Test
    @DisplayName("빼기 테스트")
    void minusTest() {
        inputString("10 - 5");
        assertThat(calculator.execute()).isEqualTo(5);
    }

    @Test
    @DisplayName("곱하기 테스")
    void multiplyTest() {
        inputString("10 * 5");
        assertThat(calculator.execute()).isEqualTo(50);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divideTest() {
        inputString("10 / 5");
        assertThat(calculator.execute()).isEqualTo(2);
    }

    @Test
    @DisplayName("연산 문자가 안 들어가는 경우의 예외 테스트")
    void notOperationTest() {
        inputString("10 $ 5");
        assertThatThrownBy(() -> {
            assertThat(calculator.execute());
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("연산 문자 이외에는 불가하다.");
    }

    @Test
    @DisplayName("0으로 나누기 예외 테스트")
    void zeroDivisionTest() {
        inputString("10 / 0");
        assertThatThrownBy(() -> {
            assertThat(calculator.execute());
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("공백 존재 예외 테스트")
    void blankTest() {
        inputString("10 /  2");
        assertThatThrownBy(() -> {
            assertThat(calculator.execute());
        }).isInstanceOf(NumberFormatException.class).hasMessageContaining("숫자 자리에 다른 것을 입력했거나 띄어쓰기가 잘못 되었다.");
    }

    @Test
    @DisplayName("공백만 존재 예외 테스트")
    void onlyBlankTest() {
        inputString("  ");
        assertThatThrownBy(() -> {
            assertThat(calculator.execute());
        }).isInstanceOf(NoSuchElementException.class).hasMessageContaining("공백은 입력 불가하다.");
    }

    @Test
    @DisplayName("미완성 식 테스트")
    void incompleteTest() {
        inputString("10 / 2 *");
        assertThatThrownBy(() -> {
            assertThat(calculator.execute());
        }).isInstanceOf(ArrayIndexOutOfBoundsException.class).hasMessageContaining("입력이 잘못 되었다.");
    }

    @Test
    @DisplayName("맞지 않는 형식의 식(띄어쓰기 없는 식) 예외 테스트")
    void noSpaceEquationTest() {
        inputString("10/2");
        assertThatThrownBy(() -> {
            assertThat(calculator.execute());
        }).isInstanceOf(NumberFormatException.class).hasMessageContaining("숫자 자리에 다른 것을 입력했거나 띄어쓰기가 잘못 되었다.");
    }

    @Test
    @DisplayName("맞지 않는 형식의 식(연산자가 올 곳에 숫자) 예외 테스트")
    void disorderOperationTest() {
        inputString("10 2 2");
        assertThatThrownBy(() -> {
            assertThat(calculator.execute());
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("연산 문자 이외에는 불가하다.");
    }

    @Test
    @DisplayName("맞지 않는 형식의 식(숫자가 올 곳에 연산자) 예외 테스트")
    void disorderNumberTest() {
        inputString("10 / *");
        assertThatThrownBy(() -> {
            assertThat(calculator.execute());
        }).isInstanceOf(NumberFormatException.class).hasMessageContaining("숫자 자리에 다른 것을 입력했거나 띄어쓰기가 잘못 되었다.");
    }
}