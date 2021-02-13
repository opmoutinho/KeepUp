package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.collision.CollisionDetector;
import org.academiadecodigo.timemaravilha.entities.despawnable.DespawnableEntity;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.PatrollingCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.SimpleCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.covidinho.TargetCovidinho;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Immunity;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Mask;
import org.academiadecodigo.timemaravilha.entities.despawnable.powerup.Vaccine;
import org.academiadecodigo.timemaravilha.game.Difficulty;
import org.academiadecodigo.timemaravilha.game.Game;
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

    private long maskDespawn;
    private long immunityDespawn;
    private long vaccineDespawn;
    private long covidinhoDespawn;

    private long maskInterval;
    private Game.Timer maskTimer;

    private long immunityInterval;
    private Game.Timer immunityTimer;

    private long vaccineInterval;
    private Game.Timer vaccineTimer;

    private long scovidinhoInterval;
    private Game.Timer scovidinhoTimer;

    private long pcovidinhoInterval;
    private Game.Timer pcovidinhoTimer;

    private long tcovidinhoInterval;
    private Game.Timer tcovidinhoTimer;


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

    public void init(Difficulty difficulty){
        loadSettings(difficulty);
        maskTimer = new Game.Timer(maskInterval);
        vaccineTimer = new Game.Timer(vaccineInterval);
        immunityTimer = new Game.Timer(immunityInterval);
        scovidinhoTimer = new Game.Timer(scovidinhoInterval);
        pcovidinhoTimer = new Game.Timer(pcovidinhoInterval);
        tcovidinhoTimer = new Game.Timer(tcovidinhoInterval);
    }

    private void loadSettings(Difficulty difficulty){
        long[] mask = difficulty.maskSetting();
        long[] immunity = difficulty.immunitySetting();
        long[] vaccine = difficulty.vaccineSetting();
        long[] covidinho = difficulty.covidinhoSetting();

        maskDespawn = mask[0];
        maskInterval = mask[1];

        immunityDespawn = immunity[0];
        immunityInterval = immunity[1];

        vaccineDespawn = vaccine[0];
        vaccineInterval = vaccine[1];

        covidinhoDespawn = covidinho[0];
        scovidinhoInterval = covidinho[1];
        pcovidinhoInterval = covidinho[2];
        tcovidinhoInterval = covidinho[3];
    }

    private void createEntity (EntityType entityType){
        if(player == null)
            return;
        Entity entity;
        GridPosition position = grid.getRandomPos();
        switch(entityType){
            case COVIDINHOTARGET:
                entity = new TargetCovidinho(position,20,20, covidinhoDespawn);
                ((TargetCovidinho) entity).setTarget(player.getPosition());
                tcovidinhoTimer.reset();
                break;
            case COVIDINHOPATROLLING:
                entity = new PatrollingCovidinho(position,20,20, covidinhoDespawn);
                ((TargetCovidinho) entity).setTarget(player.getPosition());
                pcovidinhoTimer.reset();
                break;
            case MASK:
                entity = new Mask(position,20,10, maskDespawn);
                maskTimer.reset();
                break;
            case IMMUNITY:
                entity = new Immunity(position,20,20, immunityDespawn);
                immunityTimer.reset();
                break;
            case VACCINE:
                entity = new Vaccine(position,20,20, vaccineDespawn);
                vaccineTimer.reset();
                break;
            default:
                entity = new SimpleCovidinho(position,20,20, covidinhoDespawn);
                scovidinhoTimer.reset();
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
        if(scovidinhoTimer.timerOver()){
            createEntity(EntityType.COVIDINHOSIMPLES);
        }
        if(pcovidinhoTimer.timerOver()){
            createEntity(EntityType.COVIDINHOPATROLLING);
        }
        if(tcovidinhoTimer.timerOver()){
            createEntity(EntityType.COVIDINHOTARGET);
        }
        if(maskTimer.timerOver()){
            createEntity(EntityType.MASK);
        }
        if(immunityTimer.timerOver()){
            createEntity(EntityType.IMMUNITY);
        }
        if(vaccineTimer.timerOver()){
            createEntity(EntityType.VACCINE);
        }
    }

    public void setInactive(Entity entity) {

        inactiveEntities.add(entity);
    }

    public boolean vaccines(){
        return player.getVaccineCounter() == 2;
    }

    public int getPlayerVaccines(){
        return player.getVaccineCounter();
    }

    public boolean playerDead(){
        return player.isDead();
    }

    public int getHealth(){
        return player.getHealth();
    }

    public void reset(){
        for(Entity entity: entities)
            entity.reset();
        entities.clear();
        inactiveEntities.clear();
        player = null;
    }

}
