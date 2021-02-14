package org.academiadecodigo.timemaravilha.gui;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

public class GUI {

    private EntityManager entityManager = EntityManager.getInstance();
    private Picture[] lifeCount;
    private Picture heart;
    private Picture[] vaccine;
    private Picture mask;
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

}
