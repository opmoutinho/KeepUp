package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.timemaravilha.entities.Player;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.SimpleGfxGrid;
import org.academiadecodigo.timemaravilha.grid.position.SimpleGfxPosition;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        SimpleGfxGrid g1 = new SimpleGfxGrid(30,30);
        g1.init();
        SimpleGfxPosition p1 = new SimpleGfxPosition(0,0,g1);

        Player player =new Player (p1,1,1);
        MyKeyboard keyboard = new MyKeyboard(player);
        keyboard.init();


    }
}
