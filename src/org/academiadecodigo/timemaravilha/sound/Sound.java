package org.academiadecodigo.timemaravilha.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *  The Sound Class
 */
public class Sound {

    private static final String GAMEMUSIC = "music/gamemusic.wav"; //The game music file path
    private static final String WINMUSIC = "music/winmusic.wav"; // The win music file path
    private static final String GAMEOVERMUSIC = "music/gameovermusic.wav"; //The game over (when you lose) music file path
    private static final String TIMESUPMUSIC = "music/timesupmusic.wav"; //The time's up music file path

    private Clip clip; //The sound clip

    /**
     * Loads the game music
     */
    public Sound() {
        loadMusic(GAMEMUSIC);
    }

    /**
     * Reloads the music
     * @param state - The music file to load base on the state
     */
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

    /**
     * Start the sound
     * @param restart - If the clip is supposed to be restarted or not
     */
    public void playSound(boolean restart){
        if(restart)
            clip.setFramePosition(0);
        clip.start();
    }

    /**
     * Sets a loop to the clip
     * @param loop - If the clip is supposed to be looping
     */
    public void setLoop(boolean loop){
        if(loop)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        else
            clip.loop(0);
    }

    /**
     * Ends the clip
     */
    public void close(){
        clip.close();
    }

    /**
     * Stops the sound
     */
    public void stopSound(){
        clip.stop();
    }

    /**
     * Gets the mute control for the clip
     * @param clip - The clip to get the control from
     * @return the control
     */
    public BooleanControl getMuteControl(Clip clip){
        return (BooleanControl) (clip.getControl(BooleanControl.Type.MUTE));
    }

    /**
     * Mutes the sound
     */
    public void mute(){
        BooleanControl volume = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);

        if(volume.getValue())
            volume.setValue(false);
        else
            volume.setValue(true);

    }

    /**
     * Loads the music file
     * @param path - The path to load the music file from
     */
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
            BooleanControl muted = getMuteControl(clipAux);
            if(muted.getValue())
                mute();
            clipAux.close();
        }
        setVolume();
    }

    /**
     * Sets the volume to the clip
     */
    private void setVolume(){
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-10.0f);
    }

    /**
     * Closes the stream
     * @param stream - The stream to close
     */
    private void closeStream(InputStream stream){
        try{
            if(stream != null)
                stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
