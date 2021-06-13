import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayer {

    private List<AudioClip> audioClips;

    public AudioPlayer() {
        audioClips = new ArrayList<>();
    }

   
    

    public void playMusic(String fileName) {
        //final Clip clip = getClip(fileName);
        test(fileName);
        //audioClips.add(new MusicClip(clip));
    }
    private void test(String file){
        try {
            File yourFile = new File("sounds/"+file);
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;
        
            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
        catch (Exception e) {
          
        }
    }
}