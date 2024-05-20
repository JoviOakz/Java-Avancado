package Files;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel {

    private int qty = 4;
    private Mass[] masses;

    public Screen() {
        this.masses = new Mass[qty];

        for (int i = 0; i < qty; i++) {
            if (i < 2) {
                masses[i] = new Mass(i * 160 + 200, 20);
            } else {
                masses[i] = new Mass((i - 2) * 160 + 200, 220);
            }
        }

        setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Mass mass : masses) {
            mass.draw(g);
        }
    }

    public void animation() {
        Timer timer = new Timer(1, e -> {
            for (Mass mass : masses) {
                mass.bounce();
            }

            repaint();
        });
        timer.start();
    }
}