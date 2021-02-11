package org.academiadecodigo.timemaravilha.entities.despawnable.powerup;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.AbstractCovidinho;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class AbstractPowerUp extends DespawnableEntity {

    public AbstractPowerUp(GridPosition position, int dimensionX, int dimensionY) {
        super(position, dimensionX, dimensionY);
    }

    @Override
    public void collide(Entity other) {
        if(other instanceof Player){
            despawn();
            System.out.println("Immunity collided with Player");

        }else if (other instanceof AbstractCovidinho) {
            despawn();
            System.out.println("Immunity Collided with Covidinho");
        }
    }
}
