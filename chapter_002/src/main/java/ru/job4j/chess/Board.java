package ru.job4j.chess;

/**
 * Chess board class
 *
 * @author AKats
 */
public class Board {
    private Figure[][] figures = new Figure[8][8];

    /**
     * Puts figure on the board
     *
     * @param figure - figure to put
     */
    public void putFigureOnBoard(Figure figure) {
        if (isCellEmpty(figure.position)) {
            figures[figure.position.getX()][figure.position.getY()] = figure;
        } /*else {
              TODO OccupiedCellException
        }*/
    }

    /**
     * Get the figure from the board
     *
     * @param x - x coordinate on board
     * @param y - y coordinate on board
     * @return - figure
     * @throws FigureNotFoundException
     */
    public Figure getFigureFromBoard(int x, int y) throws FigureNotFoundException {
        if (!isCellEmpty(new Cell(x, y))) {
            return figures[x][y];
        } else {
            throw new FigureNotFoundException("Figure not found on cell with coordinates: x=" + Integer.toString(x) + " y=" + Integer.toString(y));
        }
    }

    /**
     * Checks whether the cell is empty
     *
     * @param cell - cell to check
     * @return - true if the cell is empty, false otherwise
     */
    private boolean isCellEmpty(Cell cell) {
        return figures[cell.getX()][cell.getY()] == null;
    }

    /**
     * Move figure from cource cell to dest cell
     *
     * @param source - source cell
     * @param dest   - destination cell
     * @return - true in case of successful move
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public boolean moveFigure(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure figure = getFigureFromBoard(source.getX(), source.getY());
        Cell[] figureWay = figure.wayOfFigure(source, dest);
        //check the way to dest cell is free
        for (int i = 1; i < figureWay.length; i++) {
            if (this.figures[figureWay[i].getX()][figureWay[i].getY()] != null) {
                throw new OccupiedWayException("The way is occupied");
            }
        }
        //create figure on dest cell (move the figure)
        putFigureOnBoard(figure.copyFigure(dest));
        this.figures[source.getX()][source.getY()] = null;
        return true;
    }
}
