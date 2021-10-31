package br.unicap.ed2.arvore;

public class Main {
    public static void main(String[] args) {
        ArvoreAVlTest teste = new ArvoreAVlTest();

        teste.testaLLRaiz();
        System.out.println("teste LLRaiz passou!");
        teste.testaLLMeio();
        System.out.println("Teste LLMeio passou!");
        teste.testaLRMeio();
        System.out.println("Teste LRMeio passou!");
        teste.testaRR2Raiz();
        System.out.println("Teste RR2Raiz passou!");
        teste.testaRRMeio();
        System.out.println("Teste RRMeio passou!");
        teste.testaRLMeio();
        System.out.println("Teste RLMeio passou!");
    }
}
