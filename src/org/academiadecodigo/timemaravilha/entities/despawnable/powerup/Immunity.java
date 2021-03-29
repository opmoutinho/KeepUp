package org.academiadecodigo.timemaravilha.entities.despawnable.powerup;

import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;


/**
 * An Immunity
 */
public class Immunity extends AbstractPowerUp {

    /**
     * @see AbstractPowerUp#AbstractPowerUp(GridPosition, int, int, EntityType, long)
     */
    public Immunity (GridPosition position, int dimensionX, int dimensionY, long despawnTime) {
        super(position,dimensionX,dimensionY, EntityType.IMMUNITY, despawnTime);
    }

}

