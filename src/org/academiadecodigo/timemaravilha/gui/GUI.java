package org.academiadecodigo.timemaravilha.gui;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.game.Game;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

public class GUI {

    private EntityManager entityManager = EntityManager.getInstance();
    private Picture[] lifeCount;
    private Picture heart;
    private Picture[] vaccine;
    private Picture mask;
    private Picture[][] timerNum;
    private int prevPlayerLife;

    public GUI(){
        lifeCount = new Picture[5];
        for(int i = 0; i < lifeCount.length; i++){
            lifeCount[i] = new Picture(SimpleGfxGrid.PADDINGX + 672,9, "sprites/lives/LIFE" +i+".png");
        }
        vaccine = new Picture[2];
        vaccine[0] = new Picture(SimpleGfxGrid.PADDINGX + 636,38,"sprites/powerups/Vaccine.png");
        vaccine[1] = new Picture(SimpleGfxGrid.PADDINGX + 637,72,"sprites/powerups/Vaccine.png");

        heart = new Picture(SimpleGfxGrid.PADDINGX + 636,7, "sprites/lives/heart.png");

        mask = new Picture(SimpleGfxGrid.PADDINGX + 672, 41, "sprites/powerups/Mask.png");

        timerNum = new Picture[3][10];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j<10; j++)
                timerNum[i][j] = new Picture(SimpleGfxGrid.PADDINGX + 690 + (36*i),64,"sprites/numbers/num"+j+
                                                                                                                ".png");
        }
    }

    public void reDraw() {
        if(entityManager.getPlayerVaccines() != 0){
            vaccine[entityManager.getPlayerVaccines()-1].draw();
        }
        lifeCount[entityManager.getHealth()].draw();

        if(entityManager.getHealth() != prevPlayerLife)
            lifeCount[prevPlayerLife].delete();
        prevPlayerLife = entityManager.getHealth();

        if(prevPlayerLife == 0){
            heart.draw();
        }

        if(entityManager.playerWithMask()){
            mask.draw();
        } else {
            mask.delete();
        }
    }

    public void updateTime(int time){
        for(int i = 2; i >= 0; i--){
            for(int j = 0; j <= 9; j++){
                timerNum[i][j].delete();
            }
            timerNum[i][time%10].draw();
            time/=10;
        }
    }

    public void clear(){
        for(int i = 0; i< lifeCount.length; i++){
            lifeCount[i].delete();
        }
        for(int i = 0; i < vaccine.length; i++)
            vaccine[i].delete();
        mask.delete();
        heart.delete();
        prevPlayerLife=0;
    }

}
