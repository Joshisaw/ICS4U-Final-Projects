/*
 * Sound Player
 */
package wangjoshuarecursionbgui;

/**
 *
 * @author joshisaw77
 */
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
    
    /**
     * Plays the specified audio file asynchronously in a new thread.
     * Supports stopping the currently playing sound by passing "stop" as the fileName.
     * 
     * @param fileName The name of the audio file to be played or "stop" to stop the current playback.
     */
    public void play(final String fileName){
        new Thread (new Runnable(){
            @Override
            public void run(){
                try{
                    // Instanciate a Clip to handle audio playback
                    Clip clip = AudioSystem.getClip();
                    
                    // Check if the Clip is active and the fileName is "stop" to stop the playback
                    if (clip.isActive() && fileName.equals("stop")) {
                        clip.stop();
                    } else {
                        // Open the specified audio file and start playing
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
                        clip.open(inputStream);
                        clip.start();
                        
                        // Sleep the thread to allow the sound to play until completion
                        Thread.sleep(clip.getMicrosecondLength() / 1000);
                    }
                } catch (Exception e){
                    // Handle any exceptions that may occur during audio playback
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
}
