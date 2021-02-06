package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.Despawnable;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class DespawnableEntities extends Entities implements Despawnable {

    private boolean spawned;

    public DespawnableEntities(GridPosition position, int positionX, int positionY) {
        super(position,positionX,positionY);
        setSpawned();
    }

    @Override
    public void move() {

    }

    @Override
    public void collideWith(Entities other) {

    }

    @Override
    public void setSpawned() {
        this.spawned = true;
    }

    @Override
    public void despawn(){
        this.spawned = false;
    }

}
