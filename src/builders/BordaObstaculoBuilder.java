package builders;

import utilitarios.BordaObstaculo;

public interface BordaObstaculoBuilder {
    BordaObstaculoBuilder criarBordaSuperior(int larguraSup, int alturaSup);
    BordaObstaculoBuilder criarBordaInferior(int larguraInf, int alturaInf, int alturaPainel);
    BordaObstaculoBuilder criarBordaLateral(int larguraLat, int alturaLat, int larguraPainel, int alturaPainel);
    BordaObstaculo get();
}
