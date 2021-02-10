package org.academiadecodigo.timemaravilha.entities.despawnable;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.despawnable.Despawnable;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public abstract class DespawnableEntity extends Entity implements Despawnable {

    private boolean spawned;

    public DespawnableEntity(GridPosition position, int dimensionX, int dimensionY) {
        super(position,dimensionX,dimensionY);
    }

    public void despawn(){
        getPosition().hide();
        kill();
        EntityManager.getInstance().setInactive(this);
    }
}
