package org.academiadecodigo.timemaravilha.game;

import org.academiadecodigo.timemaravilha.sound.Sound;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;
import org.academiadecodigo.timemaravilha.gui.GUI;
import org.academiadecodigo.timemaravilha.sprite.SpriteManager;

/**
 * The Game
 *
 * Responsible for connecting all the logic in this game
 */
public class Game {

    /**
     * The attributes
     */
    private GameState gameState = GameState.INSTRUCTION_MENU; //Our game state
    private Difficulty difficulty = null; //The difficulty
    private boolean[] keysPressed; //Keys pressed (used for menu navigation)
    private EntityManager manager; //Our entity manager
    private SpriteManager.SpriteMap map; //The spritemap. Needs to be populated with the player picked
    private MyKeyboard keyboard; //Our keyboard
    private Grid grid; //The game grid
    private GUI gui; //The game GUI sprites
    private boolean quit; //We need to quit
    private boolean gameOver; //The game is over
    private Sound sound;
    private Timer timer;
    private Timer seconds;
    private int time = 200;//Internal timer

    /**
     * Init this game's instance.
     */
    public void init(){
        attributeInit();
        start();
    }

    /**
     * Run the game actual game
     */
    private void start() {
        while(!quit) {
            startMenuLoop();
            sleep(500);
            startInit();
            game();
            sleep(500);
            retryLoop();
            sleep(500);
        }
        sound.close();
    }

    /**
     * Aux method
     *
     * This instance's attribute initializer.
     */
    private void attributeInit(){
        manager = EntityManager.getInstance();
        grid = new SimpleGfxGrid(800,400);
        map = SpriteManager.SpriteMap.getInstance(); //start the spritemap
        timer = new Timer(200000);
        seconds = new Timer(1000);
        keyboard = new MyKeyboard(); //keyboard
        keysPressed = keyboard.getKeysPressed();
        manager.setGrid(grid);
        sound = new Sound();
        gui = new GUI ();
    }

    /**
     * Aux method
     *
     * Sets the attributes to the various start menus (Difficulty and Player pick)
     */
    private void startInit(){
        keyboard.gameInit();
        grid.setPic("background/difficulty.png");
        initialMenuLoop();
        sleep(500);
        playerPickLoop();
    }

    /**
     * The loop to choose show the Instruction menu
     */
    private void startMenuLoop(){
        sound.setLoop(true);
        grid.setPic("background/instructions.png");
        keyboard.init();
        while(gameState == GameState.INSTRUCTION_MENU){
            if(keysPressed[0])
                gameState = GameState.INITIAL_MENU;
            Thread.yield();
        }
    }

    /**
     * The loop used to choose difficulty
     */
    private void initialMenuLoop(){
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
                grid.setPic("background/chooseplayer.png");
            }
            Thread.yield();
        }
    }

    /**
     * The loop used to choose the player
     */
    private void playerPickLoop(){
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

    /**
     * The game itself
     */
    private void game(){
        sound.setLoop(false);
        sound.playSound();
        keyboard.movementInit();
        timer.reset();
        seconds.reset();
        manager.init(difficulty);
        gui.updateTime(time);
        gameLoop();
        drawGameResult();
    }

    /**
     * The game loop
     */
    private void gameLoop(){
        while (!gameOver) {
            manager.moveAll(); //move everything
            manager.checkDespawn(); //check if there are entities to be despawned
            manager.checkSpawn();//check if there are entities to be spawned
            gui.reDraw();
            if(seconds.timerOver()){
                time--;
                seconds.reset();
                gui.updateTime(time);
            }
            sleep(17); //FPS basically
            if (manager.caughtEnoughVaccines() || manager.playerDead() || timer.timerOver()) {//got the vaccines, died or time's up
                gameOver = true;
                gameState = GameState.GAME_OVER;
            }
        }
    }

    /**
     * The retry loop
     */
    private void retryLoop(){
        keyboard.resetInit();
        while (gameState == GameState.GAME_OVER) {
            if (keysPressed[0]) {
                quit = true;
                break;
            }
            if (keysPressed[3]) {
                gameState = GameState.INSTRUCTION_MENU;
                manager.reset();
                map.reset();
                gameOver = false;
                difficulty = null;
                grid.resetOver();
                sound.close();
                sound = new Sound();
                time = 200;
                gui.clear();
            }
            Thread.yield();
        }
    }

    /**
     * Used to draw the game result (TimesUp, Lost or Won)
     */
    private void drawGameResult(){
        if(timer.timerOver()) {
            grid.setOver("background/timesup");
        } else if (manager.playerDead()) {
            grid.setOver("background/youlost.png");
        } else {
            grid.setOver("background/youwon.png");
            sound.reload(0);
            sound.playSound();
        }
    }

    /**
     * Sleep this thread by value (in miliseconds)
     * @param value - the value
     * @requires value > 0
     */
    private void sleep(int value){
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Internal Timer class.
     * Used across the program, but don't want to pollute the game structure with another Class
     */
    public static class Timer{

        private long startTime;
        private final long timeInterval;

        public Timer(long timeInterval){
            this.startTime = System.currentTimeMillis();
            this.timeInterval = timeInterval;
        }

        public boolean timerOver(){
            return System.currentTimeMillis()-startTime > timeInterval;
        }

        public void reset(){
            startTime = System.currentTimeMillis();
        }

    }
}

