package org.academiadecodigo.timemaravilha.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;
import org.academiadecodigo.timemaravilha.grid.position.SimpleGfxPosition;

public class SimpleGfxGrid extends AbstractGrid{

    private Rectangle rectangle;
    public static final int PADDING = 10;
    public static final int SIZE = 10;

    public SimpleGfxGrid(int cols, int rows){
        super(cols, rows);
        rectangle = new Rectangle(PADDING, PADDING, cols*SIZE, rows*SIZE);
    }

    public void init (){
       rectangle.draw();
    }

    public int colToX(int col){
        return (col* SIZE) + PADDING;
    }

    public int rowToY(int row){
        return (row * SIZE) + PADDING;
    }

    @Override
    public GridPosition getRandomPos() {
        int randomCol = (int) (Math.random()*getCols());
        int randomRow = (int) (Math.random()*getRows());

        return new SimpleGfxPosition(randomCol,randomRow,this);
    }
}

