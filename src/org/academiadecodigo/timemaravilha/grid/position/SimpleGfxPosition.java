package org.academiadecodigo.timemaravilha.grid.position;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.Grid;

public class SimpleGfxPosition extends AbstractPosition{

    private Picture[] pictures;

    public SimpleGfxPosition(int col, int row, Grid grid){
        super(col, row, grid);
    }

    public void setPictures(Picture[] pictures) {
        this.pictures = pictures;
        this.pictures[0].draw();
    }


}
