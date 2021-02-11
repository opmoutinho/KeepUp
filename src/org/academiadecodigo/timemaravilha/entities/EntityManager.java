package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.timemaravilha.collision.CollisionDetector;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.PatrollingCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.SimpleCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.TargetCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Immunity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Vaccine;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

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

    public void add(Entity entity){
        entities.add(entity);
    }

    public void createEntity (EntityType entityType, GridPosition gridPosition){
        switch(entityType){
            case COVIDINHOSIMPLES:
                gridPosition.setColor(Color.DARK_GRAY);
                entities.add(new SimpleCovidinho(gridPosition,20,20));
                break;
            case COVIDINHOTARGET:
                gridPosition.setColor(Color.MAGENTA);
                entities.add(new TargetCovidinho(gridPosition,20,20));
                ((TargetCovidinho) entities.get(entities.size()-1)).setTarget(entities.get(0).getPosition());
                break;
            case COVIDINHOPATROLLING:
                gridPosition.setColor(Color.WHITE);
                entities.add(new PatrollingCovidinho(gridPosition,20,20));
                ((TargetCovidinho) entities.get(entities.size()-1)).setTarget(entities.get(0).getPosition());
                break;
            case PLAYER:
                entities.add(new Player(gridPosition,10,10));
                break;
            case MASK:
                gridPosition.setColor(Color.BLUE);
                entities.add(new Mask(gridPosition,20,10));
                break;
            case IMMUNITY:
                gridPosition.setColor(Color.PINK);
                entities.add(new Immunity(gridPosition,20,20));
                break;
            case VACCINE:
                gridPosition.setColor(Color.YELLOW);
                entities.add(new Vaccine(gridPosition,20,20));
                break;
        }
    }

    public void checkCollision(Entity entity){
        collisionDetector.checkCollision(entity);
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
