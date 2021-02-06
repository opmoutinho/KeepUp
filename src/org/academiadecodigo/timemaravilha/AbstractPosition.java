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




}
