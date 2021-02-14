package org.academiadecodigo.timemaravilha.game;

import org.academiadecodigo.timemaravilha.sound.Sound;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;
import org.academiadecodigo.timemaravilha.gui.GUI;
import org.academiadecodigo.timemaravilha.sprite.SpriteManager;

import java.util.HashSet;
import java.util.Set;

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
    private Sound sound; //The game sound
    private Timer seconds; //The game timer
    private int time = 200;//Internal timer
    private boolean resetBackground = false; //To switch main game background

    /**
     * Init this game's instance
     */
    public void init(){
        attributeInit();
        start();
    }

    /**
     * Run the game. Actual game
     */
    private void start() {
        while(!quit) {
            startMenuLoop();
            sleep(250);
            startInit();
            game();
            sleep(250);
            retryLoop();
            sleep(250);
        }
        sound.close();
    }

    /**
     * Aux method
     *
     * This instance's attribute initializer
     */
    private void attributeInit(){
        manager = EntityManager.getInstance();
        grid = new SimpleGfxGrid(800,400);
        map = SpriteManager.SpriteMap.getInstance(); //start the spritemap
        seconds = new Timer(1000);
        keyboard = new MyKeyboard(this); //start the keyboard
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
        grid.setPic("background/instructions/instructionsSemSpaceBar.png");
        Timer timer = new Timer(340);
        boolean change = true;
        keyboard.init();
        while(gameState == GameState.INSTRUCTION_MENU){
            if(keysPressed[0])
                gameState = GameState.INITIAL_MENU;
            change = flickerStartMenu(timer,change);
            Thread.yield();
        }
    }

    /**
     * To flicker the start menu info (Press the Space Bar)
     *
     * @param timer the timer to flicker
     * @param change if should flicker or not
     * @requiers timer != null
     */
    private boolean flickerStartMenu(Timer timer, boolean change){
        if(timer.timerOver() && change){
            grid.setPic("background/instructions/instructionsSpaceBar2.png");
            change = false;
            timer.reset();
        } else if(timer.timerOver() && !change) {
            grid.setPic("background/instructions/instructionsSemSpaceBar.png");
            change = true;
            timer.reset();
        }
        return change;
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
        sound.playSound(true);
        keyboard.movementInit();
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
            try {
                if(gameState != GameState.PAUSE) {
                    manager.moveAll(); //move everything
                    manager.checkDespawn(); //check if there are entities to be despawned
                    manager.checkSpawn();//check if there are entities to be spawned
                    reloadBackground(); //check if background need to be reloaded
                    guiUpdate();
                    if (manager.caughtEnoughVaccines() || manager.playerDead() || time ==0) {//got the vaccines, died or time's up
                        gameOver = true;
                        gameState = GameState.GAME_OVER;
                    }
                }
                sleep(17); //Frames per second basically
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * The retry loop. Player can press "R" to restart or "Q" to quit
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
        if(time == 0) {
            grid.setOver("background/timesup.png");
            sound.reload(-1);
        } else if (manager.playerDead()) {
            grid.setOver("background/youlost.png");
            sound.reload(1);
        } else {
            grid.setOver("background/youwon.png");
            sound.reload(0);
        }
        sound.setLoop(true);
    }

    /**
     * Sleep this thread by value (in milliseconds)
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
     * The background should be changed or not
     */
    private void reloadBackground(){
        if(time == 100 && !resetBackground){
            grid.reloadPic("background/BKG01_B.png");
            resetBackground = true;
        }
        if(time == 99){
            resetBackground = false;
        }
        if(time == 50 && !resetBackground){
            grid.reloadPic("background/BKG02.png");
            resetBackground = true;
        }
    }

    /**
     * Update the GUI
     */
    private void guiUpdate(){
        gui.reDraw();
        if(seconds.timerOver()){
            time--;
            seconds.reset();
            gui.updateTime(time);
        }
    }

    /**
     * Pause the game
     */
    public void pauseGame(){
        if(gameState == GameState.GAME) {
            gameState = GameState.PAUSE;
            Timer.pauseTime();
            sound.stopSound();
            grid.setOver("background/paused.png");
        } else {
            gameState = GameState.GAME;
            Timer.unPauseTime();
            sound.playSound(false);
            grid.resetOver();
        }
    }

    /**
     * Mute the game
     */
    public void mute(){
        sound.mute();
    }

    /**
     * Internal Timer class
     * Used across the program, but don't want to pollute the game structure with another Class
     */
    public static class Timer{
        /**
         * The attributes
         */
        private static final Set<Timer> timerInstances = new HashSet<>(); //all the timer instances created
        private long startTime; //the start time of the timer
        private final long timeInterval;//when is the timer over
        private static long pauseTime;//when the pause started

        /**
         * The constructor
         * @param timeInterval when is this timer over in milliseconds
         */
        public Timer(long timeInterval){
            this.startTime = System.currentTimeMillis();
            this.timeInterval = timeInterval;
            timerInstances.add(this);
        }

        /**
         *Is this timer over?
         * @return true if it is, false otherwise
         */
        public boolean timerOver(){
            return System.currentTimeMillis()-startTime > timeInterval;
        }

        /**
         * Reset this timer
         */
        public void reset(){
            startTime = System.currentTimeMillis();
        }

        /**
         * Pause every timer
         */
        public static void pauseTime(){
            pauseTime = System.currentTimeMillis();
        }

        /**
         * Unpause every timer
         */
        public static void unPauseTime(){
            for(Timer timer : timerInstances){
                timer.startTime+=(System.currentTimeMillis()-pauseTime);
            }
            pauseTime = 0;
        }
    }
}

