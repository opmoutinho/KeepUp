package org.academiadecodigo.timemaravilha.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid extends AbstractGrid{

    private Rectangle rectangle;
    public static final int PADDING = 10;
    public static final int SIZE = 30;

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
}

