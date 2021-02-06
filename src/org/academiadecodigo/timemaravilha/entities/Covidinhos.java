package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Covidinhos extends DespawnableEntities{

    public Covidinhos(GridPosition position, int dimensionX, int dimensionY) {
        super(position,dimensionX,dimensionY);
    }


    @Override
    public void move() {
        Direction[] directions = Direction.values();
        int random = (int) (Math.random()* directions.length);
        Direction direction = directions[random];
        getPosition().move(direction,1);
        }

    @Override
    public boolean collidedWith(Entities other) {
        return getCollisionBox().collidedWith(other.getCollisionBox());

    }
}
