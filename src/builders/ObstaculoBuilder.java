package builders;

import utilitarios.Obstaculo;

public class ObstaculoBuilder {
    protected ObstaculoImpl obstaculo;

    public ObstaculoBuilder() {
        this.obstaculo = new ObstaculoImpl();
    }

    public static ObstaculoBuilder builder() {
        return new ObstaculoBuilder();
    }

    public ObstaculoBuilder definirLargura(int largura) {
        this.obstaculo.setLargura(largura);
        return this;
    }

    public ObstaculoBuilder definirAltura(int altura) {
        this.obstaculo.setAltura(altura);
        return this;
    }

    public ObstaculoBuilder definirY(int y) {
        this.obstaculo.setY(y);
        return this;
    }

    public ObstaculoBuilder definirVelY(int velY) {
        this.obstaculo.setVelY(velY);
        this.obstaculo.setVelX(0);
        return this;
    }

    public ObstaculoBuilder definirDistParede(int distParede) {
        this.obstaculo.setDistParede(distParede);
        return this;
    }

    public Obstaculo get() {
        return this.obstaculo;
    }
}
