package org.academiadecodigo.timemaravilha.entities.despawnable.powerup;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.AbstractCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.SimpleCovidinho;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Mask extends DespawnableEntity {
    public Mask (GridPosition position, int dimensionX, int dimensionY) {
        super(position,dimensionX,dimensionY);
    }

    @Override
    public boolean collidedWith(Entity other) {
        return getCollisionBox().collidedWith(other.getCollisionBox());
    }

    public void collide(Entity other){
        if(other instanceof Player){
            despawn();
            System.out.println("Mask collided with Player");

        } else if (other instanceof AbstractCovidinho){
            despawn();
            System.out.println("Mask Collided with Covidinhos");

        } else if (other instanceof Immunity) {
            System.out.println("Mask Collided with Immunity");

        }else if (other instanceof Vaccine){
            System.out.println("Immunity Collided with Vaccine");

        }else{
            System.out.println("Mask Collided with another Mask");
        }
    }
}
