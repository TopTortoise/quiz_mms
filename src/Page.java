import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.*;


abstract class Page extends JFrame implements ActionListener{

    JButton[] buttons;
    String title;
    String text;
    JPanel panel;
    protected Page(JButton[] buttons, String title, String text){
        //setup vairiables
        this.buttons = buttons;
        this.title = title;
        this.text = text;
        this.panel = new JPanel();
        //setup the Buttons
        initializeButtons();
        //setup panel layout
        panel.setLayout(new GridLayout(5,0,50,0));
        //setup the JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
     * adds buttons to the panel
     */
    void initializeButtons(){
        for (JButton Button : buttons) {
            Button.addActionListener(this);
            panel.add(Button);
        }
    }
    /**
     * sets all the buttons to (true) visible or (false) hidden
     * @param visible
     */
    void setButtonVisible(boolean visible){
        for (JButton Button : buttons) {
            Button.setVisible(true);
        }
    }
    /**
     * set buttons to visible if true 
     * @param offset
     * @param x
     * @param visible
     */
    void setButtonVisible(int offset ,int x, boolean visible) throws IndexOutOfBoundsException{
        if(x>buttons.length || offset>x || offset<0){
            throw new IndexOutOfBoundsException();
        }
        for (int i = offset; i < x; i++) {
            buttons[i].setVisible(visible);;
        }
    }

    //action when button is pressed
    abstract public void actionPerformed(ActionEvent e);
}