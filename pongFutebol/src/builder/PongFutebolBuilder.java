package builder;

import builders.PongBuilder;
import pong.PongFutebol;
import template.Pong;
import utilitarios.*;

public class PongFutebolBuilder extends PongBuilder {
    PongFutebol pongFutebol;
    public PongFutebolBuilder() {
        this.pongFutebol = new PongFutebol();
    }

    public static PongBuilder builder() {
        return new PongFutebolBuilder();
    }

    @Override
    public PongBuilder definirLargura(int largura) {
        this.pongFutebol.setLargura(largura);
        return this;
    }

    public PongBuilder definirAltura(int altura) {
        this.pongFutebol.setAltura(altura);
        return this;
    }

    public PongBuilder definirTipoJogo(boolean tipoJogo) {
        this.pongFutebol.setTipoJogo(tipoJogo);
        return this;
    }

    public PongBuilder criarBola(Bola bola) {
        this.pongFutebol.setBola(bola);
        return this;
    }

    @Override
    public PongBuilder criarJogadores(Jogador... jogadores) {
        this.pongFutebol.setJogador1(jogadores[0]);
        this.pongFutebol.setJogador2(jogadores[1]);
        return this;
    }

    @Override
    public PongBuilder criarObstaculos(Obstaculo... obstaculos) {
        return this;
    }

    @Override
    public PongBuilder criarLinhaObstaculos(LinhaObstaculo... linhaObstaculos) {
        this.pongFutebol.setLinhaObstaculoEsq(linhaObstaculos[0]);
        this.pongFutebol.setLinhaObstaculoDir(linhaObstaculos[1]);
        return this;
    }

    @Override
    public PongBuilder criarBorda(BordaObstaculo borda) {
        this.pongFutebol.setBordaObstaculo(borda);
        return this;
    }

    public Pong get() {
        return this.pongFutebol;
    }
}
