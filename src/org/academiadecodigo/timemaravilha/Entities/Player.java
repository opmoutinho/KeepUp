package org.academiadecodigo.timemaravilha.Entities;

import org.academiadecodigo.timemaravilha.Collidable;
import org.academiadecodigo.timemaravilha.CollisionBox;
import org.academiadecodigo.timemaravilha.Grid;
import org.academiadecodigo.timemaravilha.GridPosition;

public class Player extends Entities{

    private int health = 3;
    private boolean armor;
    private boolean immunity;
    private boolean sick;
    private GridPosition playerPos;
    private int positionX;
    private int positionY;

    public Player (GridPosition playerPos,int positionX, int positionY){
        super(playerPos,positionX,positionY);
    }

    public void setArmor(){
        //for a certain amount of time
        this.armor = true;
    }

    public void setImmunity(){
        this.immunity = true;
    }

    public void isSick(){
        if (!armor) {
            this.sick = true;
        }
    }

    @Override
    public void collide(){};

    @Override
    public GridPosition getPosition(){
        return playerPos;
    };

    @Override
    public int getDimensionX(){
        return
    };

    @Override
    public int getDimensionY(){};

    @Override
    public boolean collidedWith(Collidable other){};

}
