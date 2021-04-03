package org.academiadecodigo.timemaravilha.sprite;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.game.Game;
import org.academiadecodigo.timemaravilha.game.PlayerType;
import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The SpriteManager
 *
 * Responsible for changing the sprites in our entities.
 */
public class SpriteManager {

    /**
     * The attributes
     */
    private Picture[][] spriteArr; //Our sprites
    private GridPosition position; //The position (has the sprite)
    private boolean flipped; //If it's supposed to be flipped or not
    private int index; //The index of the next picture
    private Game.Timer timer;//When am I allowed to change sprites

    /**
     * The constructor
     * @param type - the entity type
     * @param position - the position
     *
     */
    public SpriteManager(EntityType type, GridPosition position){
        init(type);
        this.position = position;
        timer = new Game.Timer(125);
    }

    /**
     * Loads the next frame on position
     * @param state - what the state of the entity
     */
    public void loadNextFrame(int state){
        if(timer.timerOver()) {
            position.loadNextFrame(spriteArr[state][index]);
            index = (index + 1) % spriteArr[state].length;
            timer.reset();
        }
    }

    /**
     * Is this entity flipped?
     * @return true if it's flipped
     */
    public boolean isFlipped(){
        return flipped;
    }

    /**
     * Set all the sprites to flipped
     * @param flipped - if it's flipped
     */
    public void setFlipped(boolean flipped) {
        for(Picture[] picArr: spriteArr){
            for(Picture pic : picArr){
                pic.grow(-pic.getWidth(),0);
            }
        }
        this.flipped = flipped;
    }

    /**
     * Initiates this sprite manager with all the Sprites used by the EntityType
     * @param type - The entity type
     */
    private void init(EntityType type){
        int i = 0;
        int j = 0;
        String[][] aux = SpriteMap.map.get(type);//To get all the strings mapped to each entity
        spriteArr = new Picture[aux.length][];
        for(String[] s: aux){
            spriteArr[i] = new Picture[aux[i].length];
            for(String name : s){
                if(name != null)
                    spriteArr[i][j] = new Picture(0,0,name);
                if(type == EntityType.PLAYER)
                    spriteArr[i][j].grow(10,10);
                j++;
            }
            i++;
            j = 0;
        }
    }

    /**
     * Auxiliary class used to map EntityTypes to the full path of every Sprite they use
     */
    public static class SpriteMap{

        //The general paths
        private static final String COVIDINHOF = "sprites/covidinho/follow/";
        private static final String COVIDINHOP = "sprites/covidinho/patrolling/";
        private static final String COVIDINHOR = "sprites/covidinho/random/";
        private static final String ANDRE = "sprites/player/andre/";
        private static final String RENATA = "sprites/player/renata/";
        private static final String PAULO = "sprites/player/paulo/";
        private static final String MASK = "sprites/powerups/Mask.png";
        private static final String POWERUP = "sprites/powerups/PowerUP.png";
        private static final String VACCINE = "sprites/powerups/Vaccine.png";

        //The map
        private static final Map<EntityType, String[][]> map = new HashMap<>();
        //Singleton
        private static SpriteMap instance;
        //Has the players sprites been loaded?
        private boolean playerSet;

        /**
         * Constructor
         */
        private SpriteMap(){
            String[][] arr = new String[2][3];
            addInArr(arr,3,COVIDINHOF+"covidinhoFollow");
            Arrays.fill(arr[1], COVIDINHOF + "Mask.png");
            map.put(EntityType.COVIDINHOTARGET,arr);

            arr = new String[2][7];
            addInArr(arr,7,COVIDINHOP+"covidinhoRandom");
            Arrays.fill(arr[1], COVIDINHOP + "Mask.png");
            map.put(EntityType.COVIDINHOPATROLLING, arr);

            arr = new String[2][8];
            addInArr(arr,8,COVIDINHOR+"covidinhoStatic");
            Arrays.fill(arr[1],COVIDINHOR+ "Mask.png");
            map.put(EntityType.COVIDINHOSIMPLES,arr);

            arr = new String[1][1];
            arr[0][0] = MASK;
            map.put(EntityType.MASK,arr);

            arr = new String[1][1];
            arr[0][0] = POWERUP;
            map.put(EntityType.IMMUNITY,arr);

            arr = new String[1][1];
            arr[0][0] = VACCINE;
            map.put(EntityType.VACCINE,arr);
        }

        /**
         * What's the existent instance of SpriteMap?
         * @return the instance
         */
        public static SpriteMap getInstance() {
            if(instance == null)
                instance = new SpriteMap();
            return instance;
        }

        /**
         * Set the players sprites
         * @param type - The player type
         */
        public void setPlayer(PlayerType type){
            String[][] arr = new String[2][8];
            switch(type) {
                case ANDRE:
                    addInArrP(arr,ANDRE+"andre");
                    break;
                case RENATA:
                    addInArrP(arr,RENATA+"renata");
                    break;
                case PAULO:
                    addInArrP(arr,PAULO+"paulo");
                    break;
            }
            map.put(EntityType.PLAYER,arr);
            playerSet = true;
        }

        /**
         * Are the player's sprites set?
         * @return - true if they are, false otherwise
         */
        public boolean isPlayerSet() {
            return playerSet;
        }

        /**
         * Add the actual full path to the sprite to the array arr
         * @param arr - the array
         * @param max - the amount of sprites
         * @param name - the prefix
         */
        private void addInArr(String[][] arr, int max, String name){
            for(int i = 1; i <= max; i++){
                arr[0][i-1] = name+i+".png";
            }
        }

        /**
         * Add the actual players full path
         * @param arr - the array
         * @param name - the path
         */
        private void addInArrP(String[][] arr, String name){
            for(int i = 0; i < arr.length; i++){
                for(int j = 1; j <= arr[i].length; j++)
                    arr[i][j-1] = i==0?name+j+".png":name+"M"+j+".png";
            }
        }

        /**
         * Reset the player entry so it can be set while playing the game again
         */
        public void reset(){
            map.remove(EntityType.PLAYER);
            playerSet = false;
        }

    }

}
