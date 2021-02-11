package org.academiadecodigo.timemaravilha.GUI;

public enum Difficulty {
    EASY(5,4,0),
    MEDIUM(5,5,2),
    HARD(7,7,3),
    CARCRASH(10,10,7);


    private int enemiesStatic;
    private int enemiesRandom;
    private int enemiesFollow;

    Difficulty(int enemiesStatic, int enemiesRandom, int enemiesFollow){
        this.enemiesStatic = enemiesStatic;
        this.enemiesRandom = enemiesRandom;
        this.enemiesFollow = enemiesFollow;
    }

}
