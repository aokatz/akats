package ru.job4j.chess;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    @Test
    public void whenMoveBishopThenBishopMoves() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(0, 0));
        board.putFigureOnBoard(bishop);
        board.moveFigure(new Cell(0, 0), new Cell(4, 4));
        assertThat(board.getFigureFromBoard(4, 4).getClass().getCanonicalName(), is("ru.job4j.chess.Bishop"));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenTryToMoveFigureFromEmptyCellThenGotFigureNotFoundException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        thrown.expect(FigureNotFoundException.class);
        thrown.expectMessage("Figure not found on cell with coordinates: x=0 y=0");
        board.moveFigure(new Cell(0, 0), new Cell(4, 4));
    }

    @Test
    public void whenTryToMoveFigureOnOccupienWayThenGotOccupiedWayException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Figure sourceBishop = new Bishop(new Cell(0, 0));
        Figure bishopOnTheWay = new Bishop(new Cell(3, 3));
        board.putFigureOnBoard(sourceBishop);
        board.putFigureOnBoard(bishopOnTheWay);
        thrown.expect(OccupiedWayException.class);
        thrown.expectMessage("The way is occupied");
        board.moveFigure(new Cell(0, 0), new Cell(4, 4));
    }

    @Test
    public void whenTryToMoveFigureOnImpossibleWayThenGotImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Figure bishopishop = new Bishop(new Cell(0, 0));
        board.putFigureOnBoard(bishopishop);
        thrown.expect(ImpossibleMoveException.class);
        thrown.expectMessage("Impossible Move for Bishop");
        board.moveFigure(new Cell(0, 0), new Cell(3, 4));
    }
}