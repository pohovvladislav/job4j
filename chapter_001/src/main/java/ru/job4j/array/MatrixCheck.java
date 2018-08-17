package ru.job4j.array;

/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 * @version $Id$.
 * @since 0.1.
 */
public class MatrixCheck {
    /**
     * The method checks the elements of the array diagonally.
     * @param data Array.
     * @return Result.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
            result = (data[0][data.length - 1] == data[i][data.length - 1 - i]);
        }
        return result;
    }
}