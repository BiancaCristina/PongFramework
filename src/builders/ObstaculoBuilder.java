package builders;

import utilitarios.Obstaculo;

public interface ObstaculoBuilder {
    ObstaculoBuilder definirLargura(int largura);
    ObstaculoBuilder definirAltura(int altura);
    ObstaculoBuilder definirY(int y);
    ObstaculoBuilder definirVelY(int velY);
    ObstaculoBuilder definirDistParede(int distParede);
    Obstaculo get();
}
