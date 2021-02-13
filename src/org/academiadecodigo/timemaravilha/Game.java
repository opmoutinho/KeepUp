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
    private boolean quit;
    private boolean gameOver;

    public void init(){
        manager = EntityManager.getInstance();
        grid = new SimpleGfxGrid(800,400);
        map = SpriteManager.SpriteMap.getInstance(); //start the spritemap
        keyboard = new MyKeyboard(); //keyboard
        keyboard.init();
        keysPressed = keyboard.getKeysPressed();
        manager.setGrid(grid);
        grid.setPic("background/instructions-menu.png");
        while(gameState == GameState.INSTRUCTION_MENU){
            if(keysPressed[0])
                gameState = GameState.INITIAL_MENU;
            Thread.yield();
        }
        sleep(200);
    }

    public void start() {
        while(!quit) {
            startInit();
            keyboard.movementInit();
            while (!gameOver) {
                if (!(gameState == GameState.PAUSED)) {
                    manager.moveAll();
                    manager.checkDespawn();
                    manager.checkSpawn();
                }
                sleep(17);
                if (manager.vaccines() || manager.playerDead())
                    gameOver = true;
            }
            gameState = GameState.GAME_OVER;
            Picture pic = null;
            if (manager.playerDead()) {
                pic = new Picture(0, 0, "background/lost.png");
                pic.draw();
            } else {
                System.out.println("You win!");
            }
            sleep(200);
            keyboard.resetInit();
            while (gameState == GameState.GAME_OVER) {
                if (keysPressed[0]) {
                    quit = true;
                    break;
                }
                if (keysPressed[3]) {
                    gameState = GameState.INITIAL_MENU;
                    manager.reset();
                    map.reset();
                    gameOver = false;
                    difficulty = null;
                    if(pic != null)
                        pic.delete();
                }
                Thread.yield();
            }
            sleep(500);
        }
    }

<<<<<<< HEAD
    private void startInit(){
        keyboard.gameInit();
        grid.setPic("background/menustart1.png");
=======
    public void gameInit() {
        SpriteManager.SpriteMap map = SpriteManager.SpriteMap.getInstance();
        MyKeyboard m1 = new MyKeyboard();
        setKeysPressed(m1.getKeysPressed());
        Picture p1 = new Picture(1, 1, "background/menustart1.png");
        p1.draw();
>>>>>>> Master
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
                grid.setPic("background/choose-player-menu.png");
            }
            Thread.yield();
        }
        sleep(200);
        while (gameState == GameState.PLAYER_PICK) {
            if (keysPressed[0]) {
                map.setPlayer(PlayerType.ANDRE);
            } else
            if (keysPressed[1]) {
                map.setPlayer(PlayerType.PAULO);
            } else
            if (keysPressed[3]) {
                map.setPlayer(PlayerType.RENATA);
            } else
            if(map.isPlayerSet()){
                manager.createPlayer(keysPressed);
                grid.setPic("background/BKG01.png");
                gameState = GameState.GAME;
            }
            Thread.yield();
        }
    }

<<<<<<< HEAD
    private void sleep(int value){
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
=======
        if (gameState == GameState.GAME) {

            SimpleGfxGrid g1 = new SimpleGfxGrid(800, 400);
            g1.init();
            m1.playerMovementInit();
            final Player player = new Player(g1.getRandomPos(), 20, 30);
            player.setKeysPressed(m1.getKeysPressed());
            final EntityManager entityManager = EntityManager.getInstance();
            entityManager.setGrid(g1);
            entityManager.add(player);
            entityManager.init();
            while (!player.isDead()) {
                EntityManager.getInstance().moveAll();
                EntityManager.getInstance().checkDespawn();
                EntityManager.getInstance().checkSpawn();
                try {
                    Thread.sleep(17);
                } catch (Exception e) {
                }
            }
            if (player.isDead()) {
                Picture p3 = new Picture(0, 0, "background/lost.png");
                p3.draw();
            }
>>>>>>> Master
        }
    }
}

