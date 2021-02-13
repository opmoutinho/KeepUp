package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.collision.CollisionDetector;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.PatrollingCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.SimpleCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.TargetCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Immunity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Vaccine;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

import java.util.*;

public class EntityManager {
    private static EntityManager instance;
    private Player player;
    private Set <Entity> entities;
    private Set <Entity> inactiveEntities;
    private Grid grid;
    private CollisionDetector collisionDetector;

    private final long MASK_DESPAWN = 15000;
    private final long IMMUNITY_DESPAWN = 15000;
    private final long VACCINE_DESPAWN = 10000;
    private final long COVIDINHO_DESPAWN = 60000;

    private long maskSpawnTime = System.currentTimeMillis();
    private final long MASK_INTERVAL = 5000;
    private long immunitySpawnTime = System.currentTimeMillis();
    private final long IMMUNITY_INTERVAL = 7500;
    private long vaccineSpawnTime = System.currentTimeMillis();
    private final long VACCINE_INTERVAL = 30000;
    private long scovidinhoSpawnTime = System.currentTimeMillis();
    private final long SCOVIDINHO_INTERVAL = 10000;
    private long pcovidinhoSpawnTime = System.currentTimeMillis();
    private final long PCOVIDINHO_INTERVAL = 12000;
    private long tcovidinhoSpawnTime = System.currentTimeMillis();
    private final long TCOVIDINHO_INTERVAL = 15000;


    private EntityManager () {
        entities = new HashSet<>();
        inactiveEntities = new HashSet<>();
        this.collisionDetector = new CollisionDetector(entities);
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

    public void init(){
        createEntity(EntityType.COVIDINHOSIMPLES);
        createEntity(EntityType.COVIDINHOSIMPLES);
        createEntity(EntityType.COVIDINHOSIMPLES);
        createEntity(EntityType.COVIDINHOTARGET);
        createEntity(EntityType.MASK);
    }

    private void createEntity (EntityType entityType){
        if(player == null)
            return;
        Entity entity;
        GridPosition position = grid.getRandomPos();
        switch(entityType){
            case COVIDINHOTARGET:
                entity = new TargetCovidinho(position,20,20, COVIDINHO_DESPAWN);
                ((TargetCovidinho) entity).setTarget(player.getPosition());
                tcovidinhoSpawnTime = System.currentTimeMillis();
                break;
            case COVIDINHOPATROLLING:
                entity = new PatrollingCovidinho(position,20,20, COVIDINHO_DESPAWN);
                ((TargetCovidinho) entity).setTarget(player.getPosition());
                pcovidinhoSpawnTime = System.currentTimeMillis();
                break;
            case MASK:
                entity = new Mask(position,20,10, MASK_DESPAWN);
                maskSpawnTime = System.currentTimeMillis();
                break;
            case IMMUNITY:
                entity = new Immunity(position,20,20, IMMUNITY_DESPAWN);
                immunitySpawnTime = System.currentTimeMillis();
                break;
            case VACCINE:
                entity = new Vaccine(position,20,20, VACCINE_DESPAWN);
                vaccineSpawnTime = System.currentTimeMillis();
                break;
            default:
                entity = new SimpleCovidinho(position,20,20, COVIDINHO_DESPAWN);
                scovidinhoSpawnTime = System.currentTimeMillis();
                break;
        }
        entities.add(entity);

    }

    public void createPlayer(boolean[] keyspressed){
        if(player != null)
            return;
        player = new Player(grid.getRandomPos(),20,30);
        player.setKeysPressed(keyspressed);
        entities.add(player);
    }

    public void checkCollision(Entity entity){
        collisionDetector.checkCollision(entity);
    }

    public void moveAll () {
            for (Entity entity : entities) {
                entity.move();
                entity.loadNextFrame();
                collisionDetector.checkCollision(entity);
            }
            for (Entity entity : inactiveEntities){
                entity.reset();
            }
            entities.removeAll(inactiveEntities);
            inactiveEntities.clear();
    }

    public void checkDespawn(){
        for(Entity entity: entities){
            if(entity instanceof DespawnableEntity)
                ((DespawnableEntity) entity).checkDespawn();
        }
        entities.removeAll(inactiveEntities);
        inactiveEntities.clear();
    }

    public void checkSpawn(){
        if(System.currentTimeMillis() - scovidinhoSpawnTime > SCOVIDINHO_INTERVAL){
            createEntity(EntityType.COVIDINHOSIMPLES);
        }
        if(System.currentTimeMillis() - pcovidinhoSpawnTime > PCOVIDINHO_INTERVAL){
            createEntity(EntityType.COVIDINHOPATROLLING);
        }
        if(System.currentTimeMillis() - tcovidinhoSpawnTime > TCOVIDINHO_INTERVAL){
            createEntity(EntityType.COVIDINHOTARGET);
        }
        if(System.currentTimeMillis() - maskSpawnTime > MASK_INTERVAL){
            createEntity(EntityType.MASK);
        }
        if(System.currentTimeMillis() - immunitySpawnTime > IMMUNITY_INTERVAL){
            createEntity(EntityType.IMMUNITY);
        }
        if(System.currentTimeMillis() - vaccineSpawnTime > VACCINE_INTERVAL){
            createEntity(EntityType.VACCINE);
        }
    }

    public void setInactive(Entity entity) {

        inactiveEntities.add(entity);
    }

    public boolean vaccines(){
        return player.getVaccineCounter() == 2;
    }

    public boolean playerDead(){
        return player.isDead();
    }

    public void reset(){
        for(Entity entity: entities)
            entity.reset();
        entities.clear();
        inactiveEntities.clear();
        player = null;
    }

}
