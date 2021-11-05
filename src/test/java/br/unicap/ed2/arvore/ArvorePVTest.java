package br.unicap.ed2.arvore;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.unicap.ed2.pv.PV;
import br.unicap.ed2.pv.NoPV;

public class ArvorePVTest {

    @Test
    public void testa1() {
        PV a = new PV();
        a.inserir(8);
        a.inserir(18);
        a.inserir(5);
        a.inserir(15);
        a.inserir(17);
        NoPV aux = a.encontrar(17);
        assertTrue(aux != null);
        NoPV auxDir = aux.getDir();
        NoPV auxEsq = aux.getEsq();
        // foi nessario efetuar a troca de esquerda para direita e vice-versa.
        assertTrue(auxDir != null);
        assertTrue(auxDir.getValor() == 18);
        assertTrue(auxEsq != null);
        assertTrue(auxEsq.getValor() == 15);
        assertTrue(a.ehRaiz(8));

    }

    @Test
    public void testa2() {
        PV a = new PV();
        a.inserir(8);
        a.inserir(18);
        a.inserir(5);
        a.inserir(15);
        a.inserir(17);
        a.inserir(25);
        a.inserir(40);
        NoPV aux = a.encontrar(25);
        assertTrue(aux != null);
        NoPV auxDir = aux.getDir();
        NoPV auxEsq = aux.getEsq();
        // foi nessario efetuar a troca de esquerda para direita e vice-versa.
        assertTrue(auxDir != null);
        assertTrue(auxDir.getValor() == 40);
        assertTrue(auxEsq != null);
        assertTrue(auxEsq.getValor() == 18);
        assertTrue(a.ehRaiz(8));

    }

}
