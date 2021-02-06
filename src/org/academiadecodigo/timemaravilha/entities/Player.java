package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.Collidable;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Player extends Entities{

    private int health = 3;
    private boolean armor;
    private boolean immunity;
    private boolean sick;

    public Player (GridPosition playerPos,int dimensonX, int dimensionY){
        super(playerPos,dimensonX,dimensionY);
    }

    @Override
    public void move() {

    }

    public void moveUp(){
        getPosition().move(Direction.UP,1);
    }

    public void moveDown(){
        getPosition().move(Direction.DOWN,1);
    }

    public void moveLeft(){
        getPosition().move(Direction.LEFT,1);
    }

    public void moveRight(){
        getPosition().move(Direction.RIGHT,1);
    }

    @Override
    public void collidedWith(Entities other) {
        if(getCollisionBox().collidedWith(other.getCollisionBox())){
            System.out.println("Collided");
        }

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

    public void setHealth() {

    }
}
