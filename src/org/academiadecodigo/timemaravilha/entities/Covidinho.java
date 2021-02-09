package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class Covidinho extends DespawnableEntity {

    public Covidinho(GridPosition position, int dimensionX, int dimensionY) {
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

    public void collide(Entity other){
        if(other instanceof Player){
            despawn();
            System.out.println("Covidinho Collided with Player");
        } else if (other instanceof Mask){
            despawn();
            System.out.println("Covidinho Collided with Mask");

        }else{
            System.out.println("Covidinho Collided with another Covidinho");
        }
    }
}
