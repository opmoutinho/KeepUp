package org.academiadecodigo.timemaravilha.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Sound {

    private static final String GAMEMUSIC = "music/gamemusic.wav";
    private static final String WINMUSIC = "music/winmusic.wav";
    private static final String GAMEOVERMUSIC = "music/gameovermusic.wav";
    private static final String TIMESUPMUSIC = "music/timesupmusic.wav";

    private Clip clip;

    public Sound() {
        loadMusic(GAMEMUSIC);
    }

    public void reload(int state){
        switch (state){
            case 0:
                loadMusic(WINMUSIC);
                break;
            case 1:
                loadMusic(GAMEOVERMUSIC);
                break;
            default:
                loadMusic(TIMESUPMUSIC);
                break;
        }
    }

    public void playSound(boolean restart){
        if(restart)
            clip.setFramePosition(0);
        clip.start();
    }

    public void setLoop(boolean loop){
        if(loop)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        else
            clip.loop(0);
    }

    public void close(){
        clip.close();
    }

    public void stopSound(){
        clip.stop();
    }

    public BooleanControl isMuted(Clip clip){
        return (BooleanControl) (clip.getControl(BooleanControl.Type.MUTE));
    }

    public void mute(){
        BooleanControl volume = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);

        if(volume.getValue())
            volume.setValue(false);
        else
            volume.setValue(true);

    }

    private void loadMusic(String path){
        Clip clipAux = clip;
        AudioInputStream musicInputStream = null;
        URL soundURL = getClass().getClassLoader().getResource(path); //Read Jar
        try{
            if(soundURL == null){
                File file = new File("C:/AcademiaDeCodigo/KeepUp/resources/"+ path); //IntelliJ
                soundURL = file.toURI().toURL();
            }
            musicInputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(musicInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        } finally {
            closeStream(musicInputStream);
        }
        if(clipAux != null){
            BooleanControl muted = isMuted(clip);
            if(!muted.getValue())
                mute();
            clipAux.close();
        }
    }

    private void closeStream(InputStream stream){
        try{
            if(stream != null)
                stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
