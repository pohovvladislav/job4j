package ru.job4j.array;

/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 * @version $Id$.
 * @since 0.1.
 */
public class Check {
    /**
     * A method of checking array elements.
     * @param data Array.
     * @return Result.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (boolean element : data) {
            if (data[0] != element) {
                result = false;
                break;
            }
        }
        return result;
    }
}
