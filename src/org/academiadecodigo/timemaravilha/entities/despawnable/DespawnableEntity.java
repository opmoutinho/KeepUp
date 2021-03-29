package org.academiadecodigo.timemaravilha.entities.despawnable;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.game.Game;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * An implementation of a Despawnable entity
 */
public abstract class DespawnableEntity extends Entity implements Despawnable {

    private final Game.Timer timer; //this entities internal timer

    /**
     * @see Entity#Entity(GridPosition, int, int, EntityType)
     * @param despawnTime - time (in ms) that allows this entity to be despawned
     */
    public DespawnableEntity(GridPosition position, int dimensionX, int dimensionY, EntityType type, long despawnTime) {
        super(position,dimensionX,dimensionY, type);
        timer = new Game.Timer(despawnTime);
    }

    /**
     * @see Entity#move()
     */
    @Override
    public void move(){
        EntityManager.getInstance().checkCollision(this);
    }

    /**
     * @see Entity#chooseDir()
     */
    @Override
    protected Direction chooseDir() {
        return null;
    }

    /**
     * @see Despawnable#despawn()
     */
    public void despawn(){
        getPosition().hide();
        kill();
        EntityManager.getInstance().setInactive(this);
    }

    /**
     * @see Despawnable#checkDespawn()
     */
    public void checkDespawn(){
        if(timer.timerOver())
            despawn();
    }
}
