package br.unicap.ed2.arvore;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.unicap.ed2.base.No;
import br.unicap.ed2.bst.ArvoreBinariaDePesquisa;

public class ArvoreBinariaTest 
{
    ArvoreBinariaDePesquisa a = new ArvoreBinariaDePesquisa();

   public void clearTree(){
       a.clear();
   }

    @Test
    public void testaInserir()
    {
        a.inserir(10);
        a.inserir(1);
        a.inserir(15);
        a.inserir(12);
        a.inserir(20);
        a.inserir(25);

        //Testa Raiz
        assertTrue(a.procurar(10) != null);
        assertTrue(a.ehRaiz(10));
        No no = a.procurar(10);
        assertTrue(no.getEsquerda().getChave() == 1);
        assertTrue(no.getDireita().getChave() == 15);
        
        //teste Meio
        assertTrue(a.procurar(15) != null);
        no = a.procurar(15);
        assertTrue(no.getEsquerda().getChave() == 12);
        assertTrue(no.getDireita().getChave() == 20);

        //teste Folha
        assertTrue(a.procurar(25) != null);
        no = a.procurar(25);
        assertTrue(no.getEsquerda() == null);
        assertTrue(no.getDireita() == null);

        // Testa existencia de outros
        assertTrue(a.procurar(1) != null);
        assertTrue(a.procurar(12) != null);
        assertTrue(a.procurar(20) != null);
    }

    @Test
    public void testaDeletarFolha()
    {
        a.inserir(10);
        a.inserir(1);
        a.inserir(15);
        a.inserir(12);
        a.inserir(20);
        a.inserir(25);

        No aux;

        //Deletar Folha 25
        aux = a.procurar(25);
        assertTrue(aux != null);
        assertTrue(aux.getChave() == 25);
        a.deletar(25);
        aux = a.procurar(25);
        assertTrue(aux == null);

        //Deletar Folha 20 e 12
        aux = a.procurar(20);
        assertTrue(aux != null);
        assertTrue(aux.getChave() == 20);
        aux = a.procurar(12);
        assertTrue(aux != null);
        assertTrue(aux.getChave() == 12);

        a.deletar(20);
        a.deletar(12);

        aux = a.procurar(20);
        assertTrue(aux == null);
        aux = a.procurar(12);
        assertTrue(aux == null);

    }

    @Test
    public void testaDeletarInesxistente()
    {
        a.inserir(10);
        a.inserir(1);
        a.inserir(15);
        a.inserir(12);
        a.inserir(20);
        a.inserir(25);

        No aux;

        //Deletar Inexistente
        a.deletar(30);
        aux = a.procurar(30);
        assertTrue(aux == null);
    }

    @Test
    public void testaDeletarFilhoUnico()
    {
        a.inserir(10);
        a.inserir(1);
        a.inserir(15);
        a.inserir(12);
        a.inserir(20);
        a.inserir(25);

        No aux;


        //Deletar Unico Filho
        aux = a.procurar(20);
        assertTrue(aux != null);
        assertTrue(aux.getChave() == 20);
        a.deletar(20);
        aux = a.procurar(20);
        assertTrue(aux == null);
        
        //Deletar Raiz
        a.deletar(1);
        aux = a.procurar(1);
        assertTrue(aux == null);
        aux = a.procurar(10);
        assertTrue(aux != null);
        assertTrue(aux.getChave() == 10);
        assertTrue(a.ehRaiz(10));
        
        a.deletar(10);
        aux = a.procurar(10);
        assertTrue(aux == null);
        assertTrue(a.ehRaiz(15));
    }

    @Test
    public void testaDeletarDoisFilhos()
    {
        a.inserir(10);
        a.inserir(1);
        a.inserir(15);
        a.inserir(12);
        a.inserir(20);
        a.inserir(25);

        No aux;

        //Deletar Dois Filho
        aux = a.procurar(20);
        assertTrue(aux != null);
        assertTrue(aux.getChave() == 20);
        a.deletar(20);
        aux = a.procurar(20);
        assertTrue(aux == null);
    }
}
