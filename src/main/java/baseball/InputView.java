package baseball;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
    private static final String REGEXP = "^[1-9]{3}$";
    private String value;

    public String inputView() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        int len;
        try {
            value = scanner.nextLine().trim();
            System.out.println(value);
            len = value.length();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("공백 입력은 불가합니다.");
        }
        if (len == 0) {
            throw new NoSuchElementException("공백 입력은 불가합니다.");
        }

        if (len != 3) {
            throw new IllegalArgumentException("문자열 길이가 3이 아니다.");
        }

        if (!value.matches(REGEXP)) {
            throw new IllegalArgumentException("숫자(1~9)만 입력 가능합니다.");
        }

        for(int i = 0; i < value.length(); i++) {
            overlapCheck(value.charAt(i), i);
        }

        scanner.close();
        return value;
    }

    private void overlapCheck(char chr, int i) {
        if (value.indexOf(chr) != i) {
            throw new IllegalArgumentException("중복 입력은 불가하다.");
        }
    }
}
