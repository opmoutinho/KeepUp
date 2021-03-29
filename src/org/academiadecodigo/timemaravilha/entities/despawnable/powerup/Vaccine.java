package org.academiadecodigo.timemaravilha.entities.despawnable.powerup;

import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;


/**
 * A Vaccine
 */
public class Vaccine extends AbstractPowerUp {

    /**
     * @see AbstractPowerUp#AbstractPowerUp(GridPosition, int, int, EntityType, long)
     */
    public Vaccine(GridPosition position, int dimensionX, int dimensionY, long despawnTime) {
        super(position, dimensionX, dimensionY, EntityType.VACCINE, despawnTime);
    }

}
