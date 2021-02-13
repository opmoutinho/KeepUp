package org.academiadecodigo.timemaravilha.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.grid.Direction;

public interface GridPosition {


    public int getCol();
    public int getRow();
    public int getDimX();
    public int getDimY();

    public boolean onBorder();

    public void loadNextFrame(Picture name);
    public void flip();
    public void grow(double x, double y);

    public void setDimension(int dimX, int dimY);

    public void move(Direction dir, int units);

    public void show();
    public void hide();

    public boolean equals(GridPosition other);

}
