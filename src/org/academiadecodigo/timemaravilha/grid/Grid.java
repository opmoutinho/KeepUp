package org.academiadecodigo.timemaravilha.grid;

import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * The play field
 */
public interface Grid {

    /**
     * How many cols does the field have?
     * @return - #of cols
     */
    public int getCols();

    /**
     * How many rows does the field have?
     * @return - #of rows
     */
    public int getRows();

    /**
     * Return a random position in this field
     * @return - a random position
     */
    public GridPosition getRandomPos();

    /**
     * The pic to be displayed as background
     * @param string - the path to the pic
     */
    public void setPic(String string);

    /**
     * The over overlay
     * @param s - the path to the pic
     */
    public void setOver(String s);

    /**
     * Reset the overlay
     */
    public void resetOver();

    /**
     * Reloads the background pic, keeping everything on top of it
     * @param s - the path to the pic
     */
    public void reloadPic(String s);

}
