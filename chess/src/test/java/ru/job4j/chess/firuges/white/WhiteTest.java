package ru.job4j.chess.firuges.white;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WhiteTest {
    @Test
    public void whenPawnWhiteGo() {
        PawnWhite pawnWhite = new PawnWhite(Cell.A2);
        Cell[] result = pawnWhite.way(Cell.A2, Cell.A3);
        Cell[] expect = {Cell.A3};
        assertThat(result, is(expect));
    }
    @Test
    public void whenBishopWhiteGo() {
        BishopWhite bishopWhite = new BishopWhite(Cell.C3);
        assertThat(bishopWhite.way(Cell.A3, Cell.E7), is(new Cell[]{Cell.B4, Cell.C5, Cell.D6, Cell.E7}));
        assertThat(bishopWhite.way(Cell.A3, Cell.C1), is(new Cell[]{Cell.B2, Cell.C1}));
        assertThat(bishopWhite.way(Cell.F5, Cell.C8), is(new Cell[]{Cell.E6, Cell.D7, Cell.C8}));
        assertThat(bishopWhite.way(Cell.H4, Cell.E1), is(new Cell[]{Cell.G3, Cell.F2, Cell.E1}));
    }
    @Test
    public void whenKingWhiteGo() {
        KingWhite kingWhite = new KingWhite(Cell.A5);
        assertThat(kingWhite.way(Cell.A5, Cell.B5), is(new Cell[]{Cell.B5}));
    }
    @Test
    public void whenRookWhiteGo() {
        RookWhite rookWhite = new RookWhite(Cell.C1);
        assertThat(rookWhite.way(Cell.C1, Cell.F1), is(new Cell[]{Cell.D1, Cell.E1, Cell.F1}));
        System.out.println();
        assertThat(rookWhite.way(Cell.C1, Cell.C4), is(new Cell[]{Cell.C2, Cell.C3, Cell.C4}));
    }
    @Test
    public void whenQueenWhiteGo() {
        QueenWhite queenWhite = new QueenWhite(Cell.E4);
        assertThat(queenWhite.way(Cell.E4, Cell.E8), is(new Cell[]{Cell.E5, Cell.E6, Cell.E7, Cell.E8}));
        assertThat(queenWhite.way(Cell.E4, Cell.H4), is(new Cell[]{Cell.F4, Cell.G4, Cell.H4}));
        assertThat(queenWhite.way(Cell.H4, Cell.E1), is(new Cell[]{Cell.G3, Cell.F2, Cell.E1}));
        assertThat(queenWhite.way(Cell.E1, Cell.A1), is(new Cell[]{Cell.D1, Cell.C1, Cell.B1, Cell.A1}));
        assertThat(queenWhite.way(Cell.A3, Cell.E7), is(new Cell[]{Cell.B4, Cell.C5, Cell.D6, Cell.E7}));
    }
    @Test
    public void whenKnightWhiteGo() {
        KnightWhite knightWhite = new KnightWhite(Cell.A1);
        assertThat(knightWhite.way(Cell.A2, Cell.C1), is(new Cell[]{Cell.C1}));
    }
}