// import Files.*;

import javax.swing.JFrame;
import javax.swing.Timer;

import Files.Mass;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        Mass bola = new Mass();

        Timer timer = new Timer(10, e -> {
            frame.repaint();

            bola.bounce();
        });
        timer.start();

        frame.add(bola);
        frame.setVisible(true);
    }
}