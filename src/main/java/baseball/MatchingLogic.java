package baseball;

import java.util.*;

public class MatchingLogic {
    private static String ANSWER;
    private static String[] MINE;
    private InputView inputView = new InputView();

    public Boolean play(int num) {
        if (num == 2) {
            return false;
        }
        makeAnswer();
        return true;
    }

    public Integer[] execute() {
        MINE = inputView.inputView().split("");
        Integer[] result = new Integer[3];
        for(int i = 0; i < 3; i++) {
            result[i] = checkWhat(MINE[i], ANSWER.substring(i,i+1));
        }
        return result;
    }

    private void makeAnswer() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 3) {
            set.add(random.nextInt(9) + 1);
        }
    }

    private Integer checkWhat(String m, String a) {
        if (m == a) {
            return 2;
        }
        if (ANSWER.contains(m)) {
            return 1;
        }
        return 0;
    }
}
