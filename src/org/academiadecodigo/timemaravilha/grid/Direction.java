package org.academiadecodigo.timemaravilha.grid;

/**
 * A Enum representing the direction
 */
public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT,
    NEUTRAL;

    /**
     * What's the opposite direction to this direction?
     * @return the opposite direction
     */
    public Direction opposite(){
        Direction result = NEUTRAL;
        switch (this){
            case UP:
                result = DOWN;
                break;
            case DOWN:
                result = UP;
                break;
            case RIGHT:
                result = LEFT;
                break;
            case LEFT:
                result = RIGHT;
                break;
        }
        return result;
    }

    /**
     * What's the directions if I want to change plane?
     * @return the new directions
     */
    public Direction[] changePlane(){
        Direction[] result = new Direction[2];
        if(this == UP || this == DOWN) {
            result[0] = RIGHT;
            result[1] = LEFT;
        } else {
            result[0] = UP;
            result[1] = DOWN;
        }
        return result;
    }

}
