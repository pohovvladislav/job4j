package ru.job4j;

import java.util.List;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test
 */
public class FunctionEvaluationTest {
    private FunctionEvaluation function = new FunctionEvaluation();
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSquareFunctionThenSquareResults() {
        assertThat(function.diapason(1, 4, x -> Math.pow(x, 2) - x + 1), is(Arrays.asList(1D, 3D, 7D)));
    }
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        assertThat(function.diapason(1, 4, x -> Math.ceil(Math.exp(x) + x)), is(
                Arrays.asList(4D, 10D, 24D)));
    }
}
