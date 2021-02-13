package org.academiadecodigo.timemaravilha.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.entities.EntityManager;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

public class GUI {

    private SimpleGfxGrid simpleGfxGrid;
    private EntityManager entityManager;
    private Picture Lifecount;
    private Picture Hearth;
    private Picture Vacine1;
    private Picture Vacine2;

    public GUI(SimpleGfxGrid simpleGfxGrid, EntityManager entityManager) {
        this.simpleGfxGrid = simpleGfxGrid;
        this.entityManager = entityManager;
    }

    public void reDraw() {
        if (entityManager.getPlayerVaccines() == 1) {
            Vacine1 = null;
            Vacine1 = new Picture(1, 1, "sprites/Powerups/Vaccine.png");
            Vacine1.translate(636 + SimpleGfxGrid.PADDINGX, 38);
            Vacine1.draw();
        }
            switch (entityManager.getHealth()) {

                case 3:
                    Lifecount = null;
                    Lifecount = new Picture(1, 1, "sprites/Powerups/LifeB2.png");
                    Lifecount.translate(672 + SimpleGfxGrid.PADDINGX, 9);
                    Lifecount.draw();
                    break;
                case 2:
                    Lifecount = null;
                    Lifecount = new Picture(1, 1, "sprites/Powerups/LifeB1.png");
                    Lifecount.translate(672 + SimpleGfxGrid.PADDINGX, 9);
                    Lifecount.draw();
                    break;
                case 4:
                    Lifecount = null;
                    Lifecount = new Picture(1, 1, "sprites/Powerups/LifeB3.png");
                    Lifecount.translate(672 + SimpleGfxGrid.PADDINGX, 9);
                    Lifecount.draw();
                    break;
                case 1:
                    Lifecount = null;
                    Lifecount = new Picture(1, 1, "sprites/Powerups/Life1.png");
                    Lifecount.translate(672 + SimpleGfxGrid.PADDINGX, 9);
                    Lifecount.draw();
                    break;
            }
        }

    public void reDrawOver(){
            if (entityManager.getPlayerVaccines() == 2) {
                Vacine2 = null;
                Vacine2 = new Picture(1, 1, "sprites/Powerups/Vaccine.png");
                Vacine2.translate(637 + SimpleGfxGrid.PADDINGX, 72);
                Vacine2.draw();
            }
            if (entityManager.playerDead()){
                Hearth = null;
                Hearth = new Picture(1,1, "sprites/Powerups/Life0.png");
                Hearth.translate(646,7);
                Hearth.draw();
                Lifecount = null;
                Lifecount = new Picture(1,1,"sprites/Powerups/Life0b.png");
                Lifecount.translate(672+SimpleGfxGrid.PADDINGX,9);
                Lifecount.draw();
            }
        }
}
