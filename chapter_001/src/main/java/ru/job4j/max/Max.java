package ru.job4j.max;

/**
 * @author Popov Vladislav.
 */
public class Max {
    /**
     * Determining the maximum of two numbers.
     * @param first Number 1.
     * @param second Number 2.
     * @return Result
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Determining the maximum of three numbers.
     * @param first Number 1.
     * @param second Number 2.
     * @param third Number 3.
     * @return Result.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
