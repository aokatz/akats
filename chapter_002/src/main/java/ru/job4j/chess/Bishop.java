package ru.job4j.chess;

import java.util.Arrays;

/**
 * Bishop class
 *
 * @author AKats
 */
public class Bishop extends Figure {

    protected Bishop(Cell position) {
        super(position);
    }

    @Override
    public Cell[] wayOfFigure(Cell source, Cell destination) throws ImpossibleMoveException {
        Cell[] res = new Cell[8];
        if (Math.abs(source.getX() - destination.getX()) != Math.abs(source.getY() - destination.getY())) {
            throw new ImpossibleMoveException("Impossible Move for Bishop");
        }
        if (destination.getX() > source.getX() && destination.getY() > source.getY()) {
            for (int i = 0; i < Math.abs(source.getX() - destination.getX()); i++) {
                res[i] = new Cell(source.getX() + i, source.getY() + i);
            }
        }
        if (destination.getX() > source.getX() && destination.getY() < source.getY()) {
            for (int i = 0; i < Math.abs(source.getX() - destination.getX()); i++) {
                res[i] = new Cell(source.getX() + i, source.getY() - i);
            }
        }
        if (destination.getX() < source.getX() && destination.getY() > source.getY()) {
            for (int i = 0; i < Math.abs(source.getX() - destination.getX()); i++) {
                res[i] = new Cell(source.getX() - i, source.getY() + i);
            }
        }
        if (destination.getX() < source.getX() && destination.getY() < source.getY()) {
            for (int i = 0; i < Math.abs(source.getX() - destination.getX()); i++) {
                res[i] = new Cell(source.getX() - i, source.getY() - i);
            }
        }
        return Arrays.stream(res)
                .filter(cell -> cell != null)
                .toArray(Cell[]::new);
    }

    @Override
    public Figure copyFigure(Cell destination) {
        return new Bishop(destination);
    }
}
