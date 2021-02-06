package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.timemaravilha.entities.Player;

public class MyKeyboard implements KeyboardHandler {

    private Player player;
    private Keyboard keyboard;

    public MyKeyboard(Player player){
        keyboard = new Keyboard(this);
        this.player = player;
    }

    public void init(){
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(event);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP)
            player.moveUp();
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN)
            player.moveDown();
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT)
            player.moveLeft();
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT)
            player.moveRight();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP)
            player.moveUp();
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN)
            player.moveDown();
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT)
            player.moveLeft();
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT)
            player.moveRight();
    }
}
