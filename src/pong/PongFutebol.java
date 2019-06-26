package pong;

import utilitarios.Bola;
import utilitarios.BordaObstaculo;
import utilitarios.Jogador;
import utilitarios.LinhaObstaculo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PongFutebol extends Pong {
    LinhaObstaculo linhaObstaculo1;
    LinhaObstaculo linhaObstaculo2;
    BordaObstaculo bordaObstaculo;

    public PongFutebol(Jogador j1, Jogador j2, Bola b, boolean tipoJogo, int largura, int altura) {
        super(j1, b, tipoJogo, largura, altura);
        this.setJ2(j2);

        linhaObstaculo1 = new LinhaObstaculo(10, 60, altura, 5, 2, largura - 550);
        linhaObstaculo2 = new LinhaObstaculo(10, 60, altura, 45, 2, largura - 250);
        bordaObstaculo = new BordaObstaculo(largura, largura, 20,largura,20, 20, 150,altura);
        setVisible(true);
    }

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
            if (getB().getX() < -10) {
                atualizarPontuacao(getJ2());
            }

            else if (getB().getX() > 810) {
                atualizarPontuacao(getJ1());
            }

            else {
                getJ1().desenhar(g2d);
                getJ2().desenhar(g2d);
                getB().desenhar(g2d);
                linhaObstaculo1.desenhar(g2d);
                linhaObstaculo2.desenhar(g2d);
                bordaObstaculo.desenhar(g2d);
            }
        }

        Graphics2D g2dComponent = (Graphics2D)g;
        g2dComponent.drawImage(bufferedImage, null, 0,0);
    }

    @Override
    public void iniciarPong() {
        while(!isAcabou()) {
            getJ1().mover(getAltura() - bordaObstaculo.getBordaSup().getAltura());
            getJ2().mover(getAltura() - bordaObstaculo.getBordaSup().getAltura());
            getB().mover(getAltura());
            getB().verificaColisao(getJ1(), getJ2(), getLargura());
            getB().verificaColisao(bordaObstaculo, getAltura(), getLargura());
            getB().verificaColisao(linhaObstaculo1);
            getB().verificaColisao(linhaObstaculo2);
            linhaObstaculo1.mover(getAltura() - bordaObstaculo.getBordaSup().getAltura());
            linhaObstaculo2.mover(getAltura() - bordaObstaculo.getBordaSup().getAltura());
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
