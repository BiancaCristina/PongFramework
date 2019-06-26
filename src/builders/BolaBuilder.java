package builders;

import utilitarios.Bola;

public class BolaBuilder {
    protected Bola bola;

    public BolaBuilder() {
        this.bola = new Bola();
    }

    public static BolaBuilder builder() {
        return new BolaBuilder();
    }

    public BolaBuilder definirDimensao(int dimensao) {
        this.bola.setLargura(dimensao);
        this.bola.setAltura(dimensao);
        return this;
    }

    public BolaBuilder definirX(int x) {
        this.bola.setX(x);
        this.bola.setInicialX(x);
        return this;
    }

    public BolaBuilder definirY(int y) {
        this.bola.setY(y);
        this.bola.setInicialY(y);
        return this;
    }

    public BolaBuilder definirVelX(int velX) {
        this.bola.setVelX(velX);
        this.bola.setInicialVelX(velX);
        return this;
    }

    public BolaBuilder definirVelY(int velY) {
        this.bola.setVelY(velY);
        this.bola.setInicialVelY(velY);
        return this;
    }

    public BolaBuilder definirCrescente(boolean crescente) {
        this.bola.setCrescente(crescente);
        return this;
    }

    public Bola get() {
        return this.bola;
    }
}
