package org.academiadecodigo.timemaravilha.grid;

import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public interface Grid {

    public int getCols();
    public int getRows();
    public GridPosition getRandomPos();
    public void setPic(String string);


}
