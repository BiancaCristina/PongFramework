package interfaces;

import builder.PongFutebolBuilder;
import builders.BolaBuilder;
import builders.BordaObstaculoBuilder;
import builders.JogadorBuilder;
import builders.LinhaObstaculoBuilder;
import pong.PongFutebol;
import utilitarios.Bola;
import utilitarios.BordaObstaculo;
import utilitarios.Jogador;
import utilitarios.LinhaObstaculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {
    private Painel painel;
    private boolean crescente;
    private int janela;
    private Jogador j1;
    private Jogador j2;
    private Bola bola;
    private PongFutebol pongFutebol;
    private LinhaObstaculo linhaObstaculo1;
    private LinhaObstaculo linhaObstaculo2;
    private BordaObstaculo bordaObstaculo;

    public Frame(int largura, int altura) {
        this.janela = 1;

        setSize(largura, altura);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        painel = new Painel(largura, altura);
        addMouseListenerImagens();
        add(painel);
        setVisible(true);
    }

    protected void instanciarJogadores(int tamanhoJogador) {
        j1 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(tamanhoJogador)
                .definirDistParede(40)
                .definirLado(1, 800)
                .definirPosicaoInicial(600)
                .get();

        j2 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(tamanhoJogador)
                .definirDistParede(40)
                .definirLado(2, 800)
                .definirPosicaoInicial(600)
                .get();
    }

    protected void instanciarBola(int velocidadeBola) {
        bola = BolaBuilder
                .builder()
                .definirX(350)
                .definirY(250)
                .definirDimensao(20)
                .definirVelX(velocidadeBola)
                .definirVelY(1)
                .definirCrescente(crescente)
                .get();
    }

    protected void instanciarBorda() {
        bordaObstaculo = BordaObstaculoBuilder
                .builder()
                .criarBordaSuperior(800, 20)
                .criarBordaInferior(800, 20, 600)
                .criarBordaLateral(20, 150, 800, 600)
                .get();
    }

    protected void instanciarLinhaObstaculo() {
        linhaObstaculo1 = LinhaObstaculoBuilder
                .builder()
                .definirLargura(10)
                .definirAltura(60)
                .definirY(5)
                .definirVelY(2)
                .definirDistParede(800-550)
                .criarLinhaObstaculos(600)
                .get();

        linhaObstaculo2 = LinhaObstaculoBuilder
                .builder()
                .definirLargura(10)
                .definirAltura(60)
                .definirY(45)
                .definirVelY(2)
                .definirDistParede(800-250)
                .criarLinhaObstaculos(600)
                .get();
    }

    protected void instanciarPong() {
        pongFutebol = (PongFutebol) PongFutebolBuilder
                .builder()
                .definirLargura(800)
                .definirAltura(600)
                .criarBola(bola)
                .criarJogadores(j1, j2)
                .criarLinhaObstaculos(linhaObstaculo1, linhaObstaculo2)
                .criarBorda(bordaObstaculo)
                .get();

        // Remove o painel de opções
        painel.setVisible(false);
        remove(painel);

        // Cria o Pong
        pongFutebol.setVisible(true);
        setLayout(new BorderLayout());
        add(pongFutebol);

        new Thread(() -> pongFutebol.iniciarPong()).start();
    }

    public void iniciarJogo() {
        instanciarLinhaObstaculo();
        instanciarBorda();
        instanciarPong();
    }

    public void addMouseListenerImagens() {
        painel.escolha1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (janela == 1) {
                    instanciarJogadores(40);
                    painel.escolherCrescente();
                    janela++;
                }

                else if (janela == 2) {
                    crescente = true;
                    painel.escolherVelocidadeBola();
                    janela++;
                }

                else if (janela == 3) {
                    instanciarBola(3);
                    painel.escolherModo();
                    janela++;
                }

                else if (janela == 4) {
                    pongFutebol = (PongFutebol) PongFutebolBuilder.builder().definirTipoJogo(true).get();
                    iniciarJogo();
                }
            }
        });

        painel.escolha2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (janela == 1) {
                    instanciarJogadores(100);
                    painel.escolherCrescente();
                    janela++;
                }

                else if (janela == 2) {
                    crescente = false;
                    painel.escolherVelocidadeBola();
                    janela++;
                }

                else if (janela == 3) {
                    instanciarBola(5);
                    painel.escolherModo();
                    janela++;
                }

                else if (janela == 4) {
                    pongFutebol = (PongFutebol) PongFutebolBuilder.builder().definirTipoJogo(false).get();
                    iniciarJogo();
                }
            }
        });

        painel.escolha3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (janela == 1) {
                    instanciarJogadores(150);
                    painel.escolherCrescente();
                    janela++;
                }

                else if (janela == 3) {
                    instanciarBola(7);
                    painel.escolherModo();
                    janela++;
                }
            }
        });
    }

    public static void main(String[] args) {
        Frame frame = new Frame(800, 600);
    }
}
