package ru.job4j.loop;

/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 */
public class Counter {
    /**
     * Sum of even numbers.
     * @param start First number.
     * @param finish Last number.
     * @return Amount.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (; start <= finish; start++) {
            if (start % 2 == 0) {
                result += start;
            }
        }
        return result;
    }

}
