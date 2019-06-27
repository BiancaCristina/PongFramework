package builders;

import utilitarios.Obstaculo;

public class ObstaculoBuilder {
    protected Obstaculo obstaculo;

    public ObstaculoBuilder() {
        obstaculo = new Obstaculo();
    }

    public static ObstaculoBuilder builder() {
        return new ObstaculoBuilder();
    }

    public ObstaculoBuilder definirLargura(int largura){
        this.obstaculo.setLargura(largura);
        return this;
    }

    public ObstaculoBuilder definirAltura(int altura){
        this.obstaculo.setAltura(altura);
        return this;
    }

    public ObstaculoBuilder definirX(int x) {
        this.obstaculo.setX(x);
        return this;
    }

    public ObstaculoBuilder definirY(int y){
        this.obstaculo.setY(y);
        return this;
    }

    public ObstaculoBuilder definirVelX(int velX) {
        this.obstaculo.setVelX(velX);
        return this;
    }

    public ObstaculoBuilder definirVelY(int velY){
        this.obstaculo.setVelY(velY);
        return this;
    }

    public ObstaculoBuilder definirDistParede(int distParede){
        this.obstaculo.setDistParede(distParede);
        return this;
    }

    public Obstaculo get(){
        return this.obstaculo;
    }
}
