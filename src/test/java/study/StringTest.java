package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String s1 = "abc".replace("b", "d");
        assertThat(s1).isEqualTo("adc");
    }

    @Test
    void firstSplitOfFirstTest() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @Test
    void secondSplitOfFirstTest() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void secondTest() {
        String s3 = "(1,2)";
        assertThat(s3.substring(1, s3.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 활용한 String 예외 테스트")
    void thirdTest() {
        String s4 = "abc";
        int index = 44;
        assertThat(s4.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> {
           char c = s4.charAt(index);
           assertThat(c).isEqualTo('c');
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("range: %d", index);
    }
}
