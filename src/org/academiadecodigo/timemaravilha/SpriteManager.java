package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

import java.util.HashMap;
import java.util.Map;

public class SpriteManager {

    private String[][] spriteArr;
    private GridPosition position;
    private boolean mirror;
    private int index;

    public SpriteManager(EntityType type, GridPosition position){
        spriteArr = SpriteMap.getInstance().map.get(type);
        this.position = position;
    }

    public void loadNextFrame(int state){
        position.loadNextFrame(spriteArr[0][index]);
        if(mirror)
            position.flip();
        index = (index+1)%spriteArr[0].length;
    }

    public static class SpriteMap{

        private static final String COVIDINHOF = "Sprites/covidinho/follow/";
        private static final String COVIDINHOP = "Sprites/covidinho/patrolling/";
        private static final String COVIDINHOR = "Sprites/covidinho/random/";
        private static final String ANDRE = "Sprites/player/andre/";
        private static final String RENATA = "Sprites/player/renata/";
        private static final String PAULO = "Sprites/player/paulo/";

        public final Map<EntityType, String[][]> map = new HashMap<>();
        private static SpriteMap instance;

        private SpriteMap(){
            String[][] arr = new String[1][3];
            addInArr(arr,3,COVIDINHOF+"covidinhoFollow");
            map.put(EntityType.COVIDINHOTARGET,arr);

            arr = new String[1][7];
            addInArr(arr,7,COVIDINHOP+"covidinhoRandom");
            map.put(EntityType.COVIDINHOPATROLLING, arr);

            arr = new String[1][8];
            addInArr(arr,8,COVIDINHOR+"covidinhoStatic");
            map.put(EntityType.COVIDINHOSIMPLES,arr);
        }

        public static SpriteMap getInstance() {
            if(instance == null)
                instance = new SpriteMap();
            return instance;
        }

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
        }

        private void addInArr(String[][] arr, int max, String name){
            for(int i = 1; i <= max; i++){
                arr[0][i-1] = name+i+".png";
            }
        }

        private void addInArrP(String[][] arr, String name){
            for(int i = 0; i < arr.length; i++){
                for(int j = 1; j <= arr[i].length; j++)
                    arr[i][j-1] = i==0?name+j+".png":name+"M"+j+".png";
            }
        }

    }

}
