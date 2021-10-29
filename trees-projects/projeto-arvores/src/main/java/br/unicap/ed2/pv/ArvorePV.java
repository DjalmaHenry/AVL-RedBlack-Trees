package br.unicap.ed2.pv;

import br.unicap.ed2.base.AbstractArvoreBinariaDePesquisa;

public class ArvorePV extends AbstractArvoreBinariaDePesquisa<NoPV> {

    @Override
    public NoPV novoNode(int key) {
        //Altera
        return new NoPV(key);
    }

    @Override
    public NoPV inserir(int key) {
        NoPV h = inserirNoHelper(raiz, key);
        if(h == null) return new RedBlackNode<>(data);
        int c = comp.compare(data, h.getData());
        if(c < 0)
        {
            h.setEsquerda(inserir(data, h.getEsquerda()));
        }
        else if(c > 0)
        {
            h.setDireita(inserir(data, h.getDireita()));
        }
        else
        {
            h.setData(data);
        }
        //Now for the rotating
        if(isRed(h.getRight()) && !isRed(h.getLeft()))
        {
            h = rotateLeft(h);
        }
        
        if(isRed(h.getLeft()) && isRed(h.getLeft().getLeft()))
        {
            h = rotateRight(h);
        }
        
        if(isRed(h.getLeft()) && isRed(h.getRight()))
        {
            flipColors(h);
        }
        return h;
    }

    @Override
    public NoPV procurar(int key) {
        return procurarNoHelper(raiz, key);
    }

    @Override
    public void deletar(int key) {
        raiz = deletarNoHelper(raiz, key);
        //alteracao
    }
}