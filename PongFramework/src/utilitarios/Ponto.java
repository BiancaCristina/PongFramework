package utilitarios;

import java.awt.*;

public abstract class Ponto {
    private int largura;
    private int altura;
    private int distParede;
    private double x;
    private double y;
    private double velX;
    private double velY;
    private final double GRAVIDADE = 0.94;

    public abstract void desenhar(Graphics g);
    public abstract void mover(int alturaPanel);

    public int getX() {
        return (int)x;
    }
    public int getY() {
        return (int)y;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getDistParede() {
        return distParede;
    }

    public void setDistParede(int distParede) {
        this.distParede = distParede;
    }

    public double getGRAVIDADE() {
        return GRAVIDADE;
    }
}

