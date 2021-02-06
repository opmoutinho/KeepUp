package org.academiadecodigo.timemaravilha;

public abstract class AbstractPosition implements GridPosition {

    private int col;
    private int row;
    private Grid grid;

    public AbstractPosition(int col, int row, Grid grid){
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

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

    private void moveUp(int units){
        if(units < 0)
            return;
        row = Math.max(0, row-units);
    }

    private void moveDown(int units){
        if(units < 0)
            return;
        row = Math.min(grid.getRows()-1, row+units);
    }

    private void moveLeft(int units){
        if(units < 0)
            return;
        col = Math.max(0, col-units);
    }

    private void moveRight(int units){
        col = Math.min(grid.getCols()-1, col+units);
    }
}
