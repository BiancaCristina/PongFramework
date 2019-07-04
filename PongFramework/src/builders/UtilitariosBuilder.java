package builders;

import utilitarios.Bola;
import utilitarios.BordaObstaculo;
import utilitarios.Jogador;
import utilitarios.LinhaObstaculo;

public class UtilitariosBuilder {
    protected Bola bola;
    protected Jogador j1;
    protected Jogador j2;
    protected LinhaObstaculo linhaObstaculo1;
    protected LinhaObstaculo linhaObstaculo2;
    protected BordaObstaculo bordaObstaculo;

    public static UtilitariosBuilder builder() {
        return new UtilitariosBuilder();
    }

    public Jogador criarJogador1(int tamanhoJogador) {
        j1 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(tamanhoJogador)
                .definirDistParede(40)
                .definirLado(1, 800)
                .definirPosicaoInicial(600)
                .get();
        return j1;
    }

    public Jogador criarJogador2(int tamanhoJogador) {
        j2 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(tamanhoJogador)
                .definirDistParede(40)
                .definirLado(2, 800)
                .definirPosicaoInicial(600)
                .get();

        return j2;
    }

    public BordaObstaculo criarBorda() {
        bordaObstaculo = BordaObstaculoBuilder
                .builder()
                .criarBordaSuperior(800, 20)
                .criarBordaInferior(800, 20, 600)
                .criarBordaLateral(20, 150, 800, 600)
                .get();

        return bordaObstaculo;
    }

    public LinhaObstaculo criarLinhaObstaculo1(int altura, int distParede) {
        linhaObstaculo1 = LinhaObstaculoBuilder
                .builder()
                .definirLargura(10)
                .definirAltura(60)
                .definirY(5)
                .definirVelY(2)
                .definirDistParede(distParede)
                .criarLinhaObstaculos(altura)
                .get();

        return linhaObstaculo1;
    }

    public LinhaObstaculo criarLinhaObstaculo2(int altura, int distParede) {
        linhaObstaculo2 = LinhaObstaculoBuilder
                .builder()
                .definirLargura(10)
                .definirAltura(60)
                .definirY(45)
                .definirVelY(2)
                .definirDistParede(distParede)
                .criarLinhaObstaculos(altura)
                .get();

        return linhaObstaculo2;
    }

}
