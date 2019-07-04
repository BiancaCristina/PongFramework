package interfaces;

import builder.PongFutebolBuilder;
import builders.BordaObstaculoBuilder;
import builders.JogadorBuilder;
import builders.LinhaObstaculoBuilder;
import builders.UtilitariosBuilder;
import template.PongFrame;
import utilitarios.Bola;
import utilitarios.BordaObstaculo;
import utilitarios.Jogador;
import utilitarios.LinhaObstaculo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends PongFrame {
    private Painel painel;
    private boolean crescente;
    private int janela;
    private Jogador j1;
    private Jogador j2;
    private Bola bola;
    private LinhaObstaculo linhaObstaculo1;
    private LinhaObstaculo linhaObstaculo2;
    private BordaObstaculo bordaObstaculo;

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
        j2 = UtilitariosBuilder.builder().criarJogador2(tamanhoJogador);
    }

    public void instanciarBorda() {
        bordaObstaculo = UtilitariosBuilder.builder().criarBorda();
    }

    public void instanciarLinhaObstaculo() {
        linhaObstaculo1 = UtilitariosBuilder.builder().criarLinhaObstaculo1(getHeight(), 250);
        linhaObstaculo2 = UtilitariosBuilder.builder().criarLinhaObstaculo2(getHeight(), 550);
    }

    public void instanciarPong() {
        setPong(PongFutebolBuilder
                .builder()
                .definirLargura(800)
                .definirAltura(600)
                .criarBola(bola)
                .criarJogadores(j1, j2)
                .criarLinhaObstaculos(linhaObstaculo1, linhaObstaculo2)
                .criarBorda(bordaObstaculo)
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
                    bola = instanciarBola(bola,3, crescente);
                    painel.escolherModo();
                    janela++;
                }

                else if (janela == 4) {
                    setPong(PongFutebolBuilder.builder().definirTipoJogo(true).get());
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
                    bola = instanciarBola(bola, 5, crescente);
                    painel.escolherModo();
                    janela++;
                }

                else if (janela == 4) {
                    setPong(PongFutebolBuilder.builder().definirTipoJogo(false).get());
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
