package org.academiadecodigo.timemaravilha.entities.despawnable.powerup;

import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * A Mask
 */
public class Mask extends AbstractPowerUp {

    /**
     * @see AbstractPowerUp#AbstractPowerUp(GridPosition, int, int, EntityType, long)
     */
    public Mask (GridPosition position, int dimensionX, int dimensionY, long despawnTime) {
        super(position,dimensionX,dimensionY, EntityType.MASK, despawnTime);
    }

}
