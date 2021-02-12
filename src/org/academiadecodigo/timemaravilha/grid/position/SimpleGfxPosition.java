package org.academiadecodigo.timemaravilha.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;


public class SimpleGfxPosition extends AbstractPosition{

    private Picture picture;
    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    public SimpleGfxPosition(int col, int row, Grid grid){
        super(col, row, grid);
        simpleGfxGrid = (SimpleGfxGrid) grid;
        picture = new Picture(simpleGfxGrid.colToX(col)-10, simpleGfxGrid.rowToY(row)-5);
        drawRectangle();
    }

    @Override
    public void loadNextFrame(String name) {
        picture.load(name);
        move(Direction.NEUTRAL,0);
        picture.draw();
        rectangle.delete();
    }

    public void flip(){
        picture.grow(-picture.getWidth(), 0);

    }

    private void drawRectangle () {
        rectangle = new Rectangle(simpleGfxGrid.colToX(getCol()),simpleGfxGrid.rowToY(getRow()), getDimX()* SimpleGfxGrid.SIZE,getDimY()* SimpleGfxGrid.SIZE);
        rectangle.fill();
    }

    @Override
    public void setDimension(int dimX, int dimY) {
        super.setDimension(dimX, dimY);
        Color color = rectangle.getColor();
        resetPosition();
        drawRectangle();
        rectangle.setColor(color);
    }

    private void resetPosition(){
        move(Direction.UP,1);
        move(Direction.DOWN,1);
        move(Direction.RIGHT,1);
        move(Direction.LEFT,1);
    }

    public void setColor(Color color){
        rectangle.setColor(color);
    }

    @Override
    public void show() {
        rectangle.fill();
        picture.draw();
    }

    public void hide(){
        rectangle.delete();
        picture.delete();
    }

    @Override
    public void move(Direction dir, int units) {
        super.move(dir, units);
        picture.translate(simpleGfxGrid.colToX(getCol())-(picture.getWidth() < 0 ? -20:10)-picture.getX(), simpleGfxGrid.rowToY(getRow())-5-picture.getY());
        rectangle.translate(simpleGfxGrid.colToX(getCol())-rectangle.getX(), simpleGfxGrid.rowToY(getRow())-rectangle.getY());
    }
}
