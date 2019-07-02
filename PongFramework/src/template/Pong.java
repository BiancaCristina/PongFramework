package template;


import utilitarios.Bola;
import utilitarios.Jogador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Pong extends JPanel implements KeyListener {
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Controla o que acontece quando fica pressionando

        // Jogador 1 nas setinhas
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            getJogador1().setAceleracaoSup(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            getJogador1().setAceleracaoInf(true);
        }

        // Jogador 2 no W e S
        if (e.getKeyCode() == KeyEvent.VK_W && getJogador2() != null) {
            getJogador2().setAceleracaoSup(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S && getJogador2() != null) {
            getJogador2().setAceleracaoInf(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Controla o que acontece quando paro de pressionar

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            getJogador1().setAceleracaoSup(false);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            getJogador1().setAceleracaoInf(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_W && getJogador2() != null) {
            getJogador2().setAceleracaoSup(false);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S && getJogador2() != null) {
            getJogador2().setAceleracaoInf(false);
        }
    }
}
