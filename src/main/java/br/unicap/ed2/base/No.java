package br.unicap.ed2.base;
public class No {
    private int chave;
    private No esquerda;
    private No direita;
    private No pai;

    public No(int chave) {
        this.chave = chave;
        pai = null;
    }

    public int getChave() {
        return chave;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getPai() {
        return (T) pai;
    }

    public <T extends No> void setPai(T no) {
        pai = no;
    }

    public <T extends No> void setEsquerda( T no) {
        esquerda = no;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getDireita() {
        return (T) direita;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getEsquerda() {
        return (T) esquerda;
    }

    public <T extends No> void setDireita(T no) {
        direita = no;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public String toString(){
        return "No com chave - "+chave;
    }
}