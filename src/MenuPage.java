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
        buttonNames = new String[]{"Fahrzeuge", "Tiere", "Schiffe", "Städte" };
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFont(DEFAULTFONT);
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setActionCommand(buttonNames[i]);
        }
        setButtonVisible(buttons, true);
        initializeButtons(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        QuizPage quiz;
       switch (e.getActionCommand()) {
           case "Fahrzeuge":
               quiz = new QuizPage("VEHICLES");
               this.dispose();
               break;
            case "Tiere":
               quiz = new QuizPage("ANIMALS");
               this.dispose();
               break;
            case "Schiffe":
               quiz = new QuizPage("SHIPS");
               this.dispose();
               break;
            case "Städte":
               quiz = new QuizPage("CITIES");
               this.dispose();
               break;
           default:
               break;
       }


    }
}
