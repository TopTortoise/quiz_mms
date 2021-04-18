# MMS quiz

- Page should have a button for getting to the menu, except the menu button


#Paul
```java
abstract class Page extends JFrame implements ActionListener{

    JButton[] buttons;
    JLabel Title;
    Jlabel[] texts;
    final Container panel;

    void playMusic(){}
    

    

    public void actionPerformed(ActionEvent ae){


    }
}

```

##Kazue
```java
class MenuPage extends Page{

    MenuPage(JButton[] buttons, Jlabel Title, Jlabel[] texts){}
    

    void placeButtons(int x, int y){}

    void setButtons(String[] texts){}

    void levelmenu(){}


    public void actionperformed(ActionEvent ae){
        // select level
        //options (if necessary)
        // Exit für Kazue
    }
}
```

##Paul
```java 
class QuizPage extends Page{

    Picture[] pictures;//maybe
    int points;
    QuizPage(JButton[] buttons, Jlabel Title){

        this.pictures = getPictures();

    }
    void nextPage(){}

    public void actionperformed(ActionEvent ae){
        // go to next Page when correct
        // safe Points
    }

}

```

##MO
```java 
class EndPage extends Page{

    int Points;
    Quiz(JButton[] buttons, Jlabel Title){


    }


    public void actionperformed(ActionEvent ae){
        // back to menu or retry
    }

}

```

##Hanna
```java


class Picture extends ...{

    String name;
    Category category;

    Picture pixelate(Picture picture, int level){}

    Picture unpixelate(Picture picture)


}

```
##Paul
```java
Enum Category{

    CATEGORY1,CATEGORY2,...;
}//enum class


```

##Everyone

```java
class Quiz{
    //starts quiz
}


```


##Jona
```java
class Music extends/implements ... {

    String name;

    Category category;

    void play();

    boolean isPlaying();

    void stop();

    boolean hasStopped();

    boolean repeat();

    boolean isRepeating();

    Music getMusic();



}

```