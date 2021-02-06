package org.academiadecodigo.timemaravilha;

public interface Collidable {

    public void collide();

    public GridPosition getPosition();

    public int getDimensionX();

    public int getDimensionY();

    public int getMaxX();

    public int getMaxY();

    public boolean collidedWith(Collidable other);

}
