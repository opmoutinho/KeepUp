package org.academiadecodigo.timemaravilha.grid;

import org.academiadecodigo.timemaravilha.grid.Grid;

public abstract class AbstractGrid implements Grid {

    private int cols;
    private int rows;

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public int getRows() {
        return rows;
    }
}
