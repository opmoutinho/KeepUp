package org.academiadecodigo.timemaravilha;

public interface Collidable {

    public void collide();

    public GridPosition getPosition();

    public int getDimensionX();

    public int getDimensionY();

    public int getMaxCol();

    public int getMaxRow();

    public boolean collidedWith(Collidable other);

}
