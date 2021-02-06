package org.academiadecodigo.timemaravilha.Entities;

import org.academiadecodigo.timemaravilha.Collidable;
import org.academiadecodigo.timemaravilha.CollisionBox;
import org.academiadecodigo.timemaravilha.GridPosition;

public abstract class Entities {

    private CollisionBox collisionBox;
    private GridPosition position;

    public Entities (GridPosition position,int positionX, int positionY){
        this.position = position;
        collisionBox = new CollisionBox (position,positionX,positionY);
    }




}
