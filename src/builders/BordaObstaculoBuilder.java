package builders;

import utilitarios.BordaObstaculo;
import utilitarios.Obstaculo;

public class BordaObstaculoBuilder {
    protected BordaObstaculo bordaObstaculo;

    public BordaObstaculoBuilder() {
        bordaObstaculo = new BordaObstaculo();
    }

    public static BordaObstaculoBuilder builder() {
        return new BordaObstaculoBuilder();
    }

    public BordaObstaculoBuilder criarBordaSuperior(int larguraSup, int alturaSup) {
        this.bordaObstaculo.setBordaSup(
                ObstaculoBuilder
                .builder()
                .definirLargura(larguraSup)
                .definirAltura(alturaSup)
                .definirY(0)
                .definirDistParede(0)
                .get()
        );

        return this;
    }

    public BordaObstaculoBuilder criarBordaInferior(int larguraInf, int alturaInf, int alturaPainel) {
        this.bordaObstaculo.setBordaInf(
                ObstaculoBuilder
                .builder()
                .definirLargura(larguraInf)
                .definirAltura(alturaInf)
                .definirY(alturaPainel - alturaInf - 40)
                .definirDistParede(0)
                .get()
        );

        return this;
    }

    public BordaObstaculoBuilder criarBordaLateral(int larguraLat, int alturaLat, int larguraPainel, int alturaPainel) {
        this.bordaObstaculo.setBordaLatEsqSup(
                ObstaculoBuilder
                .builder()
                .definirLargura(larguraLat)
                .definirAltura(alturaLat)
                .definirY(0)
                .definirDistParede(0)
                .get()
        );

        this.bordaObstaculo.setBordaLatEsqInf(
                ObstaculoBuilder
                .builder()
                .definirLargura(larguraLat)
                .definirAltura(alturaLat)
                .definirY(alturaPainel - alturaLat - 40)
                .definirDistParede(0)
                .get()
        );

        this.bordaObstaculo.setBordaLatDirSup(
                ObstaculoBuilder
                .builder()
                .definirLargura(larguraLat)
                .definirAltura(alturaLat)
                .definirY(0)
                .definirDistParede(larguraPainel - larguraLat)
                .get()
        );

        this.bordaObstaculo.setBordaLatDirInf(
                ObstaculoBuilder
                .builder()
                .definirLargura(larguraLat)
                .definirAltura(alturaLat)
                .definirY(alturaPainel - alturaLat - 40)
                .definirDistParede(larguraPainel - larguraLat)
                .get()
        );

        return this;
    }

    public BordaObstaculo get() {
        return this.bordaObstaculo;
    }
}
