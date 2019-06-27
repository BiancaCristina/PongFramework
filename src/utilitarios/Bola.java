package utilitarios;

import java.awt.*;

public class Bola extends Ponto {
    private boolean crescente;
    private int inicialX;
    private int inicialY;
    private double inicialVelX;
    private double inicialVelY;

    public void desenhar(Graphics g) {
        // Define o tamanho da bola (getLargura()/2 indica o diâmetro)

        g.setColor(Color.white);
        g.fillOval(getX() - getLargura()/2, (int) getY() - getLargura()/2, getLargura(),getLargura());
    }

    public void mover(int alturaPanel) {
        setX(getX() + getVelX());
        setY(getY() + getVelY());

        // Ao atingir a borda superior ou inferior, rebate a bola
        verificaColisao(alturaPanel);
    }

    public void verificaColisao(int alturaPainel) {
        // Colisão com a parede
        if (getY() < 0) setVelY(-getVelY());
        else if (getY() > alturaPainel - getLargura()*2) setVelY(-getVelY());
    }

    public void verificaColisao(Jogador j1, Jogador j2, int larguraPanel) {
        // Verifica a colisão da bola com os jogadores

        int limEsq = j1.getDistParede() + j1.getLargura() + getLargura()/2;
        int limDir = larguraPanel - j2.getDistParede() + getLargura()/2;

        if (getX() <= limEsq) {
            if(getY() >= j1.getY() && getY() <= j1.getY() + j1.getAltura()) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() + 0.2);
            }
        }

        else if (getX() >= larguraPanel - limDir) {
            if(getY() >= j2.getY() && getY() <= j2.getY() + j2.getAltura()) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() - 0.2);
            }
        }
    }

    public void verificaColisao(Jogador j1, int larguraPanel, int alturaPanel) {
        // Verifica colisão do jogador e da parede (usado no PongParedao)

        int limEsq = j1.getDistParede() + j1.getLargura() + getLargura()/2;

        if (getX() <= limEsq) {
            if(getY() >= j1.getY() && getY() <= j1.getY() + j1.getAltura()) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() + 0.2);
            }
        }

        else if (getX() >= larguraPanel) {
            j1.aumentarPontuacao();

            if(getY() >= 0 && getY() <= alturaPanel) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() - 0.2);
            }
        }
    }

    public void verificaColisao(BordaObstaculo bordaObstaculo, int alturaPainel, int larguraPainel) {
        // Cria a borda (pongFutebol)

        Obstaculo bordaSup = bordaObstaculo.getBordaSup();
        Obstaculo bordaInf = bordaObstaculo.getBordaInf();
        Obstaculo bordaLatEsqSup = bordaObstaculo.getBordaLatEsqSup();
        Obstaculo bordaLatEsqInf = bordaObstaculo.getBordaLatEsqInf();
        Obstaculo bordaLatDirSup = bordaObstaculo.getBordaLatDirSup();
        Obstaculo bordaLatDirInf = bordaObstaculo.getBordaLatDirInf();

        // Cria os limites da borda
        int limSup = bordaSup.getAltura();
        int limInf = alturaPainel - bordaInf.getAltura() - getLargura()*2;
        int limEsq = bordaLatEsqSup.getDistParede() + bordaLatEsqSup.getLargura() + getLargura()/2;
        int limDir = larguraPainel - bordaLatDirSup.getDistParede() + getLargura()/2;

        if (getY() < limSup) setVelY(-getVelY());  // Rebate na borda superior
        else if (getY() > limInf) setVelY(-getVelY()); // Rebate na borda inferior

        else if (getX() <= limEsq) {
            if(getY() >= bordaLatEsqSup.getY() && getY() <= bordaLatEsqSup.getY() + bordaLatEsqSup.getAltura()) {
                // Rebate na borda lateral esquerda superior
                setVelX(-getVelX());
            }

            else if (getY() >= bordaLatEsqInf.getY() && getY() <= bordaLatEsqInf.getY() + bordaLatEsqInf.getAltura()) {
                // Rebate na borda lateral esquerda inferior
                setVelX(-getVelX());
            }
        }

        else if (getX() >= larguraPainel - limDir) {
            if (getY() >= bordaLatDirSup.getY() && getY() <= bordaLatDirSup.getY() + bordaLatDirSup.getAltura()) {
                // Rebate na borda lateral direita superior
                setVelX(-getVelX());
            }

            else if (getY() >= bordaLatDirInf.getY() && getY() <= bordaLatDirInf.getY() + bordaLatDirInf.getAltura()) {
                // Rebate na borda lateral direita inferior
                setVelX(-getVelX());
            }
        }
    }

    public void verificaColisao(LinhaObstaculo lo) {
        // Verifica colisão da bola com os obstáculos (usado no PongFutebol)

        int limEsqObs1 = lo.getObstaculo1().getDistParede() - getLargura()/2;
        int limDirObs1 = lo.getObstaculo1().getDistParede() + getLargura()/2;
        int limEsqObs2 = lo.getObstaculo2().getDistParede() - getLargura()/2;
        int limDirObs2 = lo.getObstaculo2().getDistParede() + getLargura()/2;
        int limEsqObs3 = lo.getObstaculo3().getDistParede() - getLargura()/2;
        int limDirObs3 = lo.getObstaculo3().getDistParede() + getLargura()/2;

        if (getX() >= limEsqObs1 && getX() < limDirObs1) {
            if (getY() >= lo.getObstaculo1().getY() && getY() <= lo.getObstaculo1().getY() + lo.getObstaculo1().getAltura()) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() - 0.2); // Aumenta a velocidade
            }
        }

        if (getX() >= limDirObs1 && getX() < limDirObs1 + getLargura()) {
            if (getY() >= lo.getObstaculo1().getY() && getY() <= lo.getObstaculo1().getY() + lo.getObstaculo1().getAltura()) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() - 0.2); // Aumenta a velocidade
            }
        }

        if (getX() >= limEsqObs2 && getX() < limDirObs2) {
            if (getY() >= lo.getObstaculo2().getY() && getY() < lo.getObstaculo2().getY() + lo.getObstaculo2().getAltura()) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() - 0.2); // Aumenta a velocidade
            }
        }

        if (getX() >= limDirObs2 && getX() < limDirObs2 + getLargura()) {
            if ( getY() >= lo.getObstaculo2().getY() && getY() <= lo.getObstaculo2().getY() + lo.getObstaculo2().getAltura()) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() - 0.2); // Aumenta a velocidade
            }
        }

        if (getX() >= limEsqObs3 && getX() < limDirObs3) {
            if (getY() >= lo.getObstaculo3().getY() && getY() < lo.getObstaculo3().getY() + lo.getObstaculo3().getAltura()) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() - 0.2); // Aumenta a velocidade
            }
        }

        if (getX() >= limDirObs3 && getX() < limDirObs3 + getLargura()) {
            if (getY() >= lo.getObstaculo3().getY() && getY() <= lo.getObstaculo3().getY() + lo.getObstaculo3().getAltura()) {
                setVelX(-getVelX());
                if (crescente) setVelX(getVelX() - 0.2); // Aumenta a velocidade
            }
        }
    }

    public void reiniciar() {
        setX(inicialX);
        setY(inicialY);
        setVelX(inicialVelX);
        setVelY(inicialVelY);
    }

    public boolean isCrescente() {
        return crescente;
    }

    public void setCrescente(boolean crescente) {
        this.crescente = crescente;
    }

    public int getInicialX() {
        return inicialX;
    }

    public void setInicialX(int inicialX) {
        this.inicialX = inicialX;
    }

    public int getInicialY() {
        return inicialY;
    }

    public void setInicialY(int inicialY) {
        this.inicialY = inicialY;
    }

    public double getInicialVelX() {
        return inicialVelX;
    }

    public void setInicialVelX(double inicialVelX) {
        this.inicialVelX = inicialVelX;
    }

    public double getInicialVelY() {
        return inicialVelY;
    }

    public void setInicialVelY(double inicialVelY) {
        this.inicialVelY = inicialVelY;
    }
}
