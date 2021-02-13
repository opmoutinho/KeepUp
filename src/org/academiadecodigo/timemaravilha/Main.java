package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.timemaravilha.game.Game;

/**
 * The entry point
 */
public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.init();
        System.exit(0);
    }
}
