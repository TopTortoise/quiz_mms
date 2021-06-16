import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;


public class QuizPage extends Page {
    private final Font DEFAULTFONT = new Font("ARIAl", Font.PLAIN, 40);

    private JButton[] buttons;
    private Picture answerPicture;

    private final File folder;
    private File[] pics;
    JLabel yourPoints;
    //how many levels
    private int level;
    private final Random r = new Random();
    int points;

    protected QuizPage(String path) {
        super(path + " QUIZ ");
        //initialize variables
        level = 0;
        points = 50;
        //
        this.setLayout(new BorderLayout());
        //setup panel
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel, BorderLayout.NORTH);

        //question
        this.yourPoints = new JLabel("" + points);
        yourPoints.setFont(DEFAULTFONT);
        this.add(yourPoints, BorderLayout.SOUTH);

        //setting up Array for the pictures
        this.folder = new File("pic/" + path);
        this.pics = folder.listFiles();


        buttons = new JButton[4];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setVisible(true);
            buttons[i].addActionListener(this);
            buttons[i].setFont(DEFAULTFONT);
            panel.add(buttons[i]);
        }

        try {
            answerPicture = new Picture(pics[r.nextInt(pics.length)].getPath());
            answerPicture.addActionListener(this);
        } catch (IOException e) {
            // It will never go in here with this setup
            e.printStackTrace();
        }
        panel.add(answerPicture);
        answerPicture.setVisible(true);

        this.add(panel);
        this.pack();
        this.setSize(1920, 1000);
        play();

    }

    //changes the names of the buttons
    private void play() {
        int imageIndex = r.nextInt(pics.length);
        String answer = pics[imageIndex].getPath();
        //

        getAnswers(answer);
        try {
            answerPicture.setImg(answer);
            answerPicture.setName(getImageName(answer));
        } catch (IOException e) {
            // it will never go in here
            e.printStackTrace();
        }


    }

    /**
     * returns only the name of the image without path and .jpg or .png
     *
     * @param imagePath
     * @return
     */
    private String getImageName(String imagePath) {
        //\p{L}+
        Pattern pattern = Pattern.compile("(\\w+)\\.(jpg|png)", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(imagePath);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "Failed!";
    }

    /**
     * gets three random picture names
     *
     * @return JButton array
     */
    private void getAnswers(String imagePath) {
        String[] answers = folder.list();
        String imageName = getImageName(imagePath);


        //choose three random buttons
        Integer[] selectedPics = new Integer[3];
        for (int i = 0; i < buttons.length - 1; ) {
            int rand = r.nextInt(answers.length);
            if (!getImageName(answers[rand]).equals(imageName) && !Arrays.asList(selectedPics).contains((Integer) rand)) {
                //gets imagename without .jpg||.png
                buttons[i].setText(getImageName(answers[rand]));
                buttons[i].setName(getImageName(answers[rand]));
                buttons[i].setActionCommand("false");
                selectedPics[i] = rand;
                i++;
            }
        }

        buttons[3].setName(imageName);
        buttons[3].setText(imageName);
        buttons[3].setActionCommand("false");
        //switch palce
        int rando = r.nextInt(4);
        JButton tmp = buttons[3];
        buttons[3] = buttons[rando];
        buttons[rando] = tmp;
        buttons[rando].setActionCommand("Correct");
    }

    private void exitGame() {
        EndPage end = new EndPage(points);

        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(answerPicture)) {
            try {
                points -= 5;
                yourPoints.setText("" + points);
                answerPicture.pixelate();
            } catch (IOException e1) {
                // it will never go in here
                e1.printStackTrace();
            }
            return;
        }
        if (e.getActionCommand() == "Correct") {
            level++;
            if (level >= 5) exitGame();
            play();

        } else {
            points -= 5;
        }

        yourPoints.setText("" + points);
    }
}
