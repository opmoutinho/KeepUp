package org.academiadecodigo.timemaravilha.collision;

import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * An interface of a collidable object
 */
public interface Collidable {

    /**
     * What's this Collidable position?
     * @return the position
     */
    public GridPosition getPosition();

    /**
     * Get the dimension in the X-axis
     * @return the dimension
     */
    public int getDimensionX();

    /**
     * Get the dimension in the Y-axis
     * @return the dimension
     */
    public int getDimensionY();

    /**
     * What's the maximum column this Collidable occupies?
     * @return the value
     */
    public int getMaxCol();

    /**
     * What's the maximum row this Collidable occupies?
     * @return the value
     */
    public int getMaxRow();

    /**
     * Has this Collidable collided with another?
     * @param other - the other
     * @return true if it has, false otherwise
     */
    public boolean collidedWith(Collidable other);

}
