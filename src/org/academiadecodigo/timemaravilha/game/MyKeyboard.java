package org.academiadecodigo.timemaravilha.game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.timemaravilha.entities.Player;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyKeyboard implements KeyboardHandler {

    private boolean[] keysPressed;
    private Keyboard keyboard;
    private Set<KeyboardEvent> events;
    private Game game;

    public MyKeyboard(Game game){
        keysPressed = new boolean[5];
        keyboard = new Keyboard(this);
        events = new HashSet<>();
        this.game = game;
    }

    public boolean[] getKeysPressed() {
        return keysPressed;
    }

    public void init(){

        for(KeyboardEvent event : events)
            keyboard.removeEventListener(event);
        events.clear();

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

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyEvent.VK_ESCAPE);
        keyboard.addEventListener(event);
        events.add(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_M);
        keyboard.addEventListener(event);
        events.add(event);
    }

    public void gameInit(){
        Iterator<KeyboardEvent> it = events.iterator();
        while(it.hasNext()){
            KeyboardEvent event = it.next();
            if(event.getKey() != KeyEvent.VK_ESCAPE && event.getKey() != KeyboardEvent.KEY_M){
                keyboard.removeEventListener(event);
                it.remove();
            }
        }

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
        Iterator<KeyboardEvent> it = events.iterator();
        while(it.hasNext()){
            KeyboardEvent event = it.next();
            if(event.getKey() != KeyEvent.VK_ESCAPE && event.getKey() != KeyboardEvent.KEY_M){
                keyboard.removeEventListener(event);
                it.remove();
            }
        }

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

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(KeyboardEvent.KEY_P);
        keyboard.addEventListener(event);
        events.add(event);

    }

    public void resetInit(){
        Iterator<KeyboardEvent> it = events.iterator();
        while(it.hasNext()){
            KeyboardEvent event = it.next();
            if(event.getKey() != KeyEvent.VK_ESCAPE && event.getKey() != KeyboardEvent.KEY_M){
                keyboard.removeEventListener(event);
                it.remove();
            }
        }

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
        if(keyboardEvent.getKey() == KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_P){
            game.pauseGame();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_M){
            game.mute();
        }
    }
}
