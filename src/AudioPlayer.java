import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayer {
	
	//for if we still want to add more music in the future
	
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
    	//tries to get Audio File
        try {
        	
        	
            File yourFile = new File("sounds/"+file);
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;
            //creates Audio-stream
            //get audio file/ format
            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            //plays and loops music as long as program is running
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            
        }
        catch (Exception e) {
          
        }
    }
}