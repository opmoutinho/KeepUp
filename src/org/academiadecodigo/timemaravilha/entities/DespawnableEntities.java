package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.Despawnable;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public abstract class DespawnableEntities extends Entities implements Despawnable {

    private boolean spawned;

    public DespawnableEntities(GridPosition position, int dimensionX, int dimensionY) {
        super(position,dimensionX,dimensionY);
        setSpawned();
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
