package ru.job4j.array;

/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 * @version $Id$.
 * @since 0.1.
 */
public class BubbleSort {
    /**
     * The method sorts the array.
     * @param array Array.
     * @return Sorted array.
     */
    public int[] sort(int[] array) {
        // Количество проходов по массиву.
        for (int j = 1; j < array.length; j++) {
            // Количество сравнений в массиве.
            for (int i = 0; i < array.length - j; i++) {
                int temp = array[i];
                if (array[i] > array[i + 1]) {
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
}
