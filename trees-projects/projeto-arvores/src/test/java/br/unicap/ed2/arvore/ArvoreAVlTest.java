package br.unicap.ed2.arvore;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.unicap.ed2.avl.NoAVL;
import br.unicap.ed2.avl.AVL;

public class ArvoreAVlTest {

    @Test
    public void testaLLRaiz() {
        AVL a = new AVL();
        a.inserir(3, a.getRaiz());
        a.inserir(2, a.getRaiz());
        a.inserir(1, a.getRaiz());
        NoAVL aux = a.procurar(2, a.getRaiz());
        assertTrue(aux != null);
        NoAVL auxDir = aux.getDir();
        NoAVL auxEsq = aux.getEsq();
        assertTrue(auxEsq != null);
        assertTrue(auxEsq.getInfo() == 1);
        assertTrue(auxDir != null);
        assertTrue(auxDir.getInfo() == 3);
        assertTrue(a.ehRaiz(2));

    }

    @Test
    public void testaLLMeio() {
        AVL a = new AVL();
        a.inserir(10, a.getRaiz());
        a.inserir(20, a.getRaiz());
        a.inserir(5, a.getRaiz());
        a.inserir(4, a.getRaiz());
        a.inserir(7, a.getRaiz());
        a.inserir(30, a.getRaiz());
        a.inserir(15, a.getRaiz());
        a.inserir(2, a.getRaiz());
        a.inserir(1, a.getRaiz());
        NoAVL aux = a.procurar(2, a.getRaiz());
        assertTrue(aux != null);
        NoAVL auxDir = aux.getDir();
        NoAVL auxEsq = aux.getEsq();
        assertTrue(auxEsq != null);
        assertTrue(auxEsq.getInfo() == 1);
        assertTrue(auxDir != null);
        assertTrue(auxDir.getInfo() == 4);

    }

    @Test
    public void testaRR2Raiz() {
        AVL a = new AVL();
        a.inserir(1, a.getRaiz());
        a.inserir(2, a.getRaiz());
        a.inserir(3, a.getRaiz());
        NoAVL aux = a.procurar(2, a.getRaiz());
        assertTrue(aux != null);
        NoAVL auxDir = aux.getDir();
        NoAVL auxEsq = aux.getEsq();
        assertTrue(auxEsq != null);
        assertTrue(auxEsq.getInfo() == 1);
        assertTrue(auxDir != null);
        assertTrue(auxDir.getInfo() == 3);
        assertTrue(a.ehRaiz(2));

    }

    @Test
    public void testaRRMeio() {
        AVL a = new AVL();
        a.inserir(50, a.getRaiz());
        a.inserir(10, a.getRaiz());
        a.inserir(60, a.getRaiz());
        a.inserir(20, a.getRaiz());
        a.inserir(5, a.getRaiz());
        a.inserir(70, a.getRaiz());
        a.inserir(40, a.getRaiz());
        // Professor após a insercção do 80 o nó 60 fica desbalanceado (2),
        // então se faz necessário uma rotação a esquerda
        a.inserir(80, a.getRaiz());
        a.inserir(90, a.getRaiz());
        // Enfim, o 80 fica só com a subárvore a direita que é o 90
        NoAVL aux = a.procurar(80, a.getRaiz());
        assertTrue(aux != null);
        NoAVL auxDir = aux.getDir();
        NoAVL auxEsq = aux.getEsq();
        // assertTrue(auxEsq != null);
        // assertTrue(auxEsq.getInfo() == 70);
        assertTrue(auxDir != null);
        assertTrue(auxDir.getInfo() == 90);

    }

    @Test
    public void testaLRMeio() {
        AVL a = new AVL();
        a.inserir(10, a.getRaiz());
        a.inserir(20, a.getRaiz());
        a.inserir(5, a.getRaiz());
        a.inserir(4, a.getRaiz());
        a.inserir(7, a.getRaiz());
        a.inserir(30, a.getRaiz());
        a.inserir(15, a.getRaiz());
        a.inserir(2, a.getRaiz());
        a.inserir(3, a.getRaiz());

        NoAVL aux = a.procurar(3, a.getRaiz());
        assertTrue(aux != null);
        NoAVL auxDir = aux.getDir();
        NoAVL auxEsq = aux.getEsq();
        assertTrue(auxEsq != null);
        assertTrue(auxEsq.getInfo() == 2);
        assertTrue(auxDir != null);
        assertTrue(auxDir.getInfo() == 4);

    }

    @Test
    public void testaRLMeio() {
        AVL a = new AVL();
        a.inserir(50, a.getRaiz());
        a.inserir(10, a.getRaiz());
        a.inserir(60, a.getRaiz());
        a.inserir(20, a.getRaiz());
        a.inserir(5, a.getRaiz());
        a.inserir(70, a.getRaiz());
        a.inserir(40, a.getRaiz());
        a.inserir(80, a.getRaiz());
        // Professor após a insercção do 80 o nó 60 fica desbalanceado (2),
        // então se faz necessário uma rotação a esquerda
        a.inserir(75, a.getRaiz());
        // transformando o nó 75 em folha(sem filhos)
        NoAVL aux = a.procurar(75, a.getRaiz());
        assertTrue(aux != null);
        NoAVL auxDir = aux.getDir();
        NoAVL auxEsq = aux.getEsq();
        // assertTrue(auxEsq != null);
        // assertTrue(auxEsq.getInfo() == 70);
        // assertTrue(auxDir != null);
        // assertTrue(auxDir.getInfo() == 80);
    }
}
