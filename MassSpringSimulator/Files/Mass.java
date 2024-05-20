package Files;

import java.awt.Color;
import java.awt.Graphics;

public class Mass {
    private double posX;
    private double posY;
    private double velX = 0;
    private double velY = 0;
    private double massa = 10;
    private double gravidade = 9.8;
    private double coefRestituicao = 0.7;
    private double forceX = 0;
    private double forceY = 0;

    public Mass(int posX, int posY) {
        this.posX = (double) posX;
        this.posY = (double) posY;
    }

    public double getPosX() {
        return posX + 10;
    }

    public double getPosY() {
        return posY + 10;
    }

    public void addForce(double fx, double fy) {
        this.forceX += fx;
        this.forceY += fy;
    }

    protected void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int) posX, (int) posY, 20, 20);
    }

    public void bounce() {
        this.velX += (forceX / massa) * 0.175;
        this.velY += (forceY / massa + gravidade) * 0.175;

        forceX = 0;
        forceY = 0;

        posX += velX * 0.175;
        posY += velY * 0.175;

        if (this.posY >= 540) {
            this.posY = 540;
            this.velY = -this.velY * coefRestituicao;

            if (Math.abs(this.velY) < 10.1) {
                this.velY = 0;
            }
        }
    }
}