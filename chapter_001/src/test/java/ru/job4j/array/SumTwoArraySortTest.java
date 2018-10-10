package ru.job4j.array;
/**
 *
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SumTwoArraySortTest {
    @Test
    public  void whenArraySortFirstPlusArraySortSecondThenNewArraySort() {
        SumTwoArraySort array = new SumTwoArraySort();
        int[] inputFirst = {1, 3, 5, 7};
        int[] inputSecond = {2, 4, 6, 8};
        int[] result = array.sumArray(inputFirst, inputSecond);
        int[] expect = {1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(result, is(expect));
    }
}
