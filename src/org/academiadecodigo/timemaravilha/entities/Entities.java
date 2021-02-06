package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.collision.CollisionBox;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public abstract class Entities {

    private CollisionBox collisionBox;
    private GridPosition position;

    public Entities (GridPosition position,int dimensionX, int dimensionY){
        this.position = position;
        collisionBox = new CollisionBox (position,dimensionX,dimensionY);
    }

    public GridPosition getPosition(){
        return position;
    }

    public abstract void move();

    public abstract boolean collidedWith(Entities other);

    public CollisionBox getCollisionBox() {
        return collisionBox;
    }
}
