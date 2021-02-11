package org.academiadecodigo.timemaravilha.grid;

public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT,
    NEUTRAL;


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
