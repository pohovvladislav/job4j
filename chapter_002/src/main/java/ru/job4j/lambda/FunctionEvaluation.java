package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author В-87
 */
public class FunctionEvaluation {
    /**
     * The method counts the function in the range.
     * @param start First number.
     * @param end Second number.
     * @param func Function.
     * @return List value of function.
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(func.apply((double) i));
        }
        return list;
    }
}
