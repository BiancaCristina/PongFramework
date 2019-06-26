package pong;

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
                atualizarPontuacao(getJogadorDir());
            }

            else if (getBola().getX() > 810) {
                atualizarPontuacao(getJogadorEsq());
            }

            else {
                getJogadorEsq().desenhar(g2d);
                getJogadorDir().desenhar(g2d);
                getBola().desenhar(g2d);
            }
        }

        Graphics2D g2dComponent = (Graphics2D)g;
        g2dComponent.drawImage(bufferedImage, null, 0,0);

    }

    public void iniciarPong() {
        while(!isAcabou()) {
            getJogadorEsq().mover(getAltura());
            getJogadorDir().mover(getAltura());
            getBola().mover(getAltura());
            getBola().verificaColisao(getJogadorEsq(), getJogadorDir(), getLargura());

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
}
