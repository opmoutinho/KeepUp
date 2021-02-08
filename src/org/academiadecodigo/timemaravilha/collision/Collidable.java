package org.academiadecodigo.timemaravilha.collision;

import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public interface Collidable {

    public GridPosition getPosition();

    public int getDimensionX();

    public int getDimensionY();

    public int getMaxCol();

    public int getMaxRow();

    public boolean collidedWith(Collidable other);

}
