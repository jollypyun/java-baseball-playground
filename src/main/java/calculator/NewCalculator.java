package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NewCalculator {
    private static final String REGEXP = "^[0-9]*$";
    private int result = 0;
    private Operator operator;

    public int execute() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        for(String input : values) {
            calculateOrChangeOperate(input);
        }
        return result;
    }

    private void calculateOrChangeOperate(String input) {
        if (Pattern.matches(REGEXP, input)) {
            result = operator.operate(result, Integer.parseInt(input));
            return ;
        }
        operator = Operator.findOperate(input);
    }
}
