package study;

import calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class StringCalTest {

    Calculator calculator = new Calculator();
    public static void inputString(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void mixCal() {
        inputString("2 + 3 - 0 * 4 / 2");
        assertThat(calculator.execute()).isEqualTo(10);
    }
}
