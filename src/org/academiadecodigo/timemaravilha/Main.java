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
        entityManager.setGrid(g1);
        entityManager.init();
        entityManager.add(player);

    }
}
