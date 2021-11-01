package View;

import Arvore.Arvore;
import Entidades.Carro;

public class main {

    static Carro[] carros = {new Carro("Gol", "60", "ABC1234"),
            new Carro("Uno", "40", "DEF5678"),
            new Carro("qwqw", "90", "PQR6129"),
            new Carro("dasda", "43", "PQR6129"),
            new Carro("asdasd", "80", "PQR6129"),
            new Carro("sdhse", "70", "PQR6129"),
            new Carro("sysee", "34", "PQR6129"),
            new Carro("asfaaz", "67", "PQR6129"),
            new Carro("cgjfg", "98", "PQR6129"),
            new Carro("dhddf", "32", "PQR6129"),
            new Carro("yuoyt", "75", "PQR6129"),
            new Carro("zdhs", "78", "PQR6129"),
            new Carro("eywwe", "41", "PQR6129"),
            new Carro("seyse", "77", "PQR6129"),
            new Carro("syhs", "96", "PQR6129"),
            new Carro("dtfi", "56", "PQR6129"),
            new Carro("eywew", "20", "PQR6129"),
            new Carro("Palio", "30", "GHI4156"),
    };

    public static void main(String[] args){
        Arvore arvore1 = new Arvore();
        Arvore arvore2 = new Arvore();
        Arvore arvore3 = new Arvore();
        Arvore arvore4 = new Arvore();

        //Esses For's são para preenchear as árvores


        double j = 10;
        System.out.println("Primeira Árvore exibida em Pré-ordem: ");

        for(int i =0; i < 15; i++){
            double k = j;
            String t = Double.toString(k); 
            arvore1.inserir(new Carro("Modelo", t, "Placa"));
            j = j + 5;
        }
        arvore1.preOrdem();
        System.out.println();

        
        System.out.println("Segunda Árvore exibida em Pré-ordem: ");
        for(int l = 0; l < carros.length; l++){
            arvore2.inserir(carros[l]);
        }
        arvore2.remove(carros[0]); //Infelizmente, o remover so está funcionando em casos especificos como esse removendo o Carro com numIdem 60, por conta disso n coloquei em todos os casos de teste
        arvore2.preOrdem();
        System.out.println();



        System.out.println("Terceira Árvore exibida em Pré-ordem");
        double m = 10;

        for(int n = 0; n < 30; n++) {
            double g = m;
            String y = Double.toString(g);
            arvore3.inserir(new Carro("Modelo", y, "Placa"));
            m = m + 3;
        }
        arvore3.preOrdem();
        System.out.println();



        System.out.println("Quarta Árvore exibida em Pré-ordem");
        double p = 70;

        for(int q = 0; q < 15; q++){

            double e = p;
            String v = Double.toString(e);
            arvore4.inserir(new Carro("Modelo", v, "Placa"));
            p = p - 2;
        }
        arvore4.preOrdem();
    }


}
