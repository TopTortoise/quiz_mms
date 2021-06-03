import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


class quiz{
    public static void main(String[] args) {
        
        JButton[] h = new JButton[4];
        for (int i = 0; i < h.length; i++) {
            h[i] = new JButton("hello "+i);
        }
        Page p = new Page(h, "Mine", "HELLO" ){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        };
        
      //  p.setButtonVisible(true);
        try {
            BufferedImage b = ImageIO.read(new File("pic/CITIES/athen.jpg"));
            p.panel.add(new JLabel(new ImageIcon(b)));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        p.add(p.panel);
        p.pack();
        p.setSize(1000, 1000);

    }

    
}