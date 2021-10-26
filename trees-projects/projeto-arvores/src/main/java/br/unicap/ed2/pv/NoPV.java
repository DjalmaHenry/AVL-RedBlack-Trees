package br.unicap.ed2.pv;

import br.unicap.ed2.base.No;

public class NoPV extends No {

    private int fatorBalanceamento;

    public NoPV(int chave) {
        super(chave);
        fatorBalanceamento = 0;
    }

    public int getFB() {
        return fatorBalanceamento;
    }
    
}
