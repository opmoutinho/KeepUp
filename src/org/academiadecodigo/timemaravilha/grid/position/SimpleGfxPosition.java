package org.academiadecodigo.timemaravilha.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;


public class SimpleGfxPosition extends AbstractPosition{

    private Picture[] pictures;
    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    public SimpleGfxPosition(int col, int row, Grid grid){
        super(col, row, grid);
        simpleGfxGrid = (SimpleGfxGrid) grid;
    }

    public void setPictures(Picture[] pictures) {
        this.pictures = pictures;
        this.pictures[0].draw();
    }

    public void drawRectangle () {
        rectangle = new Rectangle(simpleGfxGrid.colToX(getCol()),simpleGfxGrid.rowToY(getRow()), SimpleGfxGrid.SIZE,SimpleGfxGrid.SIZE);
        rectangle.fill();
    }


}
