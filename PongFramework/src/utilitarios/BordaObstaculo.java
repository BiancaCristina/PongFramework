package utilitarios;

import java.awt.*;

public class BordaObstaculo {
    private Obstaculo bordaSup;
    private Obstaculo bordaInf;
    private Obstaculo bordaLatEsqSup;
    private Obstaculo bordaLatEsqInf;
    private Obstaculo bordaLatDirSup;
    private Obstaculo bordaLatDirInf;

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

