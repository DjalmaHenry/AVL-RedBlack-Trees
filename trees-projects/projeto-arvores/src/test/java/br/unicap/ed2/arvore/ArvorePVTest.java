package br.unicap.ed2.arvore;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.unicap.ed2.pv.ArvorePV;
import br.unicap.ed2.pv.NoPV;

public class ArvorePVTest {
    
    @Test
    public void testa1()
    {
        ArvorePV a = new ArvorePV();
        a.inserir(8);
        a.inserir(18);
        a.inserir(5);
        a.inserir(15);
        a.inserir(17);
        NoPV aux = a.procurar(17);
        assertTrue( aux != null );
        NoPV auxDir = aux.getDireita();
        NoPV auxEsq = aux.getEsquerda();
        assertTrue( auxEsq != null );
        assertTrue( auxEsq.getChave() == 18 );
        assertTrue( auxDir != null );
        assertTrue( auxDir.getChave() == 15 );
        assertTrue( a.ehRaiz(8) );

    }

    @Test
    public void testa2()
    {
        ArvorePV a = new ArvorePV();
        a.inserir(8);
        a.inserir(18);
        a.inserir(5);
        a.inserir(15);
        a.inserir(17);
        a.inserir(25);
        a.inserir(40);
        NoPV aux = a.procurar(25);
        assertTrue( aux != null );
        NoPV auxDir = aux.getDireita();
        NoPV auxEsq = aux.getEsquerda();
        assertTrue( auxEsq != null );
        assertTrue( auxEsq.getChave() == 40 );
        assertTrue( auxDir != null );
        assertTrue( auxDir.getChave() == 18 );
        assertTrue( a.ehRaiz(8) );

    }

}
