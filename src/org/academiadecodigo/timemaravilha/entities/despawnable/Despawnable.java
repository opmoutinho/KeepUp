package org.academiadecodigo.timemaravilha.entities.despawnable;

/**
 * An interface used by Despawnable entities
 */
public interface Despawnable {


    /**
     * Despawn this entity
     */
    public void despawn();

    /**
     * Check if this entity is ready to be despawned, and despawn if it is
     */
    public void checkDespawn();

}
