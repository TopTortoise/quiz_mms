class quiz{
    public static void main(String[] args) {
        //starts the quiz       
        MenuPage p = new MenuPage();
        p.add(p.panel);
        p.pack();
        p.setSize(1000, 1000);
        
        AudioPlayer a = new AudioPlayer();
        a.playMusic("loveofsea.wav");
   
    }

    
}