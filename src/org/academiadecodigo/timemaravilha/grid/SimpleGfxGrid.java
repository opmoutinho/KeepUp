package org.academiadecodigo.timemaravilha.grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;
import org.academiadecodigo.timemaravilha.grid.position.SimpleGfxPosition;

/**
 * The actual implementation of Grid (using Simple Graphics)
 */
public class SimpleGfxGrid extends AbstractGrid{

    private Picture over; //The over pic (overlay)
    private Picture pic; //The background pic
    public static final int PADDINGX = 10; //Padding for the grid/field in the X direction
    public static final int PADDINGY = 275; //Padding for the field in the Y direction
    public static final int SIZE = 1; //The convertion of col/row to pixels (actual size of a cell)

    /**
     * @see AbstractGrid#AbstractGrid(int, int)
     */
    public SimpleGfxGrid(int cols, int rows){
        super(cols, rows);
    }

    /**
     * @see Grid#setPic(String)
     */
    public void setPic(String name){
        Picture prev = pic;
        pic = new Picture(PADDINGX,0,name);
        pic.draw();
        if(prev != null)
            prev.delete();
    }

    /**
     * @see Grid#setOver(String)
     */
    public void setOver(String name){
        over = new Picture(PADDINGX,0,name);
        over.draw();
    }

    /**
     * @see Grid#reloadPic(String)
     */
    public void reloadPic(String name){
        pic.load(name);
    }

    /**
     * @see Grid#resetOver()
     */
    public void resetOver(){
        over.delete();
        over = null;
    }

    /**
     * Aux method. Translates col to a position in the field
     * @param col - the col #
     * @return - The actual position in the grid
     */
    public int colToX(int col){
        return (col* SIZE) + PADDINGX;
    }

    /**
     * Aux method. Translates row to a position in the field
     * @param row - the row #
     * @return - The actual position in the grid
     */
    public int rowToY(int row){
        return (row * SIZE) + PADDINGY;
    }

    /**
     * @see Grid#getRandomPos()
     */
    @Override
    public GridPosition getRandomPos() {
        int randomCol = (int) (Math.random()*getCols());
        int randomRow = (int) (Math.random()*getRows());

        return new SimpleGfxPosition(randomCol,randomRow,this);
    }
}

