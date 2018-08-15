package ru.job4j.array;
/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
    BubbleSort bubble = new BubbleSort();
    int[] input = new int[] {5, 7, 3, 1, 2};
    int[] result = bubble.sort(input);
    int[] expect = new int[] {1, 2, 3, 5, 7};
    assertThat(result, is(expect));
    }
}
