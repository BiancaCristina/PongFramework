package pong;

import template.Pong;
import utilitarios.Jogador;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PongTenis extends Pong {
    @Override
    public void paintComponent(Graphics g) {
        BufferedImage bufferedImage = new BufferedImage(getLargura(), getAltura(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getLargura(), getAltura());

        if (isAcabou() && isTipoJogo()) {
            g2d.setColor(Color.RED);
            g2d.drawString("Fim de jogo!", 350, 250);
        }

        else {
            // Caso o jogo não tenha acabado ainda
            if (getBola().getX() < -10) {
                atualizarPontuacao(getJogador2());
            }

            else if (getBola().getX() > 810) {
                atualizarPontuacao(getJogador1());
            }

            else {
                getJogador1().desenhar(g2d);
                getJogador2().desenhar(g2d);
                getBola().desenhar(g2d);
            }
        }

        Graphics2D g2dComponent = (Graphics2D)g;
        g2dComponent.drawImage(bufferedImage, null, 0,0);

    }

    @Override
    public void atualizarPontuacao(Jogador j) {
        j.aumentarPontuacao();

        if (j.getPontuacao() > 3 && isTipoJogo()) {
            setAcabou(true);
            return;
        }

        getBola().reiniciar();
    }

    public void iniciarPong() {
        while(!isAcabou()) {
            getJogador1().mover(getAltura());
            getJogador2().mover(getAltura());
            getBola().mover(getAltura());
            getBola().verificaColisao(getJogador1(), getJogador2(), getLargura());

            repaint();

            try {
                Thread.sleep(10);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Printa que o jogo isAcabou()
        repaint();
    }
}