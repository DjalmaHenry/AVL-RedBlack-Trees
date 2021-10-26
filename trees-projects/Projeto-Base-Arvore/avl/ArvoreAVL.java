package avl;
import base.AbstractArvoreBinariaDePesquisa;

public class ArvoreAVL extends AbstractArvoreBinariaDePesquisa<NoAVL> {

    @Override
    public NoAVL novoNode(int key) {
        return new NoAVL(key);
    }

    @Override
    public NoAVL inserir(int key) {
        NoAVL n =  inserirNoHelper(raiz, key);
        
        corrigirBalanceamento((NoAVL) n.pai, key);

        // rebalancear caso precise
        return n;
    }

    private void corrigirBalanceamento(NoAVL n, int chave) {
        if (chave < n.getChave()){
            int fb = n.getFB();
            if ((fb - 1) == -2){
                NoAVL esq = n.getEsquerda();
                int esqFb = esq.getFB();
                if (esqFb <= 0){
                    //LL
                    //rotacaoSimples Direita
                } else{
                    //LR
                    //rotacaoDupla
                }
            }
        } else{

        }
    }

    @Override
    public NoAVL procurar(int key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NoAVL deletar(int key) {
        // TODO Auto-generated method stub
        return null;
    }
}