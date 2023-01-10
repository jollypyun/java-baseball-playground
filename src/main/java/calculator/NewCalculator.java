package calculator;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NewCalculator {
    private int result = 0;
    private Operator operator = Operator.PLUS;;

    public int execute() {
        Scanner scanner = new Scanner(System.in);
        String value;
        String[] values;
        try {
            value = scanner.nextLine();
            values = value.split(" ");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("공백 입력은 불가하다.");
        }
        scanner.close();

        try {
            return calculate(values);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("입력이 잘못 되었다.");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 자리에 다른 것을 입력했거나 띄어쓰기가 잘못 되었다.");
        }
    }

    private int calculate(String[] input) {
        result = Integer.parseInt(input[0]);
        for(int i = 1; i < input.length; i += 2) {
            operator = Operator.findOperate(input[i]);
            result = operator.operate(result, Integer.parseInt(input[i+1]));
        }
        return result;
    }
}
