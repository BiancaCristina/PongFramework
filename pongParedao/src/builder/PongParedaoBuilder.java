package builder;

import builders.PongBuilder;
import pong.PongParedao;
import template.Pong;
import utilitarios.*;

public class PongParedaoBuilder extends PongBuilder {
    PongParedao pongParedao;

    public PongParedaoBuilder() {
        this.pongParedao = new PongParedao();
    }

    public static PongBuilder builder() {
        return new PongParedaoBuilder();
    }

    @Override
    public PongBuilder definirLargura(int largura) {
        this.pongParedao.setLargura(largura);
        return this;
    }

    public PongBuilder definirAltura(int altura) {
        this.pongParedao.setAltura(altura);
        return this;
    }

    public PongBuilder definirTipoJogo(boolean tipoJogo) {
        this.pongParedao.setTipoJogo(tipoJogo);
        return this;
    }

    public PongBuilder criarBola(Bola bola) {
        this.pongParedao.setBola(bola);
        return this;
    }

    @Override
    public PongBuilder criarJogadores(Jogador... jogadores) {
        this.pongParedao.setJogador1(jogadores[0]);
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


    public Pong get() {
        return this.pongParedao;
    }
}
