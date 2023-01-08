package study;

import calculator.NewCalculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    NewCalculator calculator = new NewCalculator();
    public static void inputString(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void mixCal() {
        inputString("2 + 3 - 0 * 4 / 2");
        calculator.execute();
        assertThat(calculator.execute()).isEqualTo(10);
    }

    @Test
    void plus() {

    }

    @Test
    void minus() {

    }

    @Test
    void multiply() {

    }

    @Test
    void divide() {

    }

    @Test
    void illegal() {

    }
}