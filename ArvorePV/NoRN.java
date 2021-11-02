package ArvorePV;

public class NoRN implements Comparable<NoRN> {
    private NoRN esquerda;
    private NoRN direita;
    private NoRN pai;
    private boolean cor; // True = vermelho , False = preto
    private int elemento;

    public NoRN(int elemento) {
        this.cor = true;
        this.elemento = elemento;
    }

    public NoRN getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoRN esquerda) {
        this.esquerda = esquerda;
    }

    public NoRN getDireita() {
        return direita;
    }

    public void setDireita(NoRN direita) {
        this.direita = direita;
    }

    public NoRN getPai() {
        return pai;
    }

    public void setPai(NoRN pai) {
        this.pai = pai;
    }

    public boolean getCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public int compareTo(NoRN no) {
        if (this.elemento == no.elemento)
            return 0;
        else if (this.elemento > no.elemento)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Elemento: " + this.elemento + " Cor: " + this.cor;
    }
}
