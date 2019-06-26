package builders;

import utilitarios.Jogador;

public class JogadorBuilder {
    protected Jogador jogador;

    public JogadorBuilder() {
        this.jogador = new Jogador();
        this.jogador.setAceleracaoSup(false);
        this.jogador.setAceleracaoInf(false);
        this.jogador.setPontuacao(0);
        this.jogador.setVelY(0);
    }

    public static JogadorBuilder builder() {
        return new JogadorBuilder();
    }

    public JogadorBuilder definirLargura(int largura) {
        this.jogador.setLargura(largura);
        return this;
    }

    public JogadorBuilder definirAltura(int altura) {
        this.jogador.setAltura(altura);
        return this;
    }

    public JogadorBuilder definirDistParede(int distParede) {
        this.jogador.setDistParede(distParede);
        this.jogador.setX(distParede);
        return this;
    }

    public JogadorBuilder definirLado(int jogador, int larguraPainel) {
        if (jogador == 1) this.jogador.setDistParede(this.jogador.getDistParede());
        else this.jogador.setDistParede(larguraPainel - this.jogador.getLargura() - this.jogador.getDistParede());
        return this;
    }

    public JogadorBuilder definirPosicaoInicial(int alturaPainel) {
        this.jogador.setY(alturaPainel/2);
        return this;
    }

    public Jogador get() {
        return this.jogador;
    }
}
