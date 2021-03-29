package org.academiadecodigo.timemaravilha.entities.despawnable.powerup;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.AbstractCovidinho;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * An implementation of a powerup
 */
public abstract class AbstractPowerUp extends DespawnableEntity {

    /**
     * @see DespawnableEntity#DespawnableEntity(GridPosition, int, int, EntityType, long)
     */
    public AbstractPowerUp(GridPosition position, int dimensionX, int dimensionY, EntityType type, long despawnTime) {
        super(position, dimensionX, dimensionY, type, despawnTime);
    }

    /**
     * @see Entity#collide(Entity)
     */
    @Override
    public void collide(Entity other) {
        if(other instanceof Player){
            despawn();

        }else if (other instanceof AbstractCovidinho) {
            if(!(this instanceof Vaccine))
                despawn();
        }
    }
}
