package calculator;

import java.util.Scanner;

public class Calculator {
    public int execute() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            result = calculate(result, Integer.parseInt(values[i+1]), values[i]);
        }
        scanner.close();
        return result;
    }

    public int calculate(int first, int second, String operation) {
        if (operation.equals("+")) {
            return first + second;
        }
        else if (operation.equals("-")) {
            return first - second;
        }
        else if (operation.equals("*")) {
            return first * second;
        }
        else if (operation.equals("/")) {
            return first / second;
        }
        return 0;
    }
}
