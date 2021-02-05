package org.academiadecodigo.timemaravilha;

public abstract class Entities {

    private CollisionBox collisionBox;
    private GridPosition position;

    public Entities (GridPosition position,int x, int y){
        this.position = position;
        collisionBox = (x,y);

    }




}
