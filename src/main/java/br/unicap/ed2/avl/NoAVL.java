package br.unicap.ed2.avl;
public class NoAVL {
    private int Info;
    private NoAVL pai;
    private NoAVL dir;
    private NoAVL esq;
    private int balanceamento;

    public NoAVL(int info) {
        Info = info;
    }

    public int getInfo() {
        return Info;
    }

    public void setInfo(int info) {
        Info = info;
    }

    public NoAVL getPai() {
        return pai;
    }

    public void setPai(NoAVL pai) {
        this.pai = pai;
    }

    public NoAVL getDir() {
        return dir;
    }

    public void setDir(NoAVL dir) {
        this.dir = dir;
    }

    public NoAVL getEsq() {
        return esq;
    }

    public void setEsq(NoAVL esq) {
        this.esq = esq;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }
    
}
