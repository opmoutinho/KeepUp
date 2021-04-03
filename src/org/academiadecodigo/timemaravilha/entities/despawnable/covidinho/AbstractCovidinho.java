package org.academiadecodigo.timemaravilha.entities.despawnable.covidinho;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.AbstractPowerUp;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Vaccine;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * A representation of a Covidinho
 */
public abstract class AbstractCovidinho extends DespawnableEntity {

    private boolean rooted; //Is this entity rooted?

    /**
     * @see DespawnableEntity#DespawnableEntity(GridPosition, int, int, EntityType, long)
     */
    public AbstractCovidinho(GridPosition position, int dimensionX, int dimensionY, EntityType type, long despawnTime) {
        super(position, dimensionX, dimensionY, type, despawnTime);
    }

    /**
     * @see DespawnableEntity#move()
     */
    @Override
    public void move() {
        if (!isDead() && !rooted) {
            Direction direction = chooseDir();
            getPosition().move(direction, 1);
            setDirection(direction);
        }
    }

    /**
     * @see DespawnableEntity#chooseDir()
     */
    @Override
    protected Direction chooseDir(){
        return randomDir();
    }

    /**
     * Aux method to choose a random direction.
     * Has a 90% to keep moving in the same direction (plane, if it's in the field's border) as the previous iteration,
     * and a 10% to change plane
     * @return a random direction
     */
    protected Direction randomDir(){
        Direction dir;
        if(getDirection() == Direction.NEUTRAL) {
            Direction[] directions = Direction.values();
            int random = (int) (Math.random() * directions.length);
            dir = directions[random];
        } else if(Math.random() > 0.1){
            if(onBorder())
                dir = getDirection().opposite();
            else
                dir = getDirection();
        } else {
            Direction[] directions = getDirection().changePlane();
            int random = (int) (Math.random() * directions.length);
            dir = directions[random];
        }
        return dir;
    }

    /**
     * @see DespawnableEntity#collide(Entity)
     */
    @Override
    public void collide(Entity other){
        if(other instanceof Player || other instanceof Vaccine){
            despawn();
        } else if (other instanceof Mask){
            rooted = true;
        }
    }

    /**
     * @see DespawnableEntity#loadCondition()
     */
    @Override
    protected int loadCondition(){
        return rooted ? 1 : 0;
    }

}
