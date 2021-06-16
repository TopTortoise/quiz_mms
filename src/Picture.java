import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Picture extends JButton {
    final int SCALEDWIDTH = 500;
    final int SCALEDHEIGHT = 500;
    final float LEVELDECREASER = 1.5f;
    public String path;
    private BufferedImage img;
    private int level;

    public Picture(String path) throws IOException {
        this.path = path;
        level = 50;

        File file = new File(path);
        img = ImageIO.read(file);
        setIcon(new ImageIcon(img));

        pixelate();

    }

    public void setImg(String path) throws IOException {
        img = ImageIO.read(new File(path));
        this.path = path;
        level = 100;
        pixelate();
    }

    public void pixelate() throws IOException {

        if (level < 9) level = 1;

        BufferedImage tmpImg = ImageIO.read(new File(path));

        int newWidth = tmpImg.getWidth()/level;
        int newHeight = tmpImg.getHeight()/level;

        BufferedImage newImg = new BufferedImage(newWidth, newHeight, tmpImg.getType());

        for (int i = 0; i < newImg.getWidth(); i = i + 1) {
            for (int j = 0; j < newImg.getHeight(); j = j + 1) {
                int colour = tmpImg.getRGB(i*level, j*level);
                newImg.setRGB(i,j,colour);
            }
        }
        //remove all
        removeAll();
        setIcon(new ImageIcon(newImg.getScaledInstance(SCALEDWIDTH, SCALEDHEIGHT, java.awt.Image.SCALE_SMOOTH)));
        level = (int) (level / LEVELDECREASER);
    }

    public static BufferedImage getImage(String imagePath) throws IOException {
        return ImageIO.read(new File(imagePath));


    }


}