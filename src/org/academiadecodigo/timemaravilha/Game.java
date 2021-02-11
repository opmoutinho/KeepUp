package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.timemaravilha.GUI.Animations;
import org.academiadecodigo.timemaravilha.GUI.Difficulty;
import org.academiadecodigo.timemaravilha.GUI.GameState;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

public class Game {
    private GameState gameState = GameState.INITIAL_MENU;
    private Difficulty difficulty;
    public boolean[] keysPressed;

    public Difficulty getDifficulty(){return difficulty;}
    public void setDifficulty(Difficulty difficulty1){this.difficulty = difficulty1;}

    public void setGameState(GameState newgameState) {this.gameState = newgameState;}
    public GameState getGameState() {return gameState;}

    public void setKeysPressed(boolean[] keysPressed) {
        this.keysPressed = keysPressed;
    }

    public void gameInit() {
        MyKeyboard m1 = new MyKeyboard();
        setKeysPressed(m1.getKeysPressed());


            Rectangle r1 = new Rectangle(1, 1, 800, 800);
            r1.setColor(Color.BLACK);
            r1.fill();
            while (gameState == GameState.INITIAL_MENU){
                m1.gameInit();
               try { Thread.sleep(10); }
               catch (Exception e) {}
                    if (keysPressed[4]) {
                        setDifficulty(Difficulty.EASY);
                        setGameState(GameState.PLAYER_PICK);
                        try { Thread.sleep(1000); } catch (Exception e) {} }
                     if (keysPressed[5]) {
                         setDifficulty(Difficulty.MEDIUM);
                         setGameState(GameState.PLAYER_PICK);
                         System.out.println("W");
                         try { Thread.sleep(1000); } catch (Exception e) {} }
                    }

                     if (keysPressed[6]) {
                         setDifficulty(Difficulty.HARD);
                         setGameState(GameState.PLAYER_PICK);
                         System.out.println("E");
                         try { Thread.sleep(1000); } catch (Exception e) {} }
                     if (keysPressed[7]) {
                        setDifficulty(Difficulty.CARCRASH);
                        setGameState(GameState.PLAYER_PICK);
                        System.out.println("R" + getGameState().toString());
                         try { Thread.sleep(1000); } catch (Exception e) {}
            }
        if (gameState == GameState.PLAYER_PICK)
        {
            Rectangle r2 = new Rectangle(1,1,800,800);
            r2.setColor(Color.RED);
            r2.fill();
            while (gameState == GameState.PLAYER_PICK) {
                m1.playerPickInit();
                try { Thread.sleep(10); } catch (Exception e) {}
                if (keysPressed[4]){
                    Animations a1 = new Animations();
                    setGameState(GameState.GAME);
                }
            }

            if(gameState == GameState.GAME){
                m1.playerMovementInit();
                SimpleGfxGrid g1 = new SimpleGfxGrid(800,400);
                g1.init();
                Player player = new Player(g1.getRandomPos(),10, 20);
                player.setKeysPressed(m1.getKeysPressed());
                EntityManager entityManager = EntityManager.getInstance();
                entityManager.setGrid(g1);
                entityManager.init();
                entityManager.add(player);
                while(true){
                    EntityManager.getInstance().moveAll();
                    try { Thread.sleep(17); } catch (Exception e) {}
                }
            }
        }

    }
}
