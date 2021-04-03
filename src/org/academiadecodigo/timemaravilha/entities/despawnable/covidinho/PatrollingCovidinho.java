package org.academiadecodigo.timemaravilha.entities.despawnable.covidinho;

import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * A type of Covidinho
 */
public class PatrollingCovidinho extends TargetCovidinho{

    /**
     * @see AbstractCovidinho#AbstractCovidinho(GridPosition, int, int, EntityType, long)
     */
    public PatrollingCovidinho(GridPosition position, int dimensionX, int dimensionY,long despawnTime) {
        super(position, dimensionX, dimensionY, EntityType.COVIDINHOPATROLLING, despawnTime);
    }

    /**
     * @see AbstractCovidinho#chooseDir()
     */
    @Override
    protected Direction chooseDir(){
        double distance = Math.sqrt(Math.pow(target.getCol()- getPosition().getCol(),2) +
                Math.pow(target.getRow() - getPosition().getRow(), 2));
        Direction dir;
        if(distance < 150){
            dir = super.chooseDir();
        } else {
            dir = randomDir();
        }
        return dir;
    }
}
