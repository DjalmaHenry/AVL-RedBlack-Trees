package Arvore_AVL;

public class Main {
    public static void main(String[] args) {
        PV a = new PV();
        a.inserir(3,a.getRaiz());
        a.inserir(2,a.getRaiz());
        a.inserir(1,a.getRaiz());
        NoPV aux = a.procurar(2, a.getRaiz());

        System.out.println(aux.getInfo());

        a.percorrerEmOrdem(a.getRaiz());
    }


    
}
