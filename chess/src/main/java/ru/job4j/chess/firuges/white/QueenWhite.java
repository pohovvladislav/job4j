package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenWhite implements Figure {
    private final Cell position;

    public QueenWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y) || dest.x == source.x || dest.y == source.y) {
            int deltaX = (int) Math.signum(dest.x - source.x);
            int deltaY = (int) Math.signum(dest.y - source.y);
            int size = Math.abs(dest.x - source.x) > Math.abs(dest.y - source.y) ? dest.x - source.x : dest.y - source.y;
            steps = new Cell[Math.abs(size)];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.values()[(source.x + deltaX * (i + 1)) * 8 + source.y + deltaY * (i + 1)];
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenWhite(dest);
    }
}
