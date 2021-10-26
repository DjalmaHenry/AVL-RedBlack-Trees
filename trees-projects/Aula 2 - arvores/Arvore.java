public class Arvore {

    No raiz;

    public void inserirEmArvore (int valor){
        if (raiz == null){
            raiz = new No();
            raiz.info = valor;
            return;
        }
        inserirEmNo(raiz, valor);
    }

    private void inserirEmNo(No no, int valor) {
        if (valor > no.info ){
            //inserir na direita
            if (no.direita == null){
                No aux = new No();
                aux.info = valor;
                no.direita = aux;
                return;
            } else {
                inserirEmNo(no.direita, valor);
            }
        } else {
            //inserir na esquerda
            if (no.esquerda == null){
                No aux = new No();
                aux.info = valor;
                no.esquerda = aux;
                return;
            } else {
                inserirEmNo(no.esquerda, valor);
            }
        }
    }

    public boolean consultarEmArvore (int valor){
        if (raiz == null){
            return false;
        }
        return consultarEmNo(raiz, valor);
    }

    private boolean consultarEmNo (No n, int valor){
        if (n.info == valor){
            return true;
        }
        if (valor > n.info){
            if (n.direita == null){
                return false;
            }
            return consultarEmNo(n.direita,valor);
        } else {
            if (n.esquerda == null){
                return false;
            }
            return consultarEmNo(n.esquerda,valor);
        }
    }

    private No removerEmNo(No raiz2, int valor) {
        return null;
    }

    public static void main(String[] args) {
        
    }
}
