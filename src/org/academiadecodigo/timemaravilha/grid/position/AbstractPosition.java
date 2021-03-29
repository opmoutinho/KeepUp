package org.academiadecodigo.timemaravilha.grid.position;

import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.Grid;

public abstract class AbstractPosition implements GridPosition {

    private int col;
    private int row;
    private int dimensionX;
    private int dimensionY;
    private Grid grid;

    /**
     * The constructor
     * @param col - the col
     * @param row - the row
     * @param grid - the grid this position is inserted
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
     * Aux method. move this position up units units
     * @param units the units
     */
    private void moveUp(int units){
        if(units < 0)
            return;
        row = Math.max(0, row-units);
    }

    /**
     * Aux method. move this position down units units
     * @param units the units
     */
    private void moveDown(int units){
        if(units < 0)
            return;
        row = Math.min(grid.getRows()-dimensionY, row+units);
    }

    /**
     * Aux method. move this position left units units
     * @param units the units
     */
    private void moveLeft(int units){
        if(units < 0)
            return;
        col = Math.max(0, col-units);
    }

    /**
     * Aux method. move this position right units units
     * @param units the units
     */
    private void moveRight(int units){
        if(units < 0)
            return;
        col = Math.min(grid.getCols()-(dimensionX+24), col+units);
    }

}
