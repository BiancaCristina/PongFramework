package template;

import builders.BolaBuilder;
import template.Pong;
import utilitarios.Bola;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class PongFrame extends JFrame implements KeyListener {
    private Pong pong;

    public abstract void instanciarPong();
    public abstract void instanciarBorda();
    public abstract void instanciarLinhaObstaculo();
    public abstract void instanciarJogadores(int tamanhoJogador);
    public abstract void iniciarJogo();

    public PongFrame(int largura, int altura) {
        setSize(largura, altura);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.addKeyListener(this);
    }

    public Bola instanciarBola(Bola bola, int velocidadeBola, boolean crescente) {
        // Passar singleton aqui
        bola = BolaBuilder
                .builder()
                .definirX(350)
                .definirY(250)
                .definirDimensao(20)
                .definirVelX(velocidadeBola)
                .definirVelY(1)
                .definirCrescente(crescente)
                .get();

        return bola;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Controla o que acontece quando fica pressionando

        // Jogador 1 nas setinhas
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pong.getJogador1().setAceleracaoSup(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pong.getJogador1().setAceleracaoInf(true);
        }

        // Jogador 2 no W e S
        if (e.getKeyCode() == KeyEvent.VK_W) {
            pong.getJogador2().setAceleracaoSup(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S) {
            pong.getJogador2().setAceleracaoInf(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Controla o que acontece quando paro de pressionar

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pong.getJogador1().setAceleracaoSup(false);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pong.getJogador1().setAceleracaoInf(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_W) {
            pong.getJogador2().setAceleracaoSup(false);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S) {
            pong.getJogador2().setAceleracaoInf(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public Pong getPong() {
        return pong;
    }

    public void setPong(Pong pong) {
        this.pong = pong;
    }
}
