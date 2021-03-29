package org.academiadecodigo.timemaravilha.game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A representation of our Keyboard.
 *
 * Uses the simplegraphics lib Keyboard and event handler.
 */
public class MyKeyboard implements KeyboardHandler {

    private boolean[] keysPressed; //The keys being pressed
    private Keyboard keyboard; //The keyboard
    private Set<KeyboardEvent> events; //The events being listened (so we can reset them later)
    private Game game; //The game (so we can mute/pause the game without having to be inside a loop)

    /**
     * Constructor
     * @param game - the game instance
     */
    public MyKeyboard(Game game){
        keysPressed = new boolean[4];
        keyboard = new Keyboard(this);
        events = new HashSet<>();
        this.game = game;
    }

    /**
     * What keys are being pressed?
     * @return An array of the keys being pressed. Only recognizes 4 keys at a time, mapped to different
     * values in each iteration
     */
    public boolean[] getKeysPressed() {
        return keysPressed;
    }

    /**
     * The first init.
     *
     * Space to start the game, M to mute, Esc to escape
     */
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

    /**
     * The game init.
     *
     * Use to browse through the menus
     */
    public void gameInit(){
        Iterator<KeyboardEvent> it = events.iterator();
        while(it.hasNext()){
            KeyboardEvent event = it.next();
            if(event.getKey() != KeyEvent.VK_ESCAPE && event.getKey() != KeyboardEvent.KEY_M){
                keyboard.removeEventListener(event);
                it.remove();
            }
        }

        Arrays.fill(keysPressed, false); //Reset the array to all false
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

    /**
     * The movement handler.
     * WASD
     */
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

    /**
     * Resets the keyboard to the start of the game
     */
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

    /**
     * @see org.academiadecodigo.simplegraphics.keyboard.Keyboard#keyPressed(KeyEvent)
     */
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

    /**
     * @see org.academiadecodigo.simplegraphics.keyboard.Keyboard#keyReleased(KeyEvent)
     */
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
