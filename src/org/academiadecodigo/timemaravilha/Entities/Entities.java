package org.academiadecodigo.timemaravilha.Entities;

import org.academiadecodigo.timemaravilha.Collidable;
import org.academiadecodigo.timemaravilha.CollisionBox;
import org.academiadecodigo.timemaravilha.GridPosition;

public abstract class Entities implements Collidable {

    private CollisionBox collisionBox;
    private GridPosition position;
    private int positionX;
    private int positionY;

    public Entities (GridPosition position,int positionX, int positionY){
        this.position = position;
        collisionBox = new CollisionBox (position,positionX,positionY);
    }

    @Override
     public void collide(){};

    @Override
    public GridPosition getPosition(){
        return position;
    };

    @Override
    public int getDimensionX(){
        return positionX;
    };

    @Override
    public int getDimensionY(){
        return positionY;
    };

    @Override
    public boolean collidedWith(Collidable other){
        return false;
    };




}
