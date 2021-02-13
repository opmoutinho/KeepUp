package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.AbstractCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.SimpleCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Immunity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Vaccine;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Player extends Entity {

    private int health = 3;
    private boolean mask;
    private boolean[] keysPressed;
    private int vaccineCounter;

    public Player (GridPosition playerPos,int dimensionX, int dimensionY){
        super(playerPos,dimensionX,dimensionY,EntityType.PLAYER);
    }

    public void setKeysPressed(boolean[] keysPressed) {
        this.keysPressed = keysPressed;
    }

    @Override
    public void move() {
        if(isDead())
            return;
        if(keysPressed[0])
            getPosition().move(Direction.UP,2);
        if(keysPressed[1])
            getPosition().move(Direction.DOWN,2);
        if(keysPressed[2]) {
            getPosition().move(Direction.LEFT, 2);
            if(!spriteManager.isFlipped()) {
                spriteManager.setFlipped(true);
            }
        }
        if(keysPressed[3]) {
            getPosition().move(Direction.RIGHT, 2);
            if(spriteManager.isFlipped()) {
                spriteManager.setFlipped(false);
            }
        }
    }

    @Override
    public Direction chooseDir() {
        return null;
    }

    public void collide(Entity other){
        if(other instanceof AbstractCovidinho){
            if(!mask)
                health--;
            else
                mask = false;

            if(health == 0){
                kill();
                EntityManager.getInstance().setInactive(this);
            }
            System.out.println("Player Collided with Covidinho");

        } else if (other instanceof Mask) {
            mask = true;
            System.out.println("Player Collided with Mask");

        }else if (other instanceof Immunity){
            health ++;
            System.out.println("Player Collided with Immunity");

        }else if (other instanceof Vaccine){
            vaccineCounter++;
            System.out.println("Player Collided with Vaccine");

        }else {
            System.out.println("Player Didn't collided!? :O ");
        }
    }

}
