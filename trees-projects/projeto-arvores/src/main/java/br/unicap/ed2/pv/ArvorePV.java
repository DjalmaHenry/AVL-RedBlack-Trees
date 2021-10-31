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
        NoPV n = inserirNoHelper(raiz, key);
        //Altera
        return n;
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