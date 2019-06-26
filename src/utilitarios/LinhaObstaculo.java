package utilitarios;

import builders.ObstaculoBuilder;

import java.awt.*;

public abstract class LinhaObstaculo extends Ponto {
    private Obstaculo obstaculo1;
    private Obstaculo obstaculo2;
    private Obstaculo obstaculo3;

    @Override
    public void desenhar(Graphics g) {
        getObstaculo1().desenhar(g);
        getObstaculo2().desenhar(g);
        getObstaculo3().desenhar(g);
    }

    @Override
    public void mover(int alturaPanel) {
        getObstaculo1().mover(alturaPanel);
        getObstaculo2().mover(alturaPanel);
        getObstaculo3().mover(alturaPanel);

        if (getObstaculo3().getY() > alturaPanel - getAltura() - 40) inverterVelocidades();
        else if (getObstaculo1().getY() < 5) inverterVelocidades();
    }

    public void inverterVelocidades() {
        getObstaculo1().setVelY(-getObstaculo1().getVelY());
        getObstaculo2().setVelY(-getObstaculo2().getVelY());
        getObstaculo3().setVelY(-getObstaculo3().getVelY());
    }

    public Obstaculo getObstaculo1() {
        return obstaculo1;
    }

    public void setObstaculo1(Obstaculo obstaculo1) {
        this.obstaculo1 = obstaculo1;
    }

    public Obstaculo getObstaculo2() {
        return obstaculo2;
    }

    public void setObstaculo2(Obstaculo obstaculo2) {
        this.obstaculo2 = obstaculo2;
    }

    public Obstaculo getObstaculo3() {
        return obstaculo3;
    }

    public void setObstaculo3(Obstaculo obstaculo3) {
        this.obstaculo3 = obstaculo3;
    }
}
