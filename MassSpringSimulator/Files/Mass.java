package Files;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;

public class Mass extends JComponent {
    private float posX = 290f;
    private float posY = 0f;
    private float velX = 0f;
    private float velY = 0f;
    private float massa = 10f;
    private float gravidade = 9.8f;
    private float aceleracao = 0f;

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.magenta);
        g.fillOval((int)posX, (int)posY, 20, 20);
    }

    public void bounce() {
        if (posY >= 540) {
            velY = 0;
            return;
        } else {
            velY = (int)Math.sqrt(2 * gravidade * 600-posY);
            posY += velY * 0.025f;
        }
    }
}