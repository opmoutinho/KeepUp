package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.GUI.Difficulty;
import org.academiadecodigo.timemaravilha.GUI.GameState;
import org.academiadecodigo.timemaravilha.MyKeyboard;
import org.academiadecodigo.timemaravilha.PlayerType;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;
import org.academiadecodigo.timemaravilha.sprite.SpriteManager;

public class Game {

    private GameState gameState = GameState.INITIAL_MENU;
    private Difficulty difficulty = null;
    public boolean[] keysPressed;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void start() {
        EntityManager manager = EntityManager.getInstance();
        SpriteManager.SpriteMap map = SpriteManager.SpriteMap.getInstance(); //start the spritemap
        MyKeyboard m1 = new MyKeyboard(); //keyboard
        Grid grid = new SimpleGfxGrid(800,400);
        manager.setGrid(grid);
        m1.init();
        keysPressed = m1.getKeysPressed(); //keyspressed
        grid.setPic("background/menustart1.png");
        while (gameState == GameState.INITIAL_MENU) {
            if (keysPressed[4]) {
                difficulty = Difficulty.EASY;
            }
            if (keysPressed[5]) {
                difficulty = Difficulty.MEDIUM;
            }
            if (keysPressed[6]) {
                difficulty = Difficulty.HARD;
            }
            if (keysPressed[7]) {
                difficulty = Difficulty.CARCRASH;
            }
            if(difficulty != null) {
                gameState = GameState.PLAYER_PICK;
                grid.setPic("background/menustart2v3.png");
            }
            Thread.yield();
        }
        sleep(50);
        while (gameState == GameState.PLAYER_PICK) {
            if (keysPressed[4]) {
                map.setPlayer(PlayerType.ANDRE);
            }
            if (keysPressed[5]) {
                map.setPlayer(PlayerType.PAULO);
            }
            if (keysPressed[7]) {
                map.setPlayer(PlayerType.RENATA);
            }
            if(map.isPlayerSet()){
                manager.createPlayer(keysPressed);
                gameState = GameState.GAME;
                grid.setPic("background/BKG01.png");
            }
            Thread.yield();
        }
        boolean gameOver = false;
        boolean retry = false;
        while (!gameOver) {
            if(!(gameState == GameState.PAUSED)) {
                manager.moveAll();
                manager.checkDespawn();
                manager.checkSpawn();
            }
            sleep(17);
            if(manager.vaccines())
                gameOver = true;
        }
    }

    private void sleep(int value){
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

