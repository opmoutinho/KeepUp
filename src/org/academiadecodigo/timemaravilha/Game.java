package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.GUI.Difficulty;
import org.academiadecodigo.timemaravilha.GUI.GameState;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;
import org.academiadecodigo.timemaravilha.sprite.SpriteManager;

public class Game {

    private Thread movementThread;
    private GameState gameState = GameState.INITIAL_MENU;
    private Difficulty difficulty;
    public boolean[] keysPressed;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty1) {
        this.difficulty = difficulty1;
    }

    public void setGameState(GameState newgameState) {
        this.gameState = newgameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setKeysPressed(boolean[] keysPressed) {
        this.keysPressed = keysPressed;
    }

    public void gameInit() {
        SpriteManager.SpriteMap map = SpriteManager.SpriteMap.getInstance();
        MyKeyboard m1 = new MyKeyboard();
        setKeysPressed(m1.getKeysPressed());
        Picture p1 = new Picture(1, 1, "menustart1.png");
        p1.draw();
        while (gameState == GameState.INITIAL_MENU) {
            m1.gameInit();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
            if (keysPressed[4]) {
                setDifficulty(Difficulty.EASY);
                setGameState(GameState.PLAYER_PICK);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            if (keysPressed[5]) {
                setDifficulty(Difficulty.MEDIUM);
                setGameState(GameState.PLAYER_PICK);
                System.out.println("W");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            if (keysPressed[6]) {
                setDifficulty(Difficulty.HARD);
                setGameState(GameState.PLAYER_PICK);
                System.out.println("E");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            if (keysPressed[7]) {
                setDifficulty(Difficulty.CARCRASH);
                setGameState(GameState.PLAYER_PICK);
                System.out.println("R" + getGameState().toString());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
        if (gameState == GameState.PLAYER_PICK) {
            p1.delete();
            Picture p2 = new Picture(1, 1, "menustart2v3.png");
            p2.draw();
            while (gameState == GameState.PLAYER_PICK) {
                m1.playerPickInit();
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
                if (keysPressed[4]) {
                    setGameState(GameState.GAME);
                    SimpleGfxGrid g1 = new SimpleGfxGrid(800, 400);
                    g1.init();
                    map.setPlayer(PlayerType.ANDRE);
                }
                if (keysPressed[5]) {
                    setGameState(GameState.GAME);
                    SimpleGfxGrid g1 = new SimpleGfxGrid(800, 400);
                    g1.init();
                    map.setPlayer(PlayerType.PAULO);
                }
                if (keysPressed[7]) {
                    setGameState(GameState.GAME);
                    SimpleGfxGrid g1 = new SimpleGfxGrid(800, 400);
                    g1.init();
                    map.setPlayer(PlayerType.RENATA);
                }
            }
        }

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
            movementThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!player.isDead()) {

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "Movement");
            while (!player.isDead()) {
                EntityManager.getInstance().moveAll();
                try {
                    Thread.sleep(17);
                } catch (Exception e) {
                }
            }
            if (player.isDead()) {
                Picture p3 = new Picture(0, 0, "lost.png");
                p3.draw();
                movementThread.interrupt();
                EntityManager.getInstance().stopTimer();
            }
        }
    }
}

