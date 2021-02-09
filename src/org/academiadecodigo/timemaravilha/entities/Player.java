package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Player extends Entity {

    private int health = 3;
    private boolean mask;
    private boolean immunity;
    private boolean sick;

    public Player (GridPosition playerPos,int dimensonX, int dimensionY){
        super(playerPos,dimensonX,dimensionY);
    }

    @Override
    public void move() {

    }

    public void moveUp(){
        if(isDead())
            return;
        getPosition().move(Direction.UP,1);
        EntityManager.getInstance().checkPlayerCollision(this);
    }

    public void moveDown(){
        if(isDead())
            return;
        getPosition().move(Direction.DOWN,1);
        EntityManager.getInstance().checkPlayerCollision(this);
    }

    public void moveLeft(){
        if(isDead())
            return;
        getPosition().move(Direction.LEFT,1);
        EntityManager.getInstance().checkPlayerCollision(this);
    }

    public void moveRight(){
        if(isDead())
            return;
        getPosition().move(Direction.RIGHT,1);
        EntityManager.getInstance().checkPlayerCollision(this);
    }

    @Override
    public boolean collidedWith(Entity other) {
        return getCollisionBox().collidedWith(other.getCollisionBox());
    }

    public void collide(Entity other){
        if(other instanceof Covidinhos){
            if(!mask)
                health--;
            else
                mask = false;

            if(health == 0){
                getPosition().setColor(Color.RED);
                getPosition().show();
                kill();
                EntityManager.getInstance().setInactive(this);
            }
            System.out.println("Player Collided with Covidinho");
        } else if (other instanceof Mask){
            mask = true;
            System.out.println("Player Collided with Mask");

        }else {
            System.out.println("Player Didn't collided!? :O ");
        }
    }

    public void setArmor(){
        //for a certain amount of time
        this.mask = true;
    }

    public void setImmunity(){
        this.immunity = true;
    }

    public void isSick(){
        if (!mask) {
            this.sick = true;
        }
    }

    public void setHealth() {

    }
}
