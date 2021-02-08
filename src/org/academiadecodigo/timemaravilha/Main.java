package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.timemaravilha.entities.Covidinhos;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;
import org.academiadecodigo.timemaravilha.grid.position.SimpleGfxPosition;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        SimpleGfxGrid g1 = new SimpleGfxGrid(30,30);
        g1.init();

        Player player = new Player(g1.getRandomPos(),1,1);

        MyKeyboard m1 = new MyKeyboard(player);
        m1.init();

        EntityManager entityManager = EntityManager.getInstance();

        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());
        entityManager.createEntity(EntityType.COVIDINHO, g1.getRandomPos());


        while (true) {
            entityManager.moveAll();
            Thread.sleep(200);
        }

    }
}
