package ru.job4j.array;
/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 *  * @version $Id$.
 *  * @since 0.1.
 */

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Method to remove duplicates.
     * @param array Array.
     * @return Array unique.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique - out; in++) {
                if (array[in].equals(array[out])) {
                    array[in] = array[unique - 1];
                    in--;
                    unique--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
