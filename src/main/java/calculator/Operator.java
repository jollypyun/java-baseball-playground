package calculator;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS ("+", (first, second) -> first + second),
    MINUS ("-", (first, second) -> first - second),
    MULLTIPLY ("*", (first, second) -> first * second),
    DIVIDE ("/", (first, second) -> {
        if (second == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return first / second;
    });

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    private static final Map<String, Operator> operatorMap = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(Operator::getSymbol, operator -> operator)));
    public int operate(int first, int second) {
        return operation.apply(first, second);
    }
    public static Operator findOperate(String symbol) {
        Operator operator = operatorMap.get(symbol);
        if (operator == null) throw new IllegalArgumentException("연산 문자 이외에는 불가하다.");
        return operator;
    }
}
