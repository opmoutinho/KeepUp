package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.collision.CollisionBox;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;


public abstract class Entity {

    private CollisionBox collisionBox;
    private  GridPosition position;
    private boolean dead;

    public Entity(GridPosition position, int dimensionX, int dimensionY){
        this.position = position;
        collisionBox = new CollisionBox (position,dimensionX,dimensionY);
    }

    public GridPosition getPosition(){
        return position;
    }

    public abstract void move();

    public abstract boolean collidedWith(Entity other);

    public CollisionBox getCollisionBox() {
        return collisionBox;
    }

    public abstract void collide(Entity other);

    public boolean isDead() {
        return dead;
    }

    public void kill(){
        dead = true;
    }
}
