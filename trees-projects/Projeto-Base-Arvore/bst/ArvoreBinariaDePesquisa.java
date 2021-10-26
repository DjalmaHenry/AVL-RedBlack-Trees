package bst;

import base.*;

public class ArvoreBinariaDePesquisa extends AbstractArvoreBinariaDePesquisa<No> {
    @Override
    public No novoNode(int key) {
        //Altera
        return new No(key);
    }

    @Override
    public No inserir(int key) {
        No n =  inserirNoHelper(raiz, key);
        //Altera
        return n;
    }

    @Override
    public No procurar(int key) {
        return procurarNoHelper(raiz, key);
    }

    @Override
    public No deletar(int key) {
        No n =  inserirNoHelper(raiz, key);
        //alteracao
        return n;
    }

    public static void main(String[] args) {
        ArvoreBinariaDePesquisa a = new ArvoreBinariaDePesquisa();
        a.inserir(1);
        a.inserir(2);
        a.inserir(3);
        a.inserir(4);
        
        BinaryTreePrinter<No> p = new BinaryTreePrinter<No>(a);
        p.imprimir(System.out);
    }
}