package interfaces;

import template.Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongFrame extends JFrame implements KeyListener {
    private Pong pong;

    public PongFrame(int largura, int altura, Pong pong) {
        setSize(largura, altura);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(pong);
        addKeyListener(this);
        setVisible(true);
    }

    public PongFrame(int largura, int altura) {
        setSize(largura, altura);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        addKeyListener(this);
        setVisible(true);
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
}
