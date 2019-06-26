package builders;

import utilitarios.Jogador;

public interface JogadorBuilder {
    JogadorBuilder definirLargura(int largura);
    JogadorBuilder definirAltura(int altura);
    JogadorBuilder definirDistParede(int distParede);
    JogadorBuilder definirLado(int jogador, int larguraPainel);
    JogadorBuilder definirPosicaoInicial(int alturaPainel);
    Jogador get();
}
