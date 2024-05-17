package Files;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;

public class Mass extends JComponent {
    private double posX = 290;
    private double posY = 11;
    private double velX = 0;
    private double velY = 0;
    private double massa = 10;
    private double gravidade = 9.8;
    private double coefRestituicao = 0.7;
    private boolean stop = false;

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.magenta);
        g.fillOval((int) posX, (int) posY, 20, 20);
    }

    public void bounce() {
        
        System.out.println("Velocidade y:");
        System.out.println(Math.abs(this.velY));

        System.out.println("Posicao y:");
        System.out.println(this.posY);

        if (this.velY <= 6 && this.velY > 0 && this.posY >= 536) {
            this.velY = 0;
            this.posY = 540;
            stop = true;
            return;
        }

        if(!stop){
            // Atualizar a posição vertical baseada na velocidade
            this.posY += this.velY * 0.25;
            // Atualizar a velocidade vertical baseada na gravidade
            this.velY += gravidade * 0.25;
        }

        // Checar se a bola atingiu o chão
        if (this.posY >= 540) {

            this.posY = 540; // Corrigir a posição para não passar do chão
            this.velY = -this.velY * coefRestituicao; // Inverter a velocidade e aplicar a perda de energia
        }
    }
}