package builders;

import pong.Pong;
import utilitarios.*;

public interface PongBuilder {
    PongBuilder definirLargura(int largura);
    PongBuilder definirAltura(int altura);
    PongBuilder definirTipoJogo(boolean tipoJogo);
    PongBuilder criarBola(Bola bola);
    PongBuilder criarJogadores(Jogador... jogadores);
    PongBuilder criarObstaculos(Obstaculo... obstaculos);
    PongBuilder criarLinhaObstaculos(LinhaObstaculo... linhaObstaculos);
    PongBuilder criarBorda(BordaObstaculoBuilder borda);
    Pong get();
}
