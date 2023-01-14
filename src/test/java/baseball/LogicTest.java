package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
public class LogicTest {
    private MatchingLogic matchingLogic;
    private InputView inputView = new InputView();

    private static void inputString(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("ANSWER 생성 테스트")
    @Test
    void makeAnswerTest() {
        assertThat(matchingLogic.play(1)).isTrue();
    }

    @DisplayName("게임 종료 테스트")
    @Test
    void gameEndTest() {
        assertThat(matchingLogic.play(2)).isFalse();
    }

    @DisplayName("결과물 산출 테스트(낫싱)")
    @Test
    void nothing() {
        inputString("513");
    }
}
