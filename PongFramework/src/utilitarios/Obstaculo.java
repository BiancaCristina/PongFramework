package utilitarios;

import java.awt.*;

public class Obstaculo extends Ponto {

    public Obstaculo(int largura, int altura, int y, int velY, int distParede) {
        this.setLargura(largura);
        this.setAltura(altura);
        this.setVelY(velY);
        this.setY(y);
        this.setDistParede(distParede);
    }

    public Obstaculo(int largura, int altura, int y, int distParede) {
        this.setY(y);
        this.setLargura(largura);
        this.setAltura(altura);
        this.setDistParede(distParede);
    }

    public Obstaculo() {}



    @Override
    public void desenhar(Graphics g) {
        // Define as dimensões do obstáculo

        g.setColor(Color.white);
        g.fillRect(getDistParede(), getY(), getLargura(), getAltura());
    }

    @Override
    public void mover(int alturaPanel) {
        setY(getY() + getVelY());
    }
}
