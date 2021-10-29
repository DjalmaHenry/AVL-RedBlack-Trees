package br.unicap.ed2.avl;

import br.unicap.ed2.base.AbstractArvoreBinariaDePesquisa;

public class ArvoreAVL extends AbstractArvoreBinariaDePesquisa<NoAVL> {

    @Override
    public NoAVL novoNode(int key) {
        //Altera
        return new NoAVL(key);
    }

    @Override
    public NoAVL inserir(int key) {
        NoAVL t = inserirNoHelper(raiz, key);
		raiz = balance(raiz);
		return t;
    }

    @Override
    public NoAVL procurar(int key) {
        return procurarNoHelper(raiz, key);
    }

    @Override
    public void deletar(int key) {
        raiz = deletarNoHelper(raiz, key);
		raiz = balance(raiz);
    }

    private int getfator(NoAVL t) {
		return altura(t.getEsquerda()) - altura(t.getDireita());
	}

    private static int altura(NoAVL t) {
		return t == null ? -1 : t.getFB();
	}

	private static int max(int ladoesq, int ladodir) {
		return ladoesq > ladodir ? ladoesq : ladodir;
	}

    private NoAVL balance(NoAVL t) {
		if (getfator(t) == 2) {
			if (getfator(t.getEsquerda()) > 0) {
				System.out.println("\nRotacao para direita.");
				t = RotacaoDir(t);
			} else {
				System.out.println("\nRotacao dupla para direita.");
				t = RotacaoDuplaDir(t);
			}
		} else if (getfator(t) == -2) {
			if (getfator(t.getDireita()) < 0) {
				System.out.println("\nRotacao para esquerda.");
				t = RotacaoEsq(t);
			} else {
				System.out.println("\nRotacao dupla para esquerda.");
				t = RotacaoDuplaEsq(t);
			}
		}
		t.setFB(max(altura(t.getEsquerda()), altura(t.getDireita())) + 1);
		return t;
	}

	private static NoAVL RotacaoDir(NoAVL aux2) {
		NoAVL aux1 = aux2.getEsquerda();
		aux2.setEsquerda(aux1.getDireita());
		aux1.setDireita(aux2);
		aux2.setFB(max(altura(aux2.getEsquerda()), altura(aux2.getDireita())) + 1);
		aux1.setFB(max(altura(aux1.getEsquerda()), aux2.getFB()) + 1);
		return aux1;
	}

	private static NoAVL RotacaoEsq(NoAVL aux1) {
		NoAVL aux2 = aux1.getDireita();
		aux1.setDireita(aux2.getEsquerda());
		aux2.setEsquerda(aux1);
		aux1.setFB(max(altura(aux1.getEsquerda()), altura(aux1.getDireita())) + 1);
		aux2.setFB(max(altura(aux2.getDireita()), aux1.getFB()) + 1);
		return aux2;
	}

	private static NoAVL RotacaoDuplaDir(NoAVL aux3) {
		aux3.setEsquerda(RotacaoEsq(aux3.getEsquerda()));
		return RotacaoDir(aux3);
	}

	private static NoAVL RotacaoDuplaEsq(NoAVL aux1) {
		aux1.setDireita(RotacaoDir(aux1.getDireita()));
		return RotacaoEsq(aux1);
	}
}