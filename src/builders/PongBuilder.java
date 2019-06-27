package builders;

import template.Pong;
import utilitarios.*;

public abstract class PongBuilder {
    public abstract PongBuilder criarJogadores(Jogador... jogadores);
    public abstract PongBuilder criarObstaculos(Obstaculo... obstaculos);
    public abstract PongBuilder criarLinhaObstaculos(LinhaObstaculo... linhaObstaculos);
    public abstract PongBuilder criarBorda(BordaObstaculo borda);
    public abstract PongBuilder definirLargura(int largura);
    public abstract PongBuilder definirAltura(int altura);
    public abstract PongBuilder definirTipoJogo(boolean tipoJogo);
    public abstract PongBuilder criarBola(Bola bola);
    public abstract Pong get();
}
