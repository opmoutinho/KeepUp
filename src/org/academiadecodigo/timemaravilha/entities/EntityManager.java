package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.timemaravilha.collision.CollisionDetector;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EntityManager {
    private static EntityManager instance;
    private List <Entity> entities;
    private List <Entity> inactiveEntities;
    private CollisionDetector collisionDetector;


    private EntityManager () {
        entities = new LinkedList<>();
        inactiveEntities = new LinkedList<>();
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
                gridPosition.setColor(Color.GREEN);
                entities.add(new Covidinhos(gridPosition,1,1));
                break;
            case PLAYER:
                entities.add(new Player(gridPosition,1,1));
                break;
        }
    }

    public void checkPlayerCollision(Player player){
        collisionDetector.checkCollision(player);
    }

    public void moveAll () {
        for (Entity entity : entities) {
            entity.move();
            collisionDetector.checkCollision(entity);
        }
        entities.removeAll(inactiveEntities);
        inactiveEntities.clear();
    }

    public void setInactive(Entity entity) {
        inactiveEntities.add(entity);
    }
}
