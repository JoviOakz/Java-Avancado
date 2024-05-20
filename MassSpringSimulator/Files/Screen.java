package Files;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel {

    private int bQty = 4;
    private Mass[] masses;
    private List<Spring> springs;

    public Screen() {
        this.masses = new Mass[bQty];
        this.masses = new Mass[bQty];

        for (int i = 0; i < bQty; i++) {
            if (i < 2) {
                masses[i] = new Mass(i * 160 + 200, 20);
            } else {
                masses[i] = new Mass((i - 2) * 160 + 200, 220);
            }
        }

        setBackground(Color.pink);

        this.springs = new ArrayList<>();
        double restLength = 100;
        double k = 0.1;

        for (int i = 0; i < bQty; i++) {
            for (int j = i + 1; j < bQty; j++) {
                springs.add(new Spring(masses[i], masses[j], restLength, k));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for (Spring spring : springs) {
            g.drawLine((int) spring.getMass1().getPosX(), (int) spring.getMass1().getPosY(),
                    (int) spring.getMass2().getPosX(), (int) spring.getMass2().getPosY());
        }

        for (Mass mass : masses) {
            mass.draw(g);
        }
    }

    public void animation() {
        Timer timer = new Timer(1, e -> {
            for (Spring spring : springs) {
                spring.applyForce();
            }

            for (Mass mass : masses) {
                mass.bounce();
            }

            repaint();
        });
        timer.start();
    }
}