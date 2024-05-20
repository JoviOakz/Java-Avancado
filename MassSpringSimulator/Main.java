import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Files.Mass;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel mainPanel = new JPanel();

        Mass bola1 = new Mass(0, 0);
        Mass bola2 = new Mass(0, 0);
        Mass bola3 = new Mass(0, 0);
        Mass bola4 = new Mass(0, 0);

        Timer timer = new Timer(1, e -> {
            frame.repaint();

            bola1.bounce();
            bola2.bounce();
            bola3.bounce();
            bola4.bounce();
        });
        timer.start();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.add(bola1);
        mainPanel.add(bola2);
        mainPanel.add(bola3);
        mainPanel.add(bola4);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}