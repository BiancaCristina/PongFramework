package interfaces;

import builder.PongParedaoBuilder;
import builders.UtilitariosBuilder;
import pong.PongParedao;
import template.PongFrame;
import utilitarios.Bola;
import utilitarios.Jogador;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends PongFrame {
    private Painel painel;
    private boolean crescente;
    private int janela;
    private Jogador j1;
    private Bola bola;

    public Frame(int largura, int altura) {
        super(largura, altura);
        this.janela = 1;

        painel = new Painel(largura, altura);
        addMouseListenerImagens();
        add(painel);
        setVisible(true);
    }

    public void instanciarJogadores(int tamanhoJogador) {
        j1 = UtilitariosBuilder.builder().criarJogador1(tamanhoJogador);
    }

    public void instanciarPong() {
        setPong(PongParedaoBuilder
                .builder()
                .definirLargura(800)
                .definirAltura(600)
                .criarBola(bola)
                .criarJogadores(j1)
                .get());

        // Remove o painel de opções
        painel.setVisible(false);
        remove(painel);

        // Cria o Pong
        getPong().setVisible(true);
        setLayout(new BorderLayout());
        add(getPong());

        new Thread(() -> getPong().iniciarPong()).start();
    }

    @Override
    public void instanciarBorda() {

    }

    @Override
    public void instanciarLinhaObstaculo() {

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
                    bola = instanciarBola(bola,3, crescente);
                    painel.escolherModo();
                    janela++;
                }

                else if (janela == 4) {
                    setPong(PongParedaoBuilder.builder().definirTipoJogo(true).get());
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
                    bola = instanciarBola(bola,5, crescente);
                    painel.escolherModo();
                    janela++;
                }

                else if (janela == 4) {
                    setPong(PongParedaoBuilder.builder().definirTipoJogo(false).get());
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
                    bola = instanciarBola(bola,7, crescente);
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
