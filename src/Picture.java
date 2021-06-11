import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Picture extends JButton {
    final int SCALEDWIDTH = 1000;
    final int SCAlEDHEIGHT = 1000;
    final int LEVELDECREASER = 7;
    //TODO might be done needs small adjustments
    public String path;
    private Timer t;
    private BufferedImage img;
    private int level;

    public Picture(String path) throws IOException {
        this.path = path;
        level = 50;

        File file= new File(path);
        img = ImageIO.read(file);
        setIcon(new ImageIcon(img));

        pixi();

        t = new Timer(1000, new ActionListener() {      //10 sek(?)
            @Override public void actionPerformed(ActionEvent e) {
                pixelate();
            }
        });
       // t.start();

    }

    public void setImg(String path) throws IOException{
        img = ImageIO.read(new File(path));
        this.path = path;
        level = 50;
        pixi();
    }

    public void pixi() throws IOException{
       
        if(level<1)level=1;

        BufferedImage imge = ImageIO.read(new File(path));

        BufferedImage tmpimg = imge;
        int height = tmpimg.getHeight();
        int width = tmpimg.getWidth();

        for(int i = 0; i < width; i = i + level) {
            for (int j = 0; j < height; j = j + level) {
                int colour = tmpimg.getRGB(i,j);
                for(int x = 0; x < level; x++){
                    if(i+x < tmpimg.getWidth()){
                        for(int y = 0; y < level; y++){
                            if(j+y < tmpimg.getHeight()){

                                tmpimg.setRGB( i+x,j+y, colour);
                            }
                        }
                    }
                }
            }
        }
        //remove all
        removeAll();
        setIcon(new ImageIcon(tmpimg.getScaledInstance(SCALEDWIDTH, SCAlEDHEIGHT, java.awt.Image.SCALE_SMOOTH))); 
        level-=LEVELDECREASER;
    }

    public static BufferedImage getImage(String imagePath) throws IOException{
        return ImageIO.read(new File(imagePath));

       
    }
   
    public void pixelate(){
        boolean xisterhöht = false;
        BufferedImage tmpimg = img;
        for (int y = 0; y < tmpimg.getHeight(); y++) {         //easiest level biggest number
            for (int x = 0; x < tmpimg.getWidth(); x++) {
                if (y/2 == 0 && !xisterhöht) {
                    x = x + level;
                    xisterhöht = true;
                }
                tmpimg.setRGB(x, y, Color.LIGHT_GRAY.getRGB()); //Setting new Color object to the image
                x = x + level;
            }
            xisterhöht = false;
        }
        
       setIcon(new ImageIcon(tmpimg.getScaledInstance(1000, 300, java.awt.Image.SCALE_SMOOTH)));
        level++;

        if (level > 10) {
            t.stop();
        }
    }

    //Button wo Bild oben ist nach richtem Raten einfach unsichtbar schalten
}