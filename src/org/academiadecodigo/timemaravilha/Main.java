package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Main main = new Main();
        main.init();
        while(true){
            EntityManager.getInstance().moveAll();

            Thread.sleep(17);
        }
    }

    public void init(){

        SimpleGfxGrid g1 = new SimpleGfxGrid(800,400);

        g1.init();

        Player player = new Player(g1.getRandomPos(),10, 20);

        MyKeyboard m1 = new MyKeyboard();
        m1.init();

        player.setKeysPressed(m1.getKeysPressed());

        EntityManager entityManager = EntityManager.getInstance();
        entityManager.add(player);

        entityManager.createEntity(EntityType.COVIDINHOSIMPLES, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHOSIMPLES, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHOSIMPLES, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHOSIMPLES, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHOSIMPLES, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHOTARGET, g1.getRandomPos());
        entityManager.createEntity(EntityType.MASK, g1.getRandomPos());
        entityManager.createEntity(EntityType.MASK, g1.getRandomPos());
        entityManager.createEntity(EntityType.VACCINE, g1.getRandomPos());
        entityManager.createEntity(EntityType.IMMUNITY, g1.getRandomPos());

    }
}
