package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.timemaravilha.entities.Covidinho;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;
import org.academiadecodigo.timemaravilha.grid.position.SimpleGfxPosition;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Main main = new Main();
        main.init();
        while(true){
            EntityManager.getInstance().moveAll();
            Thread.sleep(100);
        }

    }

    public void init(){
        SimpleGfxGrid g1 = new SimpleGfxGrid(60,60);
        g1.init();

        Player player = new Player(g1.getRandomPos(),3, 3);

        MyKeyboard m1 = new MyKeyboard();
        m1.init();

        player.setKeysPressed(m1.getKeysPressed());

        EntityManager entityManager = EntityManager.getInstance();
        entityManager.add(player);

        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());
        entityManager.createEntity(EntityType.MASK, g1.getRandomPos());
    }
}
