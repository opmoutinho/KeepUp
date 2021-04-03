package org.academiadecodigo.timemaravilha.grid;


/**
 * An abstract grid representation
 */
public abstract class AbstractGrid implements Grid {

    private int cols; //The column size of this grid
    private int rows; //The row size of this grid

    /**
     * Constructor
     * @param cols - The number of Cols
     * @param rows - The number of rows
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
