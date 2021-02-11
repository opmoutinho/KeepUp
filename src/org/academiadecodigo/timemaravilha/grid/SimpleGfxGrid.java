package org.academiadecodigo.timemaravilha.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;
import org.academiadecodigo.timemaravilha.grid.position.SimpleGfxPosition;

public class SimpleGfxGrid extends AbstractGrid{

    private Rectangle rectangle;
    private Picture pic;
    public static final int PADDINGX = 10;
    public static final int PADDINGY = 275;
    public static final int SIZE = 1;

    public SimpleGfxGrid(int cols, int rows){
        super(cols, rows);
        rectangle = new Rectangle(PADDINGX, PADDINGY, cols*SIZE, rows*SIZE);
        pic = new Picture(PADDINGX,0, "background/Background1.png");
    }

    public void init (){
       rectangle.draw();
       pic.draw();
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

