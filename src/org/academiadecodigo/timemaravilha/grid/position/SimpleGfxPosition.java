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
    private SimpleGfxGrid simpleGfxGrid;

    public SimpleGfxPosition(int col, int row, Grid grid){
        super(col, row, grid);
        simpleGfxGrid = (SimpleGfxGrid) grid;
        picture = new Picture(simpleGfxGrid.colToX(col)-10, simpleGfxGrid.rowToY(row)-5);
    }

    @Override
    public void loadNextFrame(Picture picture) {
        Picture prev = this.picture;
        this.picture = picture;
        move(Direction.NEUTRAL,0);
        picture.draw();
        if(prev != this.picture)
            prev.delete();
    }

    public void flip(){
        picture.grow(-picture.getWidth(), 0);

    }

    public void grow(double x, double y){
        picture.grow(x,y);
    }

    @Override
    public void setDimension(int dimX, int dimY) {
        super.setDimension(dimX, dimY);
        resetPosition();
    }

    private void resetPosition(){
        move(Direction.UP,1);
        move(Direction.DOWN,1);
        move(Direction.RIGHT,1);
        move(Direction.LEFT,1);
    }

    @Override
    public void show() {
        picture.draw();
    }

    public void hide(){
        picture.delete();
    }

    @Override
    public void move(Direction dir, int units) {
        super.move(dir, units);
        if(picture != null)picture.translate(simpleGfxGrid.colToX(getCol())-(picture.getWidth() < 0 ? -35:10)-picture.getX(), simpleGfxGrid.rowToY(getRow())-5-picture.getY());
    }
}
