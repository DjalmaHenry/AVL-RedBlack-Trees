package ArvorePV;

public class main {

    public static void main(String[] args){
        Arvore arvore1 = new Arvore();

        for(int i = 0; i < 10; i++){
            arvore1.inserir(i);
            System.out.println("Inserindo " + i);
        }

    }


}
