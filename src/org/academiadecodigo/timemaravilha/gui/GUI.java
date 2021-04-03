package org.academiadecodigo.timemaravilha.gui;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

/**
 * The class representing the graphical interface
 */
public class GUI {

    private EntityManager entityManager = EntityManager.getInstance(); //to use the powerups sprites
    private Picture[] lifeCount; //the life count sprite
    private Picture heart; //the heart sprite
    private Picture[] vaccine; //the vaccine count
    private Picture mask; //is the player masked?
    private Picture[][] timerNum; //The timer sprites
    private int prevPlayerLife; //the previous frame's player life (so we don't have to redraw)

    /**
     * Constructor
     */
    public GUI(){
        lifeCount = new Picture[5];
        for(int i = 0; i < lifeCount.length; i++){
            lifeCount[i] = new Picture(SimpleGfxGrid.PADDINGX + 672,9, "sprites/lives/LIFE" +i+".png");
        }
        vaccine = new Picture[2];
        vaccine[0] = new Picture(SimpleGfxGrid.PADDINGX + 636,38,"sprites/powerups/Vaccine.png");
        vaccine[1] = new Picture(SimpleGfxGrid.PADDINGX + 637,72,"sprites/powerups/Vaccine.png");

        heart = new Picture(SimpleGfxGrid.PADDINGX + 636,7, "sprites/lives/heart.png");

        mask = new Picture(SimpleGfxGrid.PADDINGX + 637, 9, "sprites/powerups/Mask.png");
        mask.grow(5, 2);

        timerNum = new Picture[3][10];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j<10; j++)
                timerNum[i][j] = new Picture(SimpleGfxGrid.PADDINGX + 690 + (36*i),64,"sprites/numbers/num"+j+
                                                                                                                ".png");
        }
    }

    /**
     * Redraw the GUI based on the current game state
     */
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

    /**
     * Update time
     * @param time - the current time
     */
    public void updateTime(int time){
        for(int i = 2; i >= 0; i--){
            for(int j = 0; j <= 9; j++){
                timerNum[i][j].delete();
            }
            timerNum[i][time%10].draw();
            time/=10;
        }
    }

    /**
     * Resets the GUI
     */
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
