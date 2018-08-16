package ru.job4j.array;
/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenThen() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {{1, 2}, {2, 4}};
        assertThat(table, is(expect));
    }
}
