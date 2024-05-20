import javax.swing.JFrame;

import Files.Screen;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        Screen screen = new Screen();
        
        frame.add(screen);
        frame.setVisible(true);

        screen.animation();
    }
}