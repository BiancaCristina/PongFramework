package builders;

import utilitarios.Bola;

public interface BolaBuilder {
    BolaBuilder definirDimensao(int dimensao);
    BolaBuilder definirX(int x);
    BolaBuilder definirY(int y);
    BolaBuilder definirVelX(int velX);
    BolaBuilder definirVelY(int velY);
    BolaBuilder definirCrescente(boolean crescente);
    Bola get();
}
