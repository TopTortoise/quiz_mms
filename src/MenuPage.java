//package src;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class MenuPage extends Page{
    protected JButton[] buttons;
    protected String[] buttonNames;
    private final Font DEFAULTFONT = new Font("ARIAl",Font.PLAIN,40);

    protected MenuPage() {
        super("Menu");
        panel.setLayout(new GridLayout(4,0,50,0));
        buttons = new JButton[4];
        buttonNames = new String[]{"VEHICLES", "ANIMALS", "SHIPS", "CITIES" };
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFont(DEFAULTFONT);
            buttons[i].setBackground(Color.WHITE);
        }
        setButtonVisible(buttons, true);
        initializeButtons(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                //QuizPage selected = new QuizPage(buttonNames[i]);
               quiz me = new quiz();
               me.main(null);
                this.dispose();

            }
        }


    }
}
