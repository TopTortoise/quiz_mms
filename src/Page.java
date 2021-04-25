import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


abstract class Page {

    JButton[] buttons;
    String title;
    String[] text;
    JFrame frame;
    JPanel panel;
    protected Page(JButton[] buttons, String title, String[] text){
        this.buttons = buttons;
        this.title = title;
        this.text = text;
        this.frame = new JFrame();
        this.panel = new JPanel();
    }
    protected Page(JButton[] buttons, String title){
        this.buttons = buttons;
        this.title = title;
        this.text = null;
        this.frame = new JFrame();
        this.panel = new JPanel();
    }

    void initializeButtons(){
        for (JButton Button : buttons) {
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

}