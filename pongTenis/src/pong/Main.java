package pong;

import builder.PongTenisBuilder;
import builders.BolaBuilder;
import builders.JogadorBuilder;
import interfaces.PongFrame;
import utilitarios.Bola;
import utilitarios.Jogador;

public class Main {
    PongFrame pongFrame;
    PongTenis pongTenis;

    public Main() {
        Jogador j1 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(150)
                .definirDistParede(5)
                .definirLado(1, 800)
                .definirPosicaoInicial(600)
                .get();

        Jogador j2 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(150)
                .definirDistParede(5)
                .definirLado(2, 800)
                .definirPosicaoInicial(600)
                .get();

        Bola b = BolaBuilder
                .builder()
                .definirX(350)
                .definirY(250)
                .definirDimensao(20)
                .definirVelX(-3)
                .definirVelY(1)
                .definirCrescente(true)
                .get();


        pongTenis = (PongTenis) PongTenisBuilder
                .builder()
                .definirLargura(800)
                .definirAltura(600)
                .definirTipoJogo(false)
                .criarBola(b)
                .criarJogadores(j1, j2)
                .get();

        pongFrame = new PongFrame(800, 600, pongTenis);
    }

    public static void main(String[] args) {
        Main main = new Main();

        new Thread(() -> main.pongTenis.iniciarPong()).start();
    }
}
