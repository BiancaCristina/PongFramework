package utilitarios;

import java.awt.*;

public class Jogador extends Ponto{
    private boolean aceleracaoSup;
    private boolean aceleracaoInf;
    private int pontuacao;

    public void desenhar(Graphics g) {
        // Define as dimensões do jogador

        g.setColor(Color.white);
        g.fillRect(getDistParede(), getY(), getLargura(), getAltura());
    }

    public void mover(int alturaPanel) {
        if (isAceleracaoSup()) setVelY(getVelY() - 2);
        else if (isAceleracaoInf()) setVelY(getVelY() + 2);
        else if (!isAceleracaoSup() && !isAceleracaoInf()) setVelY(getVelY() * getGRAVIDADE());

        // Limita a velocidade dos jogadores
        if (getVelY() >= 5) setVelY(5);
        else if (getVelY() <= -5) setVelY(-5);

        // Impede que o jogador ultrapasse as bordas superiores ou inferiores
        setY(getY() + getVelY());
        if (getY() < 5) setY(5);
        if (getY() > alturaPanel - getAltura() - 40) setY(alturaPanel - getAltura() - 40);
    }

    public void setAceleracaoSup(boolean aceleracaoSup) {
        this.aceleracaoSup = aceleracaoSup;
    }

    public void setAceleracaoInf(boolean aceleracaoInf) {
        this.aceleracaoInf = aceleracaoInf;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void aumentarPontuacao() {
        this.setPontuacao(this.getPontuacao() + 1);
    }

    public boolean isAceleracaoSup() {
        return aceleracaoSup;
    }

    public boolean isAceleracaoInf() {
        return aceleracaoInf;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
