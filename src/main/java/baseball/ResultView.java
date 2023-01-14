package baseball;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private MatchingLogic matchingLogic;
    private String result = "";

    public void showResult() {
        List<Integer> ret = Arrays.asList(matchingLogic.execute());
        int strike = (int) ret.stream().filter(r -> r == 2).count();
        int ball = (int) ret.stream().filter(r -> r == 1).count();
        result = check(ball, strike);
    }

    private String check(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        return "";
    }
}
