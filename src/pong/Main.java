package pong;

import builders.*;
import utilitarios.Bola;
import utilitarios.BordaObstaculo;
import utilitarios.Jogador;
import utilitarios.LinhaObstaculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener {
    JFrame frame;
    Pong pong;

    public Main() {
        Jogador j1 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(150)
                .definirDistParede(40)
                .definirLado(1, 800)
                .definirPosicaoInicial(600)
                .get();

        Jogador j2 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(150)
                .definirDistParede(40)
                .definirLado(2, 800)
                .definirPosicaoInicial(600)
                .get();

        Bola b = BolaBuilder
                .builder()
                .definirX(350)
                .definirY(250)
                .definirDimensao(20)
                .definirVelX(-3)
                .definirVelY(1)
                .definirCrescente(true)
                .get();

        BordaObstaculo bordaObstaculo = BordaObstaculoBuilder
                .builder()
                .criarBordaSuperior(800, 20)
                .criarBordaInferior(800, 20, 600)
                .criarBordaLateral(20, 150, 800, 600)
                .get();

        LinhaObstaculo linhaObstaculo1 = LinhaObstaculoBuilder
                .builder()
                .definirLargura(10)
                .definirAltura(60)
                .definirY(5)
                .definirVelY(2)
                .definirDistParede(800-550)
                .criarLinhaObstaculos(600)
                .get();

        LinhaObstaculo linhaObstaculo2 = LinhaObstaculoBuilder
                .builder()
                .definirLargura(10)
                .definirAltura(60)
                .definirY(45)
                .definirVelY(2)
                .definirDistParede(800-250)
                .criarLinhaObstaculos(600)
                .get();

        /*
        pong = PongParedaoBuilder
                .builder()
                .definirLargura(800)
                .definirAltura(600)
                .definirTipoJogo(false)
                .criarBola(b)
                .criarJogadores(j1)
                .get();

         */

        pong = PongFutebolBuilder
                .builder()
                .definirLargura(800)
                .definirAltura(600)
                .definirTipoJogo(false)
                .criarBola(b)
                .criarJogadores(j1, j2)
                .criarLinhaObstaculos(linhaObstaculo1, linhaObstaculo2)
                .criarBorda(bordaObstaculo)
                .get();



        /*
        pong = PongTenisBuilder
                .builder()
                .definirLargura(800)
                .definirAltura(600)
                .definirTipoJogo(false)
                .criarBola(b)
                .criarJogadores(j1, j2)
                .criarLinhaObstaculos(linhaObstaculo1, linhaObstaculo2)
                .get();
        */

        frame = new JFrame();
        //pong = new PongFutebol(j1, j2, b, true, 800, 600);
        //pong = new PongTenis(j1, j2, b, false, 800, 600);
        //pong = new PongParedao(j1, b, false, 800, 600);

        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());
        frame.add(pong, BorderLayout.CENTER);

        // Adiciona o listener
        this.frame.addKeyListener(this);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();

        new Thread(() -> main.pong.iniciarPong()).start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Controla o que acontece quando fica pressionando

        // Jogador 1 nas setinhas
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pong.getJogadorEsq().setAceleracaoSup(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pong.getJogadorEsq().setAceleracaoInf(true);
        }

        // Jogador 2 no W e S
        if (e.getKeyCode() == KeyEvent.VK_W) {
            pong.getJogadorDir().setAceleracaoSup(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S) {
            pong.getJogadorDir().setAceleracaoInf(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Controla o que acontece quando paro de pressionar

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pong.getJogadorEsq().setAceleracaoSup(false);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pong.getJogadorEsq().setAceleracaoInf(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_W) {
            pong.getJogadorDir().setAceleracaoSup(false);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S) {
            pong.getJogadorDir().setAceleracaoInf(false);
        }
    }

}