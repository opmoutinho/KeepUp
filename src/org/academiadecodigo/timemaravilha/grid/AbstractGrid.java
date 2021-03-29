package org.academiadecodigo.timemaravilha.grid;


/**
 * An abstract grid representation
 */
public abstract class AbstractGrid implements Grid {

    private int cols;
    private int rows;

    /**
     * The constructor
     * @param cols - number of Cols
     * @param rows - number of rows
     */
    public AbstractGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return rows;
    }
}
