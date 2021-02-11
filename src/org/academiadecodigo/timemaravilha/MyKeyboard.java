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
        keysPressed = new boolean[8];
    }

    public boolean[] getKeysPressed() {
        return keysPressed;
    }

    public void playerMovementInit(){
        keyboard = new Keyboard(this);

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

    public void gameInit(){

        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_W);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_E);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_W);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_E);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(event);

    }

    public void playerPickInit(){
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_W);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_E);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_W);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_E);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(event);

    }

    public void initDifficulty(){

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //PLAYER MOVEMENT
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
        //GAME MENU
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q){
            keysPressed[4] = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_W){
            keysPressed[5] = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_E){
            keysPressed[6] = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_R){
            keysPressed[7] = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //PLAYER MOVEMENT
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
        //GAME MENU
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q){
            keysPressed[4] = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_W){
            keysPressed[5] = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_E){
            keysPressed[6] = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_R){
            keysPressed[7] = false;
        }
    }
}
