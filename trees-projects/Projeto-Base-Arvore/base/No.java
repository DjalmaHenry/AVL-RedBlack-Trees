package base;
public class No {
    private int chave;
    public No esquerda;
    public No direita;
    public No pai;

    public No(int chave) {
        this.chave = chave;
    }

    public int getChave() {
        return chave;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getEsquerda() {
        return (T) esquerda;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getDireita() {
        return (T) direita;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }
}