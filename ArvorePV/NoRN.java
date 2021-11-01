package ArvorePV;

public class NoRN extends Comparable <int> {
    private NoRN  esquerda;
    private NoRN  direita;
    private NoRN  pai;
    private boolean cor; // True = vermelho   ,  False = preto
    private int elemento;

    public NoRN(int elemento){
        this.cor = true;
        this.elemento = elemento;
    }

    public NoRN  getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoRN  esquerda) {
        this.esquerda = esquerda;
    }

    public NoRN  getDireita() {
        return direita;
    }

    public void setDireita(NoRN  direita) {
        this.direita = direita;
    }

    public NoRN  getPai() {
        return pai;
    }

    public void setPai(NoRN  pai) {
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

    public int compareTo(int elemento){
        return this.elemento.compareTo(elemento);
    }

    @Override
    public String toString(){
        if(this.cor){
           return this.elemento.toString() + " / Cor: Vermelho";
        }
        else{
            return this.elemento.toString() + " / Cor: Preto";
        }
    }
}
