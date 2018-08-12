package ru.job4j.loop;
/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 * @version $Id$.
 * @since 0.1.
 */
import java.util.function.BiPredicate;

public class Paint {
    /**
     * Method of painting a square diagonally on the right side.
     * @param height Height.
     * @return Painting square.
     */
    public String rightTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= column);
    }

    /**
     * Method of painting a square diagonally on the left side.
     * @param height Height.
     * @return Painting square.
     */
    public String leftTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= height - column - 1);
    }

    /**
     * The method of drawing the pyramid.
     * @param height Height.
     * @return Pyramid images.
     */
    public String pyramid(int height) {
        return this.loopBy(height, 2 * height - 1, (row, column) -> row >= height - column - 1 && row + height - 1 >= column);
    }
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
