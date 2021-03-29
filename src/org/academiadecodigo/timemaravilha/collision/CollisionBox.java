package org.academiadecodigo.timemaravilha.collision;

import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * The implementation of Collidable
 */
public class CollisionBox implements Collidable {

    private GridPosition position; //the position
    //the dimensions
    private int dimensionX;
    private int dimensionY;

    /**
     * Constructor
     * @param position - the position
     * @param dimensionX - the dimension in the X axis (down, from position)
     * @param dimensionY - the dimension in the Y axis (right, from position)
     */
    public CollisionBox(GridPosition position, int dimensionX, int dimensionY){
        this.position = position;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    /**
     * @see Collidable#getPosition()
     */
    @Override
    public GridPosition getPosition() {
        return position;
    }

    /**
     * @see Collidable#getDimensionX()
     */
    @Override
    public int getDimensionX() {
        return dimensionX;
    }

    /**
     * @see Collidable#getDimensionY()
     */
    @Override
    public int getDimensionY() {
        return dimensionY;
    }

    /**
     * @see Collidable#getMaxCol()
     */
    @Override
    public int getMaxCol() {
        return position.getCol()+dimensionX-1;
    }

    /**
     * @see Collidable#getMaxRow()
     */
    @Override
    public int getMaxRow() {
        return position.getRow()+dimensionY-1;
    }


    /**
     * @see Collidable#collidedWith(Collidable)
     */
    @Override
    public boolean collidedWith(Collidable other) {
        boolean result = true;

        if(position.getRow() > other.getMaxRow() || other.getPosition().getRow() > getMaxRow()) {
            result = false;
        }
        if(other.getMaxCol() < position.getCol() || getMaxCol() < other.getPosition().getCol()) {
            result = false;
        }

        return result;
    }


}
