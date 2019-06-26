package builders;

import utilitarios.Obstaculo;

public class ObstaculoImpl extends Obstaculo {
    public ObstaculoImpl(int largura, int altura, int y, int velY, int distParede) {
        super(largura, altura, y, velY, distParede);
    }

    public ObstaculoImpl() {}
}
