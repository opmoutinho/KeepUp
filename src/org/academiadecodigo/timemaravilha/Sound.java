package org.academiadecodigo.timemaravilha;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {

    private static final String MUSIC = "music/gamemusic.wav";

    private Clip clip;
    private URL soundURL;

    public Sound() {
        AudioInputStream musicInputStream = null;
        soundURL = getClass().getClassLoader().getResource(MUSIC);
        try {
            if(soundURL == null){
                File file = new File("C:\\AcademiaDeCodigo\\KeepUp\\resources\\"+MUSIC);
                soundURL = file.toURI().toURL();
            }
            musicInputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(musicInputStream);
        } catch(LineUnavailableException | UnsupportedAudioFileException | IOException e){
            e.printStackTrace();
        } finally {
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

    public void setLoop(boolean loop) {
        if(loop)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        else
            clip.loop(0);
    }

}
