package builders;

import utilitarios.LinhaObstaculo;

public interface LinhaObstaculoBuilder {

    LinhaObstaculoBuilder definirLargura();
    LinhaObstaculoBuilder definirAltura();
    LinhaObstaculoBuilder definirY(int y);
    LinhaObstaculoBuilder definirVelY(int velY);
    LinhaObstaculoBuilder definirDistParede(int distParede);
    LinhaObstaculoBuilder criarLinhaObstaculos(int alturaPainel);
    LinhaObstaculo get();

}
