package org.academiadecodigo.timemaravilha.Entities;

import org.academiadecodigo.timemaravilha.Despawnable;
import org.academiadecodigo.timemaravilha.GridPosition;
import org.academiadecodigo.timemaravilha.Position;

public class DespawnableEntities extends Entities implements Despawnable {
    private boolean spawned;

    public DespawnableEntities(GridPosition position, int positionX, int positionY) {
        super(position,positionX,positionY);
        setSpawned();
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