package Files;

import java.awt.Color;
import java.awt.Graphics;

public class Mass {
    private double posX;
    private double posY;
    // private double velX = 0;
    private double velY = 0;
    // private double massa = 10;
    private double gravidade = 9.8;
    private double coefRestituicao = 0.7;

    public Mass(int posX, int posY) {
        this.posX = (double) posX;
        this.posY = (double) posY;
    }

    protected void draw(Graphics g) {
        g.setColor(Color.magenta);
        g.fillOval((int) posX, (int) posY, 20, 20);
    }

    public void bounce() {
        this.posY += this.velY * 0.25;
        this.velY += gravidade * 0.25;
        
        if (this.posY >= 540) {
            this.posY = 540;
            this.velY = -this.velY * coefRestituicao;

            if (Math.abs(this.velY) < 10.1) {
                this.velY = 0;
            }
        }
    }
}