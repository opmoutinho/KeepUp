package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;
import org.academiadecodigo.timemaravilha.grid.position.SimpleGfxPosition;

public class Main {

    public static void main(String[] args) {
        SimpleGfxGrid g1 = new SimpleGfxGrid(30,30);
        SimpleGfxPosition p1 = new SimpleGfxPosition(3,3,g1);

        g1.init();
        p1.drawRectangle();

    }
}
