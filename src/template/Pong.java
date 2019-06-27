package template;


import utilitarios.Bola;
import utilitarios.Jogador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Pong extends JPanel {
    private int largura;
    private int altura;
    private Jogador jogador1;
    private Jogador jogador2;
    private Bola bola;
    private boolean tipoJogo;
    private boolean acabou;

    public abstract void iniciarPong();
    public abstract void paintComponent(Graphics g);
    public abstract void atualizarPontuacao(Jogador j);

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

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }
}
