package org.academiadecodigo.timemaravilha.grid;

import org.academiadecodigo.timemaravilha.grid.Grid;

public abstract class AbstractGrid implements Grid {

    private int cols;
    private int rows;

    public AbstractGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public int getRows() {
        return rows;
    }
}
