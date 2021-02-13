package org.academiadecodigo.timemaravilha.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

import java.lang.invoke.SwitchPoint;

public class GUI {

    private SimpleGfxGrid simpleGfxGrid;
    private EntityManager entityManager;
    private Picture Lifecount;
    private Picture Hearth;

    public GUI(SimpleGfxGrid simpleGfxGrid, EntityManager entityManager) {
        this.simpleGfxGrid = simpleGfxGrid;
        this.entityManager = entityManager;
    }

    public void reDraw() {
        if (entityManager.getPlayerVaccines() == 1) {
            Picture v1 = new Picture(1, 1, "Sprites/Powerups/Vaccine.png");
            v1.translate(636 + SimpleGfxGrid.PADDINGX, 38);
            v1.draw();
        }
            switch (entityManager.getHealth()) {

                case 3:
                    Lifecount = new Picture(1, 1, "Sprites/Powerups/LifeB2.png");
                    Lifecount.translate(672 + SimpleGfxGrid.PADDINGX, 9);
                    Lifecount.draw();
                    break;
                case 2:
                    Lifecount = new Picture(1, 1, "Sprites/Powerups/LifeB1.png");
                    Lifecount.translate(672 + SimpleGfxGrid.PADDINGX, 9);
                    Lifecount.draw();
                    break;
                case 4:
                    Lifecount = new Picture(1, 1, "Sprites/Powerups/LifeB3.png");
                    Lifecount.translate(672 + SimpleGfxGrid.PADDINGX, 9);
                    Lifecount.draw();
                    break;
                case 1:
                    Lifecount = new Picture(1, 1, "Sprites/Powerups/Life1.png");
                    Lifecount.translate(672 + SimpleGfxGrid.PADDINGX, 9);
                    Lifecount.draw();
                    break;
            }
        }

    public void reDrawOver(){
            if (entityManager.getPlayerVaccines() == 2) {
                Picture v2 = new Picture(1, 1, "Sprites/Powerups/Vaccine.png");
                v2.translate(637 + SimpleGfxGrid.PADDINGX, 72);
                v2.draw();
            }
            if (entityManager.playerDead()){
                Lifecount.delete();
                Hearth = new Picture(1,1,"Sprites/Powerups/Life0.png");
                Hearth.translate(646,7);
                Hearth.draw();
            }
        }
}
