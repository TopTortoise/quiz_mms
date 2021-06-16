class quiz {
    public static void main(String[] args) {
        //starts the quiz       
        MenuPage p = new MenuPage();
        p.add(p.panel);
        p.pack();
        p.setDimensions(null);
        //plays music
        Runnable musicRunner = () -> {
            AudioPlayer a = new AudioPlayer();
            a.playMusic("loveofsea.wav");
        };
        musicRunner.run();
    }


}