package org.academiadecodigo.timemaravilha.entities.despawnable.covidinho;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public abstract class AbstractCovidinho extends DespawnableEntity {

    private boolean rooted;

    public AbstractCovidinho(GridPosition position, int dimensionX, int dimensionY) {
        super(position, dimensionX, dimensionY);
    }

    @Override
    public void move() {
        if (!isDead() && !rooted) {
            Direction direction = chooseDir();
            getPosition().move(direction, 1);
        }
        EntityManager.getInstance().checkCollision(this);
    }

    public Direction chooseDir(){
        Direction[] directions = Direction.values();
        int random = (int) (Math.random() * directions.length);
        return directions[random];
    }

    public void collide(Entity other){
        if(other instanceof Player){
            despawn();
            System.out.println("Covidinho Collided with Player");
        } else if (other instanceof Mask){
            rooted = true;
            System.out.println("Covidinho Collided with Mask");
        }else{
            System.out.println("Covidinho Collided with another Covidinho");
        }
    }

}
