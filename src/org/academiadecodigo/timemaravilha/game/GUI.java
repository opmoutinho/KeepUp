package org.academiadecodigo.timemaravilha.Settings;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

public class GUI {

    private SimpleGfxGrid simpleGfxGrid;
    private EntityManager entityManager;

    public GUI (SimpleGfxGrid simpleGfxGrid, EntityManager entityManager){
        this.simpleGfxGrid = simpleGfxGrid;
        this.entityManager = entityManager;
    }

    public void reDraw (){
        if(entityManager.getPlayerVaccines() == 1 ){
            Picture v1 = new Picture(1,1, "Sprites/Powerups/Vaccine.png");
            v1.translate(636+SimpleGfxGrid.PADDINGX,38);
            v1.draw();
        }
        if (entityManager.getPlayerVaccines() == 2){
            Picture v2 = new Picture(1,1,"Sprites/Powerups/Vaccine.png");
            v2.translate(637+SimpleGfxGrid.PADDINGX,72);
            v2.draw();
        }
        if (entityManager.playerHealth() == 4){

        }
    }
}
