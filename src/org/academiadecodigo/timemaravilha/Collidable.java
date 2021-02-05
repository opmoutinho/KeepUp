package org.academiadecodigo.timemaravilha;

public interface Collidable {

    public void collide();

    public GridPosition getPosition();

    public int getDimensionX();

    public int getDimensionY();

    public boolean collidedWith(Collidable other);

}
