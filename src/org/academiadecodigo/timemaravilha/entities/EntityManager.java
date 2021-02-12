package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.timemaravilha.collision.CollisionDetector;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.PatrollingCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.SimpleCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.TargetCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.AbstractPowerUp;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Immunity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Vaccine;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

import java.util.*;

public class EntityManager {
    private static EntityManager instance;
    private List <Entity> entities;
    private List <Entity> inactiveEntities;
    private Grid grid;
    private CollisionDetector collisionDetector;
    private Timer timer;


    private EntityManager () {
        entities = new LinkedList<Entity>();
        inactiveEntities = new LinkedList<>();
        this.collisionDetector = new CollisionDetector(entities);
        timer = new Timer();
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
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

    public void init(){
        setSpawnTimer(10000,EntityType.COVIDINHOSIMPLES);
        setSpawnTimer(5000,EntityType.COVIDINHOSIMPLES);
        setSpawnTimer(15000,EntityType.COVIDINHOPATROLLING);
        setSpawnTimer(20000,EntityType.COVIDINHOPATROLLING);
        setSpawnTimer(25000,EntityType.COVIDINHOTARGET);
        setSpawnTimer(15000,EntityType.MASK);
        setSpawnTimer(10000,EntityType.IMMUNITY);
    }

    public synchronized void createEntity (EntityType entityType){
        final Entity entity;
        GridPosition position = grid.getRandomPos();
        switch(entityType){
            case COVIDINHOTARGET:
                entity = new TargetCovidinho(position,20,20);
                ((TargetCovidinho) entity).setTarget(entities.get(0).getPosition());
                break;
            case COVIDINHOPATROLLING:
                entity = new PatrollingCovidinho(position,20,20);
                ((TargetCovidinho) entity).setTarget(entities.get(0).getPosition());
                break;
            case PLAYER:
                entity = new Player(position,10,10);
                break;
            case MASK:
                entity = new Mask(position,20,10);
                break;
            case IMMUNITY:
                entity = new Immunity(position,20,20);
                break;
            case VACCINE:
                entity = new Vaccine(position,20,20);
                break;
            default:
                entity = new SimpleCovidinho(position,20,20);
                break;
        }
        entities.add(entity);

        if(entity instanceof AbstractPowerUp){
            setDespawnTimer(6000,15000, (DespawnableEntity) entity);
        } else if(entity instanceof DespawnableEntity){
            setDespawnTimer(30000,60000,(DespawnableEntity) entity);
        }
    }

    public void checkCollision(Entity entity){
        collisionDetector.checkCollision(entity);
    }

    public synchronized void moveAll () {
            for (Entity entity : entities) {
                entity.move();
                collisionDetector.checkCollision(entity);
            }
            entities.removeAll(inactiveEntities);
            inactiveEntities.clear();
    }

    public synchronized void updateFrame(){
        for(Entity entity : entities) {
            entity.loadNextFrame();
        }
    }

    public void setInactive(Entity entity) {
        inactiveEntities.add(entity);
    }

    private void setDespawnTimer(long min, long max, final DespawnableEntity entity){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                entity.despawn();
            }
        }, (long) (Math.random()*(max-min+1)+min));
    }

    private void setSpawnTimer(long spawnTimer, final EntityType type){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                createEntity(type);
            }
        },0,spawnTimer);
    }
}
