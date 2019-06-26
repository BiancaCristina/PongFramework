package builders;

import pong.Pong;
import pong.PongFutebol;
import utilitarios.*;

public class PongFutebolBuilder implements PongBuilder{
    protected Pong pong;

    public PongFutebolBuilder() {
        this.pong = new PongFutebol();
    }

    public static PongBuilder builder() {
        return new PongFutebolBuilder();
    }

    @Override
    public PongBuilder definirLargura(int largura) {
        this.pong.setLargura(largura);
        return this;
    }

    @Override
    public PongBuilder definirAltura(int altura) {
        this.pong.setAltura(altura);
        return this;
    }

    @Override
    public PongBuilder definirTipoJogo(boolean tipoJogo) {
        this.pong.setTipoJogo(tipoJogo);
        return this;
    }

    @Override
    public PongBuilder criarBola(Bola bola) {
        this.pong.setBola(bola);
        return this;
    }

    @Override
    public PongBuilder criarJogadores(Jogador... jogadores) {
        this.pong.setJogadorEsq(jogadores[0]);
        this.pong.setJogadorDir(jogadores[1]);
        return this;
    }

    @Override
    public PongBuilder criarObstaculos(Obstaculo... obstaculos) {
        return this;
    }

    @Override
    public PongBuilder criarLinhaObstaculos(LinhaObstaculo... linhaObstaculos) {
        this.pong.setLinhaObstaculoEsq(linhaObstaculos[0]);
        this.pong.setLinhaObstaculoDir(linhaObstaculos[1]);
        return this;
    }

    @Override
    public PongBuilder criarBorda(BordaObstaculo borda) {
        this.pong.setBordaObstaculo(borda);
        return this;
    }

    @Override
    public Pong get() {
        return this.pong;
    }
}
