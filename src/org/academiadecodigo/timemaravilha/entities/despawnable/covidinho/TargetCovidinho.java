package org.academiadecodigo.timemaravilha.entities.despawnable.covidinho;

import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

import java.util.LinkedList;
import java.util.List;

/**
 *  A type of covidinho
 */
public class TargetCovidinho extends AbstractCovidinho {

    protected GridPosition target; // the target of this covidinho

    /**
     * @see AbstractCovidinho#AbstractCovidinho(GridPosition, int, int, EntityType, long)
     *
     */
    public TargetCovidinho(GridPosition position, int dimensionX, int dimensionY, long despawnTime) {
        super(position, dimensionX, dimensionY, EntityType.COVIDINHOTARGET, despawnTime);
    }

    /**
     * sets this covidinho target
     * @param target the target
     */
    public void setTarget(GridPosition target) {
        this.target = target;
    }

    /**
     * @see  AbstractCovidinho#chooseDir()
     *
     */
    @Override
    protected Direction chooseDir() {
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
