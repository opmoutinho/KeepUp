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

    private GameState gameState = GameState.INSTRUCTION_MENU;
    private Difficulty difficulty = null;
    private boolean[] keysPressed;
    private EntityManager manager;
    private SpriteManager.SpriteMap map;
    private MyKeyboard keyboard;
    private Grid grid;
    private boolean retry;
    private boolean gameOver;

    public void init(){
        manager = EntityManager.getInstance();
        grid = new SimpleGfxGrid(800,400);
        map = SpriteManager.SpriteMap.getInstance(); //start the spritemap
        keyboard = new MyKeyboard(); //keyboard
        keyboard.init();
        keysPressed = keyboard.getKeysPressed();
        manager.setGrid(grid);
        grid.setPic("background/BKG02.png");
        while(gameState == GameState.INSTRUCTION_MENU){
            if(keysPressed[0])
                gameState = GameState.INITIAL_MENU;
            Thread.yield();
        }
        sleep(50);
    }

    public void start() {
        keyboard.gameInit();
        grid.setPic("background/menustart1.png");
        while (gameState == GameState.INITIAL_MENU) {
            if (keysPressed[0]) {
                difficulty = Difficulty.EASY;
            }
            if (keysPressed[1]) {
                difficulty = Difficulty.MEDIUM;
            }
            if (keysPressed[2]) {
                difficulty = Difficulty.HARD;
            }
            if (keysPressed[3]) {
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
            if (keysPressed[0]) {
                map.setPlayer(PlayerType.ANDRE);
            }
            if (keysPressed[1]) {
                map.setPlayer(PlayerType.PAULO);
            }
            if (keysPressed[3]) {
                map.setPlayer(PlayerType.RENATA);
            }
            if(map.isPlayerSet()){
                manager.createPlayer(keysPressed);
                gameState = GameState.GAME;
                grid.setPic("background/BKG01.png");
            }
            Thread.yield();
        }
        keyboard.movementInit();
        while (!gameOver) {
            if(!(gameState == GameState.PAUSED)) {
                manager.moveAll();
                manager.checkDespawn();
                manager.checkSpawn();
            }
            sleep(17);
            if(manager.vaccines() || manager.playerDead())
                gameOver = true;
        }
        if(manager.playerDead()){
            Picture pic = new Picture(0,0,"background/lost.png");
            pic.draw();
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

