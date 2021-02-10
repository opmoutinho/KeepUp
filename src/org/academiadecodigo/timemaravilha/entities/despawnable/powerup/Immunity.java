package org.academiadecodigo.timemaravilha.entities.despawnable.powerup;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.AbstractCovidinho;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Immunity extends DespawnableEntity {

    public Immunity (GridPosition position, int dimensionX, int dimensionY) {
        super(position,dimensionX,dimensionY);
    }

    @Override
    public void move() {
        if (!isDead()) {
            Direction[] directions = Direction.values();
            int random = (int) (Math.random() * directions.length);
            Direction direction = directions[random];
            getPosition().move(direction, 1);
        }
        EntityManager.getInstance().checkCollision(this);
    }

    @Override
    public boolean collidedWith(Entity other) {
        return getCollisionBox().collidedWith(other.getCollisionBox());

    }

    public void collide(Entity other){
        if(other instanceof Player){
            despawn();
            System.out.println("Immunity collided with Player");

        }else if (other instanceof AbstractCovidinho) {
            despawn();
            System.out.println("Immunity Collided with Covidinho");

        }else if (other instanceof Vaccine){
            System.out.println("Immunity Collided with Vaccine");

        }else{
            System.out.println("Immunity Collided with Immunity");
        }
    }
}

