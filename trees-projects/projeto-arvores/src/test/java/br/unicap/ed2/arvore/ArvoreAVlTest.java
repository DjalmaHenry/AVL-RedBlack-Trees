package br.unicap.ed2.arvore;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.unicap.ed2.avl.NoAVL;
import br.unicap.ed2.avl.AVL;

public class ArvoreAVlTest {

   
    
    @Test
    public void testaLLRaiz()
    {
        AVL a = new AVL();
        a.inserir(3,a.getRaiz());
        a.inserir(2,a.getRaiz());
        a.inserir(1,a.getRaiz());
        NoAVL aux = a.procurar(2,a.getRaiz());
        // System.out.println(aux.getInfo());
        assertTrue( aux != null );
        NoAVL auxDir = aux.getDir();
        NoAVL auxEsq = aux.getEsq();
        assertTrue( auxEsq != null );
        assertTrue( auxEsq.getInfo() == 1 );
        assertTrue( auxDir != null );
        assertTrue( auxDir.getInfo() == 3 );
        //assertTrue( a.ehRaiz(2) );

    }

    @Test
    public void testaLLMeio()
    {
        AVL a = new AVL();
        a.inserir(10,a.getRaiz();
        a.inserir(20,a.getRaiz());
        a.inserir(5,a.getRaiz());
        a.inserir(4,a.getRaiz());
        a.inserir(7,a.getRaiz());
        a.inserir(30,a.getRaiz());
        a.inserir(15,a.getRaiz());
        a.inserir(2,a.getRaiz());
        a.inserir(1,a.getRaiz());
        NoAVL aux = a.procurar(2,a.getRaiz());
        assertTrue( aux != null );
        NoAVL auxDir = aux.getDir();
        NoAVL auxEsq = aux.getEsq();
        assertTrue( auxEsq != null );
        assertTrue( auxEsq.getInfo() == 1 );
        assertTrue( auxDir != null );
        assertTrue( auxDir.getInfo() == 4 );

    }

    @Test
    public void testaRR2Raiz()
    {
        ArvoreAVL a = new ArvoreAVL();
        a.inserir(1);
        a.inserir(2);
        a.inserir(3);
        NoAVL aux = a.procurar(2);
        assertTrue( aux != null );
        NoAVL auxDir = aux.getDireita();
        NoAVL auxEsq = aux.getEsquerda();
        assertTrue( auxEsq != null );
        assertTrue( auxEsq.getChave() == 1 );
        assertTrue( auxDir != null );
        assertTrue( auxDir.getChave() == 3 );
        assertTrue( a.ehRaiz(2) );

    }

    @Test
    public void testaRRMeio()
    {
        ArvoreAVL a = new ArvoreAVL();
        a.inserir(50);
        a.inserir(10);
        a.inserir(60);
        a.inserir(20);
        a.inserir(5);
        a.inserir(70);
        a.inserir(40);
        a.inserir(80);
        a.inserir(90);
        NoAVL aux = a.procurar(80);
        assertTrue( aux != null );
        NoAVL auxDir = aux.getDireita();
        NoAVL auxEsq = aux.getEsquerda();
        assertTrue( auxEsq != null );
        assertTrue( auxEsq.getChave() == 70 );
        assertTrue( auxDir != null );
        assertTrue( auxDir.getChave() == 90 );

    }

    @Test
    public void testaLRMeio()
    {
        ArvoreAVL a = new ArvoreAVL();
        a.inserir(10);
        a.inserir(20);
        a.inserir(5);
        a.inserir(4);
        a.inserir(7);
        a.inserir(30);
        a.inserir(15);
        a.inserir(2);
        a.inserir(3);
        NoAVL aux = a.procurar(3);
        assertTrue( aux != null );
        NoAVL auxDir = aux.getDireita();
        NoAVL auxEsq = aux.getEsquerda();
        assertTrue( auxEsq != null );
        assertTrue( auxEsq.getChave() == 2 );
        assertTrue( auxDir != null );
        assertTrue( auxDir.getChave() == 4 );

    }

    @Test
    public void testaRLMeio()
    {
        ArvoreAVL a = new ArvoreAVL();
        a.inserir(50);
        a.inserir(10);
        a.inserir(60);
        a.inserir(20);
        a.inserir(5);
        a.inserir(70);
        a.inserir(40);
        a.inserir(80);
        a.inserir(75);
        NoAVL aux = a.procurar(75);
        assertTrue( aux != null );
        NoAVL auxDir = aux.getDireita();
        NoAVL auxEsq = aux.getEsquerda();
        assertTrue( auxEsq != null );
        assertTrue( auxEsq.getChave() == 70 );
        assertTrue( auxDir != null );
        assertTrue( auxDir.getChave() == 80 );
    }
}
