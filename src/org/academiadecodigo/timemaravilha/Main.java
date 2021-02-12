package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

import java.util.List;

public class Main {

    private static Thread threadMove;

    public static void main(String[] args) throws InterruptedException{

        Main main = new Main();
        main.init();

        threadMove = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    EntityManager.getInstance().moveAll();
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Move");
        threadMove.start();
        while(true){
            EntityManager.getInstance().updateFrame();
            Thread.sleep(250);
        }
    }

    public void init(){

        SpriteManager.SpriteMap map = SpriteManager.SpriteMap.getInstance();
        map.setPlayer(PlayerType.RENATA);

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
