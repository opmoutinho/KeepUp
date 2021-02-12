package org.academiadecodigo.timemaravilha.entities.despawnable.covidinho;

import org.academiadecodigo.timemaravilha.entities.EntityType;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

public class PatrollingCovidinho extends TargetCovidinho{

    public PatrollingCovidinho(GridPosition position, int dimensionX, int dimensionY) {
        super(position, dimensionX, dimensionY, EntityType.COVIDINHOPATROLLING);
    }

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
