package src;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPage extends JFrame implements ActionListener {
    JButton[] buttons;
    String[] buttonNames;


    protected MenuPage() {
        super("Menu");
        buttons = new JButton[4];
        buttonNames = new String[]{"VEHICLES", "ANIMALS", "SHIPS", "CITIES" };
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setName(buttonNames[i]);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                QuizPage selected = new QuizPage(buttonNames[i]);
            }
        }


    }
}
