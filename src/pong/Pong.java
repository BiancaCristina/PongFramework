package pong;


import utilitarios.Bola;
import utilitarios.Jogador;

import javax.swing.*;

public abstract class Pong extends JPanel {
    private int largura;
    private int altura;
    private Jogador j1;
    private Jogador j2;
    private Bola b;
    private boolean tipoJogo;
    private boolean acabou;

    public Pong(Jogador j1, Bola b, boolean tipoJogo, int largura, int altura) {
        this.setTipoJogo(tipoJogo);
        this.setAcabou(false);
        this.setLargura(largura);
        this.setAltura(altura);
        this.setSize(largura, altura);
        this.setJ1(j1);
        this.setB(b);
    }

    public abstract void iniciarPong();

    public void atualizarPontuacao(Jogador j) {
        j.aumentarPontuacao();

        if (j.getPontuacao() > 3 && isTipoJogo()) {
            setAcabou(true);
            return;
        }

        getB().reiniciar();
    }

    public Jogador getJ1() {
        return j1;
    }
    public Jogador getJ2() {
        return j2;
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

    public void setJ1(Jogador j1) {
        this.j1 = j1;
    }

    public void setJ2(Jogador j2) {
        this.j2 = j2;
    }

    public Bola getB() {
        return b;
    }

    public void setB(Bola b) {
        this.b = b;
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
}
