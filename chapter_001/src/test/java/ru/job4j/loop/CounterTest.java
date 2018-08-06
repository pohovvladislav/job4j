package ru.job4j.loop;
/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(0, 10);
        int expect = 30;
        assertThat(result, is(expect));
    }
}
