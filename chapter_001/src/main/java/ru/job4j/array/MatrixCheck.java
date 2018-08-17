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
        boolean result = true; int counter = 0; int counterTrue = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if ((i + j) % 2 == 0) {
                    counter++;
                    if (data[i][j]) {
                        counterTrue++;
                    }
                }
            }
        }
        if (data.length > 2) {
            result = (counter == counterTrue || counterTrue == 0);
        } else {
            result = (data[0][0] == data[1][1] && data[0][1] == data[1][0]);
        }
        return result;
    }
}