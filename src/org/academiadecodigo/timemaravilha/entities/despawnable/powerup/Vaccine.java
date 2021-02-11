package org.academiadecodigo.timemaravilha.entities.despawnable.powerup;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.AbstractCovidinho;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Vaccine extends DespawnableEntity {

    public Vaccine(GridPosition position, int dimensionX, int dimensionY) {
        super(position, dimensionX, dimensionY);
    }

    @Override
    public boolean collidedWith(Entity other) {
        return getCollisionBox().collidedWith(other.getCollisionBox());
    }

    public void collide(Entity other) {
        if (other instanceof Player) {
            despawn();
            System.out.println("Vaccine collided with Player");

        } else if (other instanceof AbstractCovidinho) {
            despawn();
            System.out.println("Vaccine Collided with Covidinho");

        } else if (other instanceof Mask) {
            System.out.println("Vaccine Collided with Immunity");

        } else if (other instanceof Immunity) {
            System.out.println("Vaccine Collided with Immunity");

        } else {
            System.out.println("Vaccine Collided with Vaccine");
        }
    }
}
