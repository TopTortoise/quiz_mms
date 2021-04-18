# MMS quiz

- Dont use JButtons, make own classe
- Page should have a button for getting to the menu, except the menu button



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


```java
class Menu extends Page{

    Menu(JButton[] buttons, Jlabel Title, Jlabel[] texts){}
    

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

```java 
class Quiz extends Page{

    Picture[] pictures;
    int points;
    Quiz(JButton[] buttons, Jlabel Title){

        this.pictures = getPictures();

    }
    void nextPage(){}

    public void actionperformed(ActionEvent ae){
        // go to next Page when correct
        // safe Points
    }

}

```

```java 
class End extends Page{

    int Points;
    Quiz(JButton[] buttons, Jlabel Title){


    }


    public void actionperformed(ActionEvent ae){
        // back to menu or retry
    }

}

```

```java


class Picture extends ...{

    String name;
    Category category;

    Picture pixelate(Picture picture){}

    Picture unpixelate(Picture picture)


}

```

```java
Enum Category; //enum class


```

```java
class main{

}


```

```java


```