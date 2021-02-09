package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Player extends Entity {

    private int health = 3;
    private boolean mask;
    private boolean[] keysPressed;
    private boolean immunity;
    private boolean sick;

    public Player (GridPosition playerPos,int dimensonX, int dimensionY){
        super(playerPos,dimensonX,dimensionY);
    }

    public void setKeysPressed(boolean[] keysPressed) {
        this.keysPressed = keysPressed;
    }

    @Override
    public void move() {
        if(isDead())
            return;
        if(keysPressed[0])
            getPosition().move(Direction.UP,1);
        if(keysPressed[1])
            getPosition().move(Direction.DOWN,1);
        if(keysPressed[2])
            getPosition().move(Direction.LEFT,1);
        if(keysPressed[3])
            getPosition().move(Direction.RIGHT,1);
        EntityManager.getInstance().checkCollision(this);
    }

    public void collide(Entity other){
        if(other instanceof Covidinho){
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
