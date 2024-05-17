package Files;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;

public class Mass extends JComponent {
    private double posX = 290;
    private double posY = 0;
    private double velX = 0;
    private double velY = 0;
    private double massa = 10;
    private double gravidade = 9.8;
    private double aceleracao = 0;

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.magenta);
        g.fillOval((int)posX, (int)posY, 20, 20);
    }

    public void bounce() {
        if (posY > 540) {
            velY = 0;
        } else {
            velY = Math.sqrt(2 * gravidade * 600-posY);
            posY += (int)(velY * 0.025);
        }
    }
}