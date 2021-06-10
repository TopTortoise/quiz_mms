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
        for (int i = 0; i < h.length-1; i++) {
            h[i] = new JButton("hello "+i);
        }
        try {
            h[3] = new Picture("pic/VEHICLES/tram.jpg");
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        Page p = new Page(h, "Mine", "HELLO" ){

            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource().equals(h[3]))
                    try {
                        ((Picture) h[3]).pixi();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                // TODO Auto-generated method stub
                
            }
            
        };
        
      //  p.setButtonVisible(true);
   
        //this will always need to be at the end
        p.add(p.panel);
        p.pack();
        //
        p.setSize(2000, 2000);

    }

    
}