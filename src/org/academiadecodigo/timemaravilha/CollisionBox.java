package org.academiadecodigo.timemaravilha;

public class CollisionBox implements Collidable{

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
    public int getMaxX() {
        return position.getCol()+dimensionX-1;
    }

    @Override
    public int getMaxY() {
        return position.getRow()+dimensionY-1;
    }

    @Override
    public void collide() {
    }

    @Override
    public boolean collidedWith(Collidable other) {
        boolean result = true;

        if(position.getRow() < other.getMaxY() || other.getPosition().getRow() < getMaxY())
            result = false;

        if(other.getMaxX() < position.getCol() || getMaxX() < other.getPosition().getCol())
            result = false;

        return result;
    }


}
