package ru.job4j.chess;

/**
 * Abstract class for chess figures
 *
 * @author AKats
 */
public abstract class Figure {
    final Cell position;

    protected Figure(Cell position) {
        this.position = position;
    }

    /**
     * Check the ability to move figure from source cell to destination cell according the chess rules
     *
     * @param source      - source cell
     * @param destination - destination cell
     * @return - the path of figure in cells array
     * @throws ImpossibleMoveException
     */
    abstract Cell[] wayOfFigure(Cell source, Cell destination) throws ImpossibleMoveException;

    /**
     * Make the copy of figure in the desdtination cell
     *
     * @param destination - destination cell
     * @return - new figure in destination cell
     */
    abstract Figure copyFigure(Cell destination);
}
