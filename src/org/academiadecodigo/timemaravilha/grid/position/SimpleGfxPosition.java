package org.academiadecodigo.timemaravilha.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;


public class SimpleGfxPosition extends AbstractPosition{

    private Picture[] pictures;
    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    public SimpleGfxPosition(int col, int row, Grid grid){
        super(col, row, grid);
        simpleGfxGrid = (SimpleGfxGrid) grid;
        drawRectangle();
    }

    public void setPictures(Picture[] pictures) {
        this.pictures = pictures;
        this.pictures[0].draw();
    }

    private void drawRectangle () {
        rectangle = new Rectangle(simpleGfxGrid.colToX(getCol()),simpleGfxGrid.rowToY(getRow()), SimpleGfxGrid.SIZE,SimpleGfxGrid.SIZE);
        rectangle.fill();
    }

    public void setColor(Color color){
        rectangle.setColor(color);
    }

    @Override
    public void move(Direction dir, int units) {
        super.move(dir, units);
        rectangle.translate(simpleGfxGrid.colToX(getCol())-rectangle.getX(), simpleGfxGrid.rowToY(getRow())-rectangle.getY());
    }
}
