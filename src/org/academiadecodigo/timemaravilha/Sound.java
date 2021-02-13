package org.academiadecodigo.timemaravilha;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    static final String MUSIC = "music/game-music.wav";

    private Clip clip;

    public void playSound(String MUSIC) {
        AudioInputStream musicInputStream = null;
        try {
            File musicPath = new File(MUSIC);
            if (musicPath.exists()) {
                musicInputStream = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(musicInputStream);
            }
        } catch(LineUnavailableException e){
            e.printStackTrace();
        } catch(UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }finally{
            closeStream(musicInputStream);
        }
    }

    private void closeStream(AudioInputStream stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playSound() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void stopSound(){
        clip.stop();
    }

    public void closeSound(){
        clip.close();
    }

    public void setLoop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
