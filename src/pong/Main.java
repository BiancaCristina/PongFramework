package pong;

import utilitarios.Bola;
import utilitarios.Jogador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener {
    JFrame frame;
    PongFutebol pongFutebol;

    public Main() {
        Jogador j1 = new Jogador(1, 20, 150, 40, 800, 600); // Jogador da esquerda
        Jogador j2 = new Jogador(2, 20, 150, 40, 800, 600); // Jogador da direita
        Bola b = new Bola(350,250,20,-3, 1, true);
        frame = new JFrame();
        pongFutebol = new PongFutebol(j1, j2, b, true, 800, 600);
        //pongFutebol = new PongTenis(j1, j2, b, false, 800, 600);
        //pongFutebol = new PongParedao(j1, b, false, 800, 600);

        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());
        frame.add(pongFutebol, BorderLayout.CENTER);

        // Adiciona o listener
        this.frame.addKeyListener(this);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();

        new Thread(() -> main.pongFutebol.iniciarPong()).start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Controla o que acontece quando fica pressionando

        // Jogador 1 nas setinhas
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pongFutebol.getJ1().setAceleracaoSup(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pongFutebol.getJ1().setAceleracaoInf(true);
        }

        // Jogador 2 no W e S
        if (e.getKeyCode() == KeyEvent.VK_W) {
            pongFutebol.getJ2().setAceleracaoSup(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S) {
            pongFutebol.getJ2().setAceleracaoInf(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Controla o que acontece quando paro de pressionar

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pongFutebol.getJ1().setAceleracaoSup(false);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pongFutebol.getJ1().setAceleracaoInf(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_W) {
            pongFutebol.getJ2().setAceleracaoSup(false);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S) {
            pongFutebol.getJ2().setAceleracaoInf(false);
        }
    }

}