package org.academiadecodigo.timemaravilha.entities.despawnable.covidinho;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.AbstractPowerUp;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Immunity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Vaccine;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public abstract class AbstractCovidinho extends DespawnableEntity {

    private boolean rooted;

    public AbstractCovidinho(GridPosition position, int dimensionX, int dimensionY, EntityType type) {
        super(position, dimensionX, dimensionY, type);
    }

    @Override
    public void move() {
        if (!isDead() && !rooted) {
            Direction direction = chooseDir();
            getPosition().move(direction, 1);
            setDirection(direction);
        }
    }

    protected Direction chooseDir(){
        return randomDir();
    }

    protected Direction randomDir(){
        Direction dir;
        if(getDirection() == Direction.NEUTRAL) {
            Direction[] directions = Direction.values();
            int random = (int) (Math.random() * directions.length);
            dir = directions[random];
        } else if(Math.random() > 0.1){
            if(onBorder())
                dir = getDirection().opposite();
            else
                dir = getDirection();
        } else {
            Direction[] directions = getDirection().changePlane();
            int random = (int) (Math.random() * directions.length);
            dir = directions[random];
        }
        return dir;
    }

    public void collide(Entity other){
        if(other instanceof Player){
            despawn();
            System.out.println("Covidinho Collided with Player");
        } else if (other instanceof Mask){
            rooted = true;
        } else {
            System.out.println("Covidinho Collided with another Covidinho");
        }
    }

}
