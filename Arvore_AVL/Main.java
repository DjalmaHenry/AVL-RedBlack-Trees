package Arvore_AVL;

public class Main {
    public static void main(String[] args) {
        AVL a = new AVL();
        a.inserir(3,a.getRaiz());
        a.inserir(2,a.getRaiz());
        a.inserir(1,a.getRaiz());
        NoAVL aux = a.procurar(2, a.getRaiz());

        System.out.println(aux.getInfo());

        a.percorrerEmOrdem(a.getRaiz());
    }

    
    public void testaLLRaiz()
    {
        AVL a = new AVL();
        a.inserir(3,a.getRaiz());
        a.inserir(2,a.getRaiz());
        a.inserir(1,a.getRaiz());
        NoAVL aux = a.procurar(2, a.getRaiz());
        assertTrue( aux != null );
        NoAVL auxDir = aux.getDir();
        NoAVL auxEsq = aux.getEsq();
        assertTrue( auxEsq != null );
        assertTrue( auxEsq.getInfo() == 1 );
        assertTrue( auxDir != null );
        assertTrue( auxDir.getInfo() == 3 );
        assertTrue( a.ehRaiz(2) );

    }
}
