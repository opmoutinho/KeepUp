package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Vaccine extends DespawnableEntity {

    public Vaccine(GridPosition position, int dimensionX, int dimensionY) {
        super(position, dimensionX, dimensionY);
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

    public void collide(Entity other) {
        if (other instanceof Player) {
            despawn();
            System.out.println("Vaccine collided with Player");

        } else if (other instanceof Covidinho) {
            despawn();
            System.out.println("Vaccine Collided with Covidinhos");

        } else if (other instanceof Immunity) {
            despawn();
            System.out.println("Vaccine Collided with Immunity");

        } else {
            System.out.println("Vaccine Collided with another Vaccine");
        }
    }
}
