package interfaces;

import javax.swing.*;
import java.awt.*;

public class Painel extends JPanel{
    JLabel escolha1;
    JLabel escolha2;
    JLabel escolha3;


    public Painel(int largura, int altura) {
        criarLabelsEscolha();
        setSize(largura, altura);
        setLayout(null);
        setVisible(true);
    }

    public void criarLabelsEscolha() {
        ImageIcon img1 = new ImageIcon("src/imagens/jogadorPequeno.png");
        ImageIcon img2 = new ImageIcon("src/imagens/jogadorMedio.png");
        ImageIcon img3 = new ImageIcon("src/imagens/jogadorGrande.png");

        escolha1 = new JLabel(img1);
        escolha2 = new JLabel(img2);
        escolha3 = new JLabel(img3);

        escolha1.setBounds(200, 100, img1.getIconWidth(), img1.getIconHeight());
        escolha2.setBounds(200, 250, img2.getIconWidth(), img2.getIconHeight());
        escolha3.setBounds(200, 400, img3.getIconWidth(), img3.getIconHeight());

        add(escolha1);
        add(escolha2);
        add(escolha3);
    }

    public void escolherCrescente() {
        ImageIcon img1 = new ImageIcon("src/imagens/velocidadeCrescente.png");
        ImageIcon img2 = new ImageIcon("src/imagens/velocidadeEstatica.png");

        escolha1.setIcon(img1);
        escolha2.setIcon(img2);

        escolha1.setBounds(100, 150, img1.getIconWidth(), img1.getIconHeight());
        escolha2.setBounds(100, 300, img2.getIconWidth(), img2.getIconHeight());

        escolha3.setVisible(false);
    }

    public void escolherVelocidadeBola() {
        ImageIcon img1 = new ImageIcon("src/imagens/bolaLenta.png");
        ImageIcon img2 = new ImageIcon("src/imagens/bolaNormal.png");
        ImageIcon img3 = new ImageIcon("src/imagens/bolaRapida.png");

        escolha1.setIcon(img1);
        escolha2.setIcon(img2);
        escolha3.setIcon(img3);

        escolha1.setBounds(250, 100, img1.getIconWidth(), img1.getIconHeight());
        escolha2.setBounds(250, 250, img2.getIconWidth(), img2.getIconHeight());
        escolha3.setBounds(250, 400, img3.getIconWidth(), img3.getIconHeight());

        escolha3.setVisible(true);
    }

    public void escolherModo() {
        ImageIcon img1 = new ImageIcon("src/imagens/modoJogo.png");
        ImageIcon img2 = new ImageIcon("src/imagens/modoTreino.png");

        escolha1.setIcon(img1);
        escolha2.setIcon(img2);

        escolha1.setBounds(300, 200, img1.getIconWidth(), img1.getIconHeight());
        escolha2.setBounds(300, 400, img2.getIconWidth(), img2.getIconHeight());

        escolha3.setVisible(false);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, getWidth(), getHeight());
    }


}
