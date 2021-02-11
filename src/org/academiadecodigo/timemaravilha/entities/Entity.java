package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.collision.CollisionBox;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;


public abstract class Entity {

    private CollisionBox collisionBox;
    private  GridPosition position;
    private boolean dead;
    private Direction direction;

    public Entity(GridPosition position, int dimensionX, int dimensionY){
        this.position = position;
        this.position.setDimension(dimensionX,dimensionY);
        collisionBox = new CollisionBox (position,dimensionX,dimensionY);
        direction = Direction.NEUTRAL;
    }

    public GridPosition getPosition(){
        return position;
    }

    public abstract void move();

    protected abstract Direction chooseDir();

    public boolean onBorder(){
        return getPosition().onBorder();
    }

    public boolean collidedWith(Entity other){
        return getCollisionBox().collidedWith(other.getCollisionBox());
    }

    public CollisionBox getCollisionBox() {
        return collisionBox;
    }

    public abstract void collide(Entity other);

    public boolean isDead() {
        return dead;
    }

    public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void kill(){
        dead = true;
    }
}
