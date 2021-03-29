package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.timemaravilha.game.Game;

/**
 * This is our first "big" project, proposed to us on our 4th week of the bootcamp
 * Read the readme.txt file for the context of this project.
 *
 * @author Time Maravilha (André Santos, Paulo Moutinho, Renata Henriques, < Academia de Código_ > 55th Bootcamp, @ Lisboa)
 */
public class Main {

    /**
     * The entry point of our program
     * @param args - the arguments used in the invocation of the main method. Not needed, and will be discarded
     */
    public static void main(String[] args) {

        Game game = new Game();

        //Start the game
        game.init();

        //Exit the program
        System.exit(0);

    }
}
