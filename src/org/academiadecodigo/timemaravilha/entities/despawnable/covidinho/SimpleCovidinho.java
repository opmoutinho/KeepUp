package org.academiadecodigo.timemaravilha.entities.despawnable.covidinho;

import org.academiadecodigo.timemaravilha.entities.*;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * A type of Covidinho
 */
public class SimpleCovidinho extends AbstractCovidinho {

    /**
     * @see AbstractCovidinho#AbstractCovidinho(GridPosition, int, int, EntityType, long)
     */
    public SimpleCovidinho(GridPosition position, int dimensionX, int dimensionY, long despawnTime) {
        super(position,dimensionX,dimensionY,EntityType.COVIDINHOSIMPLES, despawnTime);
    }

}
