package org.academiadecodigo.timemaravilha.collision;

import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class CollisionBox implements Collidable {

    private GridPosition position;
    private int dimensionX;
    private int dimensionY;

    public CollisionBox(GridPosition position, int dimensionX, int dimensionY){
        this.position = position;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    @Override
    public GridPosition getPosition() {
        return position;
    }

    @Override
    public int getDimensionX() {
        return dimensionX;
    }

    @Override
    public int getDimensionY() {
        return dimensionY;
    }

    @Override
    public int getMaxCol() {
        return position.getCol()+dimensionX-1;
    }

    @Override
    public int getMaxRow() {
        return position.getRow()+dimensionY-1;
    }


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
