package builder;

import builders.PongBuilder;
import pong.PongTenis;
import template.Pong;
import utilitarios.*;

public class PongTenisBuilder extends PongBuilder {
    PongTenis pongTenis;

    public PongTenisBuilder() {
        this.pongTenis = new PongTenis();
    }

    public static PongBuilder builder() {
        return new PongTenisBuilder();
    }

    @Override
    public PongBuilder definirLargura(int largura) {
        this.pongTenis.setLargura(largura);
        return this;
    }

    public PongBuilder definirAltura(int altura) {
        this.pongTenis.setAltura(altura);
        return this;
    }

    public PongBuilder definirTipoJogo(boolean tipoJogo) {
        this.pongTenis.setTipoJogo(tipoJogo);
        return this;
    }

    public PongBuilder criarBola(Bola bola) {
        this.pongTenis.setBola(bola);
        return this;
    }

    @Override
    public PongBuilder criarJogadores(Jogador... jogadores) {
        this.pongTenis.setJogador1(jogadores[0]);
        this.pongTenis.setJogador2(jogadores[1]);
        return this;
    }

    @Override
    public PongBuilder criarObstaculos(Obstaculo... obstaculos) {
        return null;
    }

    @Override
    public PongBuilder criarLinhaObstaculos(LinhaObstaculo... linhaObstaculos) {
        return null;
    }

    @Override
    public PongBuilder criarBorda(BordaObstaculo borda) {
        return null;
    }

    @Override
    public Pong get() {
        return this.pongTenis;
    }
}
