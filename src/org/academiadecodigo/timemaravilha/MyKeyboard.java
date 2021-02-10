package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.timemaravilha.entities.Player;

public class MyKeyboard implements KeyboardHandler {

    private boolean[] keysPressed;
    private Keyboard keyboard;

    public MyKeyboard(){
        keyboard = new Keyboard(this);
        keysPressed = new boolean[4];
    }

    public boolean[] getKeysPressed() {
        return keysPressed;
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

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(event);
    }

    public void initDifficulty(){

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            keysPressed[0] = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            keysPressed[1] = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            keysPressed[2] = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            keysPressed[3] = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            keysPressed[0] = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            keysPressed[1] = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            keysPressed[2] = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            keysPressed[3] = false;
        }
    }
}
