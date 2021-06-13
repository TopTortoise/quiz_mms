import javax.sound.sampled.Clip;


public abstract class AudioClip {

    private final Clip clip;

    public AudioClip(Clip clip) {
        this.clip = clip;
        clip.start();
    }

    public void cleanUp() {
        clip.close();
    }
    
}
