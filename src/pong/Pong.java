package pong;


import utilitarios.Bola;
import utilitarios.BordaObstaculo;
import utilitarios.Jogador;
import utilitarios.LinhaObstaculo;

import javax.swing.*;

public abstract class Pong extends JPanel {
    private int largura;
    private int altura;
    private Jogador jogadorEsq;
    private Jogador jogadorDir;
    private Bola bola;
    private boolean tipoJogo;
    private boolean acabou;
    private LinhaObstaculo linhaObstaculoEsq;
    private LinhaObstaculo linhaObstaculoDir;
    private BordaObstaculo bordaObstaculo;

    public abstract void iniciarPong();

    public void atualizarPontuacao(Jogador j) {
        j.aumentarPontuacao();

        if (j.getPontuacao() > 3 && isTipoJogo()) {
            setAcabou(true);
            return;
        }

        getBola().reiniciar();
    }

    public Jogador getJogadorEsq() {
        return jogadorEsq;
    }
    public Jogador getJogadorDir() {
        return jogadorDir;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setJogadorEsq(Jogador jogadorEsq) {
        this.jogadorEsq = jogadorEsq;
    }

    public void setJogadorDir(Jogador jogadorDir) {
        this.jogadorDir = jogadorDir;
    }

    public Bola getBola() {
        return bola;
    }

    public void setBola(Bola bola) {
        this.bola = bola;
    }

    public boolean isTipoJogo() {
        return tipoJogo;
    }

    public void setTipoJogo(boolean tipoJogo) {
        this.tipoJogo = tipoJogo;
    }

    public boolean isAcabou() {
        return acabou;
    }

    public void setAcabou(boolean acabou) {
        this.acabou = acabou;
    }

    public LinhaObstaculo getLinhaObstaculoEsq() {
        return linhaObstaculoEsq;
    }

    public void setLinhaObstaculoEsq(LinhaObstaculo linhaObstaculoEsq) {
        this.linhaObstaculoEsq = linhaObstaculoEsq;
    }

    public LinhaObstaculo getLinhaObstaculoDir() {
        return linhaObstaculoDir;
    }

    public void setLinhaObstaculoDir(LinhaObstaculo linhaObstaculoDir) {
        this.linhaObstaculoDir = linhaObstaculoDir;
    }

    public BordaObstaculo getBordaObstaculo() {
        return bordaObstaculo;
    }

    public void setBordaObstaculo(BordaObstaculo bordaObstaculo) {
        this.bordaObstaculo = bordaObstaculo;
    }
}
