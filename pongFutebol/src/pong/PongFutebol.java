package pong;

import template.Pong;
import utilitarios.BordaObstaculo;
import utilitarios.Jogador;
import utilitarios.LinhaObstaculo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PongFutebol extends Pong {
    private LinhaObstaculo linhaObstaculoEsq;
    private LinhaObstaculo linhaObstaculoDir;
    private BordaObstaculo bordaObstaculo;

    public void paintComponent(Graphics g) {
        BufferedImage bufferedImage = new BufferedImage(getLargura(), getAltura(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getLargura(), getAltura());

        if (isAcabou() && isTipoJogo()) {
            // Apenas encerra a partida caso não seja modo treino
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
                getLinhaObstaculoEsq().desenhar(g2d);
                getLinhaObstaculoDir().desenhar(g2d);
                getBordaObstaculo().desenhar(g2d);
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

    @Override
    public void iniciarPong() {
        while(!isAcabou()) {
            getJogador1().mover(getAltura() - getBordaObstaculo().getBordaSup().getAltura());
            getJogador2().mover(getAltura() - getBordaObstaculo().getBordaSup().getAltura());
            getBola().mover(getAltura());
            getBola().verificaColisao(getJogador1(), getJogador2(), getLargura());
            getBola().verificaColisao(getBordaObstaculo(), getAltura(), getLargura());
            getBola().verificaColisao(getLinhaObstaculoEsq());
            getBola().verificaColisao(getLinhaObstaculoDir());
            getLinhaObstaculoEsq().mover(getAltura() - getBordaObstaculo().getBordaSup().getAltura());
            getLinhaObstaculoDir().mover(getAltura() - getBordaObstaculo().getBordaSup().getAltura());
            repaint();

            try {
                Thread.sleep(10);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Printa que o jogo acabou
        repaint();
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
