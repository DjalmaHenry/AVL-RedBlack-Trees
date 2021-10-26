package avl;
import base.No;

public class NoAVL extends No {

    private int fatorBalanceamento;

    public NoAVL(int chave) {
        super(chave);
        fatorBalanceamento = 0;
    }

    public int getFB() {
        return fatorBalanceamento;
    }
    
}
