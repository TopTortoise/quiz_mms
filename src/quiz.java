class quiz {
    public static void main(String[] args) {
        //starts the quiz       
        MenuPage p = new MenuPage();
        p.add(p.panel);
        p.pack();
        p.setSize(1920, 1000);
        //plays music
        Runnable musicRunner = () -> {
            AudioPlayer a = new AudioPlayer();
            a.playMusic("loveofsea.wav");
        };
        musicRunner.run();
    }


}