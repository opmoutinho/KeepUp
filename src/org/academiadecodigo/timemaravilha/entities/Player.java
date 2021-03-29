package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.AbstractCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Immunity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Vaccine;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * Representation of our Player
 */
public class Player extends Entity {

    private int health = 3;
    private boolean mask;
    private boolean[] keysPressed;
    private int vaccineCounter;

    /**
     * @see Entity#Entity(GridPosition, int, int, EntityType)
     */
    public Player (GridPosition playerPos,int dimensionX, int dimensionY){
        super(playerPos,dimensionX,dimensionY,EntityType.PLAYER);
    }

    /**
     * Sets keysPressed to keysPressed
     * @param keysPressed - the array of keysPressed
     */
    public void setKeysPressed(boolean[] keysPressed) {
        this.keysPressed = keysPressed;
    }

    /**
     * @see Entity#move()
     */
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

    /**
     * @see Entity#chooseDir()
     */
    @Override
    protected Direction chooseDir() {
        throw new UnsupportedOperationException("The player's direction is chosen based on input");
    }

    /**
     * @see Entity#collidedWith(Entity)
     */
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

        } else if (other instanceof Mask) {
            mask = true;

        }else if (other instanceof Immunity){
            health = Math.min(4, health+1);

        }else if (other instanceof Vaccine){
            vaccineCounter++;

        }
    }

    /**
     * What's this players HP
     * @return the HP
     */
    public int getHealth(){
        return health;
    }

    /**
     * How many vaccines has the player captured
     * @return
     */
    public int getVaccineCounter() {
        return vaccineCounter;
    }

    /**
     * @see Entity#loadCondition()
     */
    @Override
    protected int loadCondition() {
        return mask ? 1 : 0;
    }

    /**
     * Is the player masked
     * @return true if he is, false otherwise
     */
    public boolean isMask(){
        return mask;
    }
}
