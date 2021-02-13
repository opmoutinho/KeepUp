package org.academiadecodigo.timemaravilha;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.timemaravilha.entities.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyKeyboard implements KeyboardHandler {

    private boolean[] keysPressed;
    private Keyboard keyboard;
    private Set<KeyboardEvent> events;

    public MyKeyboard(){
        keysPressed = new boolean[4];
        keyboard = new Keyboard(this);
        events = new HashSet<>();
    }

    public boolean[] getKeysPressed() {
        return keysPressed;
    }

    public void init(){

        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(event);
        events.add(event);
    }

    public void gameInit(){
        for(KeyboardEvent event : events)
            keyboard.removeEventListener(event);
        Arrays.fill(keysPressed, false);
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_W);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_W);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_E);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_E);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(event);
        events.add(event);
    }

    public void movementInit(){
        for(KeyboardEvent event : events)
            keyboard.removeEventListener(event);
        Arrays.fill(keysPressed, false);
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(event);
        events.add(event);
    }

    public void resetInit(){
        for(KeyboardEvent event : events)
            keyboard.removeEventListener(event);
        Arrays.fill(keysPressed, false);
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(event);
        events.add(event);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //PLAYER MOVEMENT
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP || keyboardEvent.getKey() == KeyboardEvent.KEY_Q ||
                keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            keysPressed[0] = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN || keyboardEvent.getKey() == KeyboardEvent.KEY_W){
            keysPressed[1] = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT || keyboardEvent.getKey() == KeyboardEvent.KEY_E){
            keysPressed[2] = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT || keyboardEvent.getKey() == KeyboardEvent.KEY_R){
            keysPressed[3] = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //PLAYER MOVEMENT
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP || keyboardEvent.getKey() == KeyboardEvent.KEY_Q ||
                keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            keysPressed[0] = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN || keyboardEvent.getKey() == KeyboardEvent.KEY_W){
            keysPressed[1] = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT || keyboardEvent.getKey() == KeyboardEvent.KEY_E){
            keysPressed[2] = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT || keyboardEvent.getKey() == KeyboardEvent.KEY_R){
            keysPressed[3] = false;
        }

    }
}
