package ArvorePV;
public class NoPV  {
    private NoPV  esquerda;
    private NoPV  direita;
    private NoPV  pai;
    private boolean cor; // True = vermelho   ,  False = preto
    private int valor;

    public NoPV(int valor){
        this.cor = true;
        this.valor= valor;
    }

    public NoPV  getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoPV  esquerda) {
        this.esquerda = esquerda;
    }

    public NoPV  getDireita() {
        return direita;
    }

    public void setDireita(NoPV  direita) {
        this.direita = direita;
    }

    public NoPV  getPai() {
        return pai;
    }

    public void setPai(NoPV  pai) {
        this.pai = pai;
    }

    public boolean getCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor= valor;
    }


}
