package org.academiadecodigo.timemaravilha.grid.position;

import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.Grid;

/**
 * An abstract class representing position && dimension
 */
public abstract class AbstractPosition implements GridPosition {

    private int col; // the column size to this position
    private int row; // the row size to this position
    private int dimensionX; // dimension from the starting position right
    private int dimensionY; // dimension from the starting position down
    private Grid grid; // the grid where this position will be displayed

    /**
     * Constructor
     * @param col - The col
     * @param row - The row
     * @param grid - The grid this position is inserted
     */
    public AbstractPosition(int col, int row, Grid grid){
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    /**
     * @see GridPosition#getCol()
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * @see GridPosition#getRow()
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * @see GridPosition#onBorder()
     */
    @Override
    public boolean onBorder() {
        return col == 0 || col == grid.getCols()-dimensionX ||
                row == 0 || row == grid.getRows()-dimensionY;
    }

    /**
     * @see GridPosition#setDimension(int, int)
     */
    @Override
    public void setDimension(int dimX, int dimY){
        dimensionX = dimX;
        dimensionY = dimY;
    }

    /**
     * @see GridPosition#move(Direction, int)
     */
    @Override
    public void move(Direction dir, int units){
        switch (dir){
            case UP:
                moveUp(units);
                break;
            case DOWN:
                moveDown(units);
                break;
            case LEFT:
                moveLeft(units);
                break;
            case RIGHT:
                moveRight(units);
                break;
        }
    }

    /**
     * Aux method
     *
     * Move this position up units units
     * @param units - The units
     */
    private void moveUp(int units){
        if(units < 0)
            return;
        row = Math.max(0, row-units);
    }

    /**
     * Aux method
     *
     * Move this position down units units
     * @param units the units
     */
    private void moveDown(int units){
        if(units < 0)
            return;
        row = Math.min(grid.getRows()-dimensionY, row+units);
    }

    /**
     * Aux method
     *
     * Move this position left units units
     * @param units the units
     */
    private void moveLeft(int units){
        if(units < 0)
            return;
        col = Math.max(0, col-units);
    }

    /**
     * Aux method
     *
     * Move this position right units units
     * @param units the units
     */
    private void moveRight(int units){
        if(units < 0)
            return;
        col = Math.min(grid.getCols()-(dimensionX+24), col+units);
    }

}
