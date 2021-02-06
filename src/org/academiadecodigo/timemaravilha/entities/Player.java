package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.Collidable;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

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
}
