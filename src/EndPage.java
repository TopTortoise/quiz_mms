import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndPage extends Page {
    int points;

    protected EndPage(int points) {

        super("EndPage");
        this.points = points;
        //create the panel and set the backroung color
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(77, 121, 255));

        //add the buttons
        JButton[] buttons = new JButton[2];
        buttons[0] = new JButton("Exit");
        buttons[1] = new JButton("Retry");
        setButtonVisible(buttons, true);
        initializeButtons(buttons);

        //create the first label at the top and add it to the panel
        JPanel y = new JPanel();
        JLabel l = new JLabel("Herzlichen Glückwunsch zum Abschluss des Spiels!");
        l.setFont(new Font("Grafolita Script", Font.ITALIC, 29));
        y.add(l);
        y.setOpaque(false);
        panel.add(y, BorderLayout.NORTH);

        //create the center panel displaying the result
        JPanel x = new JPanel();
        JLabel w = new JLabel("Ihre Endnote ist: " + points + " von 50 Punkten");
        w.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        x.setLayout(new GridBagLayout());
        x.add(w);
        x.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        x.setOpaque(false);
        panel.add(x, BorderLayout.CENTER);

        //set action commands for the buttons
        buttons[0].setActionCommand("Exit");
        buttons[1].setActionCommand("Retry");

        //set the buttons specifications like height, width and text size and add the to the panel
        JPanel k = new JPanel();
        k.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttons[0].setPreferredSize(new Dimension(300, 50));
        buttons[1].setPreferredSize(new Dimension(300, 50));
        buttons[0].setFont(new Font("Times New Roman", Font.PLAIN, 20));
        buttons[1].setFont(new Font("Times New Roman", Font.PLAIN, 20));
        k.add(buttons[1]);
        k.add(buttons[0]);
        k.setOpaque(false);
        panel.add(k, BorderLayout.SOUTH);

        this.add(panel);
        this.pack();
        this.setSize(1920, 1000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Exit")) {
            System.exit(0);
        } else {
            MenuPage p = new MenuPage();
            p.add(p.panel);
            p.pack();
            p.setSize(this.getSize());
            p.setLocation(this.getLocation());
            this.dispose();
        }
    }
}
