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
    public void collide() {
    }

    @Override
    public boolean collidedWith(Collidable other) {
        for (int i=0; i<getDimensionX(); i++){

        }
        return false;
    }


}
