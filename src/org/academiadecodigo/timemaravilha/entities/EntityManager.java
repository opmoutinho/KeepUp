package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.collision.CollisionDetector;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private static EntityManager instance;
    private List <Entities> entities;
    private CollisionDetector collisionDetector;

    private EntityManager () {
        entities = new ArrayList<Entities>();
        this.collisionDetector = new CollisionDetector(entities);
    }

    public static EntityManager getInstance(){
        if(instance == null){
            instance = new EntityManager();
        }
        return instance;
    }

    public void createEntity (EntityType entityType, GridPosition gridPosition){
        switch(entityType){
            case COVIDINHO:
                entities.add(new Covidinhos(gridPosition,1,1));
                break;
            case PLAYER:
                entities.add(new Player(gridPosition,1,1));
                break;
        }
    }

    public void moveAll () {
        for (Entities entity : entities) {
            entity.move();
            collisionDetector.checkCollision(entity);
        }
    }
}
