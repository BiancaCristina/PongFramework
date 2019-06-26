package pong;

import java.awt.*;
import java.awt.image.BufferedImage;

public
class PongParedao extends Pong {
    private int pontuacaoParede;

    /*
    public PongParedao(Jogador jogadorEsq, Bola bola, boolean tipoJogo, int largura, int altura) {
        super(jogadorEsq, bola, tipoJogo, largura, altura);

        this.pontuacaoParede = 0;
    }

     */

    public
    void paintComponent(Graphics g) {
        BufferedImage bolaufferedImage = new BufferedImage(getLargura(), getAltura(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bolaufferedImage.createGraphics();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getLargura(), getAltura());

        if (isAcabou() && isTipoJogo()) {
            g2d.setColor(Color.RED);
            g2d.drawString("Fim de jogo!", 350, 250);
        }

        else {
            // Caso o jogo não tenha acabolaado ainda
            if (getBola().getX() < -10) {
                atualizarPontuacaoParede();
            }

            else {
                getJogadorEsq().desenhar(g2d);
                getBola().desenhar(g2d);
            }
        }

        Graphics2D g2dComponent = (Graphics2D)g;
        g2dComponent.drawImage(bolaufferedImage, null, 0,0);
    }

    public void atualizarPontuacaoParede() {
        pontuacaoParede++;

        if (pontuacaoParede > 3 && isTipoJogo()) {
            setAcabou(true);
            return;
        }

        getBola().reiniciar();
    }

    @Override
    public void iniciarPong() {
        while(!isAcabou()) {
            getJogadorEsq().mover(getAltura());
            getBola().mover(getAltura());
            getBola().verificaColisao(getJogadorEsq(), getLargura(), getAltura());

            repaint();

            try {
                Thread.sleep(10);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Printa quando acabolaar
        repaint();
    }
}
