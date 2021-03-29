package org.academiadecodigo.timemaravilha.grid.position;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.Grid;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;

/**
 * Actual GridPosition implementation. Uses Simple Graphics
 */
public class SimpleGfxPosition extends AbstractPosition{

    private Picture picture; //the grid graphical representation
    private SimpleGfxGrid simpleGfxGrid; //The grid it's inserted on

    /**
     * @see AbstractPosition#AbstractPosition(int, int, Grid)
     */
    public SimpleGfxPosition(int col, int row, Grid grid){
        super(col, row, grid);
        simpleGfxGrid = (SimpleGfxGrid) grid;
        picture = new Picture(simpleGfxGrid.colToX(col)-10, simpleGfxGrid.rowToY(row)-5);
    }

    /**
     * @see GridPosition#loadNextFrame(Picture)
     */
    @Override
    public void loadNextFrame(Picture picture) {
        Picture prev = this.picture;
        this.picture = picture;
        move(Direction.NEUTRAL,0);
        picture.draw();
        if(prev != this.picture)
            prev.delete();
    }

    /**
     * @see GridPosition#setDimension(int, int)
     */
    @Override
    public void setDimension(int dimX, int dimY) {
        super.setDimension(dimX, dimY);
        resetPosition();
    }

    /**
     * Auxiliary method to reset this position to somewhere inside the field
     */
    private void resetPosition(){
        move(Direction.UP,1);
        move(Direction.DOWN,1);
        move(Direction.RIGHT,1);
        move(Direction.LEFT,1);
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide(){
        picture.delete();
    }

    /**
     * @see GridPosition#move(Direction, int)
     */
    @Override
    public void move(Direction dir, int units) {
        super.move(dir, units); //move
        if(picture != null) //picture should follow the new logical position
            picture.translate(simpleGfxGrid.colToX(getCol())-(picture.getWidth() < 0 ? -35:10)-picture.getX(),
                    simpleGfxGrid.rowToY(getRow())-5-picture.getY());
    }
}
