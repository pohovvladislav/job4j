package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 * @version $Id$.
 * @since 0.1.
 */
public class ArrayChar {
    private char[] data;

    /**
     * Class constructor.
     * @param line Word.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Checks. that the word begins with a prefix.
     * @param prefix Prefix.
     * @return Result.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        char[] auxiliary = Arrays.copyOf(data, value.length);
        result = Arrays.equals(value, auxiliary);
        return result;
    }
}
