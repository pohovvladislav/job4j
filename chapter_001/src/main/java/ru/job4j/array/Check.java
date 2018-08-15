package ru.job4j.array;

/**
 *
 */
public class Check {
    /**
     * A method of checking array elements.
     * @param data Array.
     * @return Result.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        int counter = 0;
        for (boolean element : data) {
            if (element) {
                counter++;
            }
        }
        if (counter == 0 || counter == data.length) {
            result = true;
        }
        return result;
    }
}
