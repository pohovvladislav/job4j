package ru.job4j.array;

/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 * @version $Id$.
 * @since 0.1.
 */
public class Square {
    /**
     * The method fills the array.
     * @param bound Number.
     * @return Filled array.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int value = 1; value <= bound; value++) {
            rst[value - 1] = (int) Math.pow(value, 2);
        }
        return rst;
    }
}
