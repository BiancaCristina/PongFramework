package utilitarios;

import java.awt.*;

public class BordaObstaculo {
    private Obstaculo bordaSup;
    private Obstaculo bordaInf;
    private Obstaculo bordaLatEsqSup;
    private Obstaculo bordaLatEsqInf;
    private Obstaculo bordaLatDirSup;
    private Obstaculo bordaLatDirInf;

    public BordaObstaculo(
            int larguraSup,
            int larguraInf,
            int larguraLat,
            int larguraPainel,
            int alturaSup,
            int alturaInf,
            int alturaLat,
            int alturaPainel
    ) {
        setBordaSup(new Obstaculo(larguraSup, alturaSup, 0, 0));
        setBordaInf(new Obstaculo(larguraInf, alturaInf, alturaPainel - alturaInf - 40, 0));
        setBordaLatEsqSup(new Obstaculo(larguraLat, alturaLat, 0, 0));
        setBordaLatEsqInf(new Obstaculo(larguraLat, alturaLat, alturaPainel - alturaLat - 40, 0));
        setBordaLatDirSup(new Obstaculo(larguraLat, alturaLat, 0, larguraPainel - larguraLat));
        setBordaLatDirInf(new Obstaculo(larguraLat, alturaLat, alturaPainel - alturaLat - 40, larguraPainel - larguraLat));
    }

    public void desenhar(Graphics g) {
        getBordaSup().desenhar(g);
        getBordaInf().desenhar(g);
        getBordaLatEsqSup().desenhar(g);
        getBordaLatEsqInf().desenhar(g);
        getBordaLatDirSup().desenhar(g);
        getBordaLatDirInf().desenhar(g);
    }

    public Obstaculo getBordaSup() {
        return bordaSup;
    }

    public void setBordaSup(Obstaculo bordaSup) {
        this.bordaSup = bordaSup;
    }

    public Obstaculo getBordaInf() {
        return bordaInf;
    }

    public void setBordaInf(Obstaculo bordaInf) {
        this.bordaInf = bordaInf;
    }

    public Obstaculo getBordaLatEsqSup() {
        return bordaLatEsqSup;
    }

    public void setBordaLatEsqSup(Obstaculo bordaLatEsqSup) {
        this.bordaLatEsqSup = bordaLatEsqSup;
    }

    public Obstaculo getBordaLatEsqInf() {
        return bordaLatEsqInf;
    }

    public void setBordaLatEsqInf(Obstaculo bordaLatEsqInf) {
        this.bordaLatEsqInf = bordaLatEsqInf;
    }

    public Obstaculo getBordaLatDirSup() {
        return bordaLatDirSup;
    }

    public void setBordaLatDirSup(Obstaculo bordaLatDirSup) {
        this.bordaLatDirSup = bordaLatDirSup;
    }

    public Obstaculo getBordaLatDirInf() {
        return bordaLatDirInf;
    }

    public void setBordaLatDirInf(Obstaculo bordaLatDirInf) {
        this.bordaLatDirInf = bordaLatDirInf;
    }
}

