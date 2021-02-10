package org.academiadecodigo.timemaravilha.entities.despawnable.covidinho;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

import java.util.LinkedList;
import java.util.List;

public class TargetCovidinho extends AbstractCovidinho {

    GridPosition target;

    public TargetCovidinho(GridPosition position, int dimensionX, int dimensionY) {
        super(position, dimensionX, dimensionY);
    }

    public void setTarget(GridPosition target) {
        this.target = target;
    }

    @Override
    public Direction chooseDir() {
        List<Direction> possibleDir = new LinkedList<>();
        if(getPosition().getCol() > target.getCol()){
            possibleDir.add(Direction.LEFT);
        } else if (getPosition().getCol() < target.getCol()){
            possibleDir.add(Direction.RIGHT);
        }
        if(getPosition().getRow() < target.getRow()){
            possibleDir.add(Direction.DOWN);
        } else if (getPosition().getRow() > target.getRow()){
            possibleDir.add(Direction.UP);
        }
        return possibleDir.size() != 0 ? possibleDir.get((int) (Math.random()*possibleDir.size())) : Direction.NEUTRAL;
    }

}
