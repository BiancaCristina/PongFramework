package builders;

import utilitarios.LinhaObstaculo;

public class LinhaObstaculoBuilder {
    protected LinhaObstaculoImpl linhaObstaculo;

    public LinhaObstaculoBuilder() {
        this.linhaObstaculo = new LinhaObstaculoImpl();
    }

    public static LinhaObstaculoBuilder builder() {
        return new LinhaObstaculoBuilder();
    }

    public LinhaObstaculoBuilder definirLargura(int largura) {
        this.linhaObstaculo.setLargura(largura);
        return this;
    }

    public LinhaObstaculoBuilder definirAltura(int altura) {
        this.linhaObstaculo.setAltura(altura);
        return this;
    }

    public LinhaObstaculoBuilder definirY(int y) {
        this.linhaObstaculo.setY(y);
        return this;
    }

    public LinhaObstaculoBuilder definirVelY(int velY) {
        this.linhaObstaculo.setVelY(velY);
        return this;
    }

    public LinhaObstaculoBuilder definirDistParede(int distParede) {
        this.linhaObstaculo.setDistParede(distParede);
        return this;
    }

    public LinhaObstaculoBuilder criarLinhaObstaculos(int alturaPainel) {
        int largura = this.linhaObstaculo.getLargura();
        int altura = this.linhaObstaculo.getAltura();
        int y = this.linhaObstaculo.getY();
        int velY = (int)this.linhaObstaculo.getVelY();
        int distParede = this.linhaObstaculo.getDistParede();

        this.linhaObstaculo.setObstaculo1(new ObstaculoImpl(largura, altura, y, velY, distParede));
        this.linhaObstaculo.setObstaculo2(new ObstaculoImpl(largura, altura, y+alturaPainel/3, velY, distParede));
        this.linhaObstaculo.setObstaculo3(new ObstaculoImpl(largura, altura, y+2*(alturaPainel/3), velY, distParede));

        return this;
    }

    public LinhaObstaculo get() {
        return this.linhaObstaculo;
    }
}
