import javax.sound.sampled.Clip;


public abstract class AudioClip {
	//creates the clip
    private final Clip clip;
    
    public AudioClip(Clip clip) {
        this.clip = clip;
        clip.start();
      //starts the clip
        
    }
    //terminates the clip
    public void cleanUp() {
        clip.close();
    }
    
}
