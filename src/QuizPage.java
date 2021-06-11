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




public class QuizPage extends Page{
    private final Font DEFAULTFONT = new Font("ARIAl",Font.PLAIN,40);

    //private Picture[] imgButtons;
    private JButton[] buttons;
    private Picture answerPicture;

    private final File folder;
    private File[] pics;
    //how many levels
    private int level;
    private final Random r = new Random();

    protected QuizPage(String path){
        super(path+" QUIZ ");
        //
        level = 0;
        //
        this.setLayout(new BorderLayout());
        //setup panel
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel, BorderLayout.NORTH);
        //question
        this.add(new JLabel("Was ist das?"),BorderLayout.SOUTH);

        //setting up Array for the pictures
        this.folder = new File("pic/"+path);
        this.pics = folder.listFiles();
     

        buttons = new JButton[4];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setVisible(true);
            buttons[i].addActionListener(this);
            buttons[i].setFont(DEFAULTFONT);
            panel.add(buttons[i],BorderLayout.NORTH);
        }

        try {
            answerPicture = new Picture(pics[r.nextInt(pics.length)].getPath());
            answerPicture.addActionListener(this);
        } catch (IOException e) {
            // TODO not sure whaat do here
            e.printStackTrace();
        }

        panel.add(answerPicture, BorderLayout.CENTER);
        answerPicture.setVisible(true);


        this.add(panel);
        this.pack();
        this.setSize(2000,2000);
        play();

    }
    //changes the names of the buttons
    private void play() {
        int imageIndex = r.nextInt(pics.length);
        String answer = pics[imageIndex].getPath();
        getAnswers(answer);
        try {
            answerPicture.setImg(answer);
            answerPicture.setName(getImageName(answer));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
    /**
     * returns only the name of the image without path and .jpg or .png
     * @param imagePath
     * @return
     */
    private String getImageName(String imagePath){
        //\p{L}+
        Pattern pattern = Pattern.compile("(\\w+)\\.(jpg|png)", Pattern.UNICODE_CHARACTER_CLASS);
		Matcher matcher = pattern.matcher(imagePath);
        if(matcher.find( )){
        return matcher.group(1);
        }
        return "Failed!";

    }

    /**
     * gets three random picture names
     * @return JButton array
     */
    private void getAnswers(String imagePath){
        String[] answers = folder.list();
        //gets only the image name without path and ".jpg/png"
        for (int i = 0; i < answers.length; i++) {
          answers[i] = getImageName(answers[i]);
        }
   
        //choose three random buttons
        for (int i = 0; i < buttons.length-1; ) {
            int rand = r.nextInt(answers.length);
            if(!answers[rand].equals(imagePath) && !Arrays.stream(buttons).anyMatch(button->button.getText()==answers[rand])){
                buttons[i].setText(answers[rand]);
                buttons[i].setName(answers[rand]);
                i++;
            }
        }
        buttons[3].setName(getImageName(imagePath));
        buttons[3].setText(getImageName(imagePath));

        //switch palce
        int rando = r.nextInt(4);
        JButton tmp = buttons[3];
        buttons[3] = buttons[rando];
        buttons[rando] = tmp;
    
    }

    private void exit(){
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(level >4){
            //TODO need endpage
            //EndPage ending = new EndPage();
            exit();
        }
        if(e.getSource().equals(answerPicture)){
            try {
                answerPicture.pixi();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return;
        }
        for (JButton button : buttons) {
            if(e.getSource() == button && button.getName().equals(answerPicture.getName())){
                level++;
                play();
            }
        }
        // TODO Auto-generated method stub
    }
    
}
