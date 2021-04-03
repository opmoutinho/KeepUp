package org.academiadecodigo.timemaravilha.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.Direction;

/**
 * A representation of a position in a grid
 */
public interface GridPosition {


    /**
     * What's the column of this position?
     * @return the column
     */
    public int getCol();

    /**
     * What's the row of this position?
     * @return the row
     */
    public int getRow();

    /**
     * Is this position on the border of the field?
     * @return true if it is, false otherwise
     */
    public boolean onBorder();

    /**
     * Loads name as the new frame (graphical representation)
     * @param name - the next frame
     */
    public void loadNextFrame(Picture name);

    /**
     * Set's this positions dimension to dimX and dimY (as to occupy more space in the grid)
     * @param dimX - dimension from the starting position, down
     * @param dimY - dimension from the starting position, right
     */
    public void setDimension(int dimX, int dimY);

    /**
     * Moves this position in Direction dir, units units.
     * @param dir - the direction
     * @param units - how many units
     */
    public void move(Direction dir, int units);


    /**
     * Hides this position from the grid
     */
    public void hide();

}
