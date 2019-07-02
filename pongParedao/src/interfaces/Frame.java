package interfaces;

import builder.PongParedaoBuilder;
import builders.BolaBuilder;
import builders.JogadorBuilder;
import pong.PongParedao;
import utilitarios.Bola;
import utilitarios.Jogador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {
    private Painel painel;
    private boolean crescente;
    private int janela;
    private Jogador j1;
    private Bola bola;
    private PongParedao pongParedao;

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
                .definirDistParede(5)
                .definirLado(1, 800)
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

    protected void instanciarPong() {
        pongParedao = (PongParedao) PongParedaoBuilder
                .builder()
                .definirLargura(800)
                .definirAltura(600)
                .criarBola(bola)
                .criarJogadores(j1)
                .get();

        // Remove o painel de opções
        painel.setVisible(false);
        remove(painel);

        // Cria o Pong
        pongParedao.setVisible(true);
        setLayout(new BorderLayout());
        add(pongParedao);

        new Thread(() -> pongParedao.iniciarPong()).start();
    }

    public void iniciarJogo() {
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
                    pongParedao = (PongParedao) PongParedaoBuilder.builder().definirTipoJogo(true).get();
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
                    pongParedao = (PongParedao) PongParedaoBuilder.builder().definirTipoJogo(false).get();
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
