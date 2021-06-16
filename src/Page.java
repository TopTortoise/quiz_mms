import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


abstract class Page extends JFrame implements ActionListener {
    String title;
    JPanel panel;

    protected Page(String title) {
        //setup vairiables
        this.title = title;
        this.setTitle(title);
        this.panel = new JPanel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * adds buttons to the panel
     */
    void initializeButtons(JButton[] buttons) {
        for (JButton Button : buttons) {
            Button.addActionListener(this);
            panel.add(Button);
        }
    }

    /**
     * sets all the buttons to (true) visible or (false) hidden
     *
     * @param visible
     */
    void setButtonVisible(JButton[] buttons, boolean visible) {
        for (JButton Button : buttons) {
            Button.setVisible(true);
        }
    }

    /**
     * set buttons to visible if true from offset to i < x
     *
     * @param offset
     * @param x
     * @param visible
     */
    void setButtonVisible(JButton[] buttons, int offset, int x, boolean visible) throws IndexOutOfBoundsException {
        if (x > buttons.length || offset > x || offset < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = offset; i < x; i++) {
            buttons[i].setVisible(visible);
        }
    }

    /**
     * set page size as well as position to given page
     * @param oldPage
     */
    void setDimensions(Page oldPage){
        if(oldPage != null) {
            // set size/location/fullscreen state of last window
            this.setSize(oldPage.getSize());
            this.setLocation(oldPage.getLocation());
            this.setExtendedState(oldPage.getExtendedState());
        } else {
            // default in fullscreen
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        // if fullscreen, take this as fallback size if fullscreen is ended
        if(this.getExtendedState() == JFrame.MAXIMIZED_BOTH){
            this.setSize(new Dimension(800,600));
        }

        this.setVisible(true);
    }

    //action when button is pressed
    abstract public void actionPerformed(ActionEvent e);
}