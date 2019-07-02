package pong;

import builder.PongFutebolBuilder;
import builders.BolaBuilder;
import builders.BordaObstaculoBuilder;
import builders.JogadorBuilder;
import builders.LinhaObstaculoBuilder;
import interfaces.PongFrame;
import utilitarios.Bola;
import utilitarios.BordaObstaculo;
import utilitarios.Jogador;
import utilitarios.LinhaObstaculo;

public class Main {
    PongFrame pongFrame;
    PongFutebol pongFutebol;

    public Main() {
        Jogador j1 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(150)
                .definirDistParede(40)
                .definirLado(1, 800)
                .definirPosicaoInicial(600)
                .get();

        Jogador j2 = JogadorBuilder
                .builder()
                .definirLargura(20)
                .definirAltura(150)
                .definirDistParede(40)
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

        BordaObstaculo bordaObstaculo = BordaObstaculoBuilder
                .builder()
                .criarBordaSuperior(800, 20)
                .criarBordaInferior(800, 20, 600)
                .criarBordaLateral(20, 150, 800, 600)
                .get();

        LinhaObstaculo linhaObstaculo1 = LinhaObstaculoBuilder
                .builder()
                .definirLargura(10)
                .definirAltura(60)
                .definirY(5)
                .definirVelY(2)
                .definirDistParede(800-550)
                .criarLinhaObstaculos(600)
                .get();

        LinhaObstaculo linhaObstaculo2 = LinhaObstaculoBuilder
                .builder()
                .definirLargura(10)
                .definirAltura(60)
                .definirY(45)
                .definirVelY(2)
                .definirDistParede(800-250)
                .criarLinhaObstaculos(600)
                .get();

        pongFutebol = (PongFutebol) PongFutebolBuilder
                .builder()
                .definirLargura(800)
                .definirAltura(600)
                .definirTipoJogo(false)
                .criarBola(b)
                .criarJogadores(j1, j2)
                .criarLinhaObstaculos(linhaObstaculo1, linhaObstaculo2)
                .criarBorda(bordaObstaculo)
                .get();

        pongFrame = new PongFrame(800, 600, pongFutebol);
    }

    public static void main(String[] args) {
        Main main = new Main();

        new Thread(() -> main.pongFutebol.iniciarPong()).start();
    }
}