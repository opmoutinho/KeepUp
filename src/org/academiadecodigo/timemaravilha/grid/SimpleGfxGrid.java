package org.academiadecodigo.timemaravilha.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;
import org.academiadecodigo.timemaravilha.grid.position.SimpleGfxPosition;

public class SimpleGfxGrid extends AbstractGrid{

    private Picture over;
    private Picture pic;
    public static final int PADDINGX = 10;
    public static final int PADDINGY = 275;
    public static final int SIZE = 1;

    public SimpleGfxGrid(int cols, int rows){
        super(cols, rows);
    }

    public void setPic(String name){
        Picture prev = pic;
        pic = new Picture(PADDINGX,0,name);
        pic.draw();
        if(prev != null)
            prev.delete();
    }

    public void setOver(String name){
        over = new Picture(0,0,name);
        over.draw();
    }

    public void resetOver(){
        over.delete();
        over = null;
    }

    public int colToX(int col){
        return (col* SIZE) + PADDINGX;
    }

    public int rowToY(int row){
        return (row * SIZE) + PADDINGY;
    }

    @Override
    public GridPosition getRandomPos() {
        int randomCol = (int) (Math.random()*getCols());
        int randomRow = (int) (Math.random()*getRows());

        return new SimpleGfxPosition(randomCol,randomRow,this);
    }
}

