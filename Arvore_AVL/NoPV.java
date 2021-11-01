package Arvore_AVL;

public class NoPV {
    private int Info;
    private NoPV pai;
    private NoPV dir;
    private NoPV esq;
    private boolean cor;

    public NoPV(int info) {
        this.Info = info;
        this.cor = true; // true e vermelho.
    }

    public int getInfo() {
        return Info;
    }

    public void setInfo(int info) {
        Info = info;
    }

    public NoPV getPai() {
        return pai;
    }

    public void setPai(NoPV pai) {
        this.pai = pai;
    }

    public NoPV getDir() {
        return dir;
    }

    public void setDir(NoPV dir) {
        this.dir = dir;
    }

    public NoPV getEsq() {
        return esq;
    }

    public void setEsq(NoPV esq) {
        this.esq = esq;
    }

    public boolean isCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }

    public boolean getCor () {
        return this.cor;
    }
}
