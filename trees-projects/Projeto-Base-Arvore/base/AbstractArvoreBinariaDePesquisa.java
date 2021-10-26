package base;
import java.util.Deque;
import java.util.LinkedList;

public abstract class AbstractArvoreBinariaDePesquisa<T extends No> {
    protected T raiz;
	
	public T minimo(T node) {
		while (node.esquerda != null) {
			node = node.getEsquerda();
		}
		return node;
	}

	public T maximo(T node) {
		while (node.direita != null) {
			node = node.getDireita();
		}
		return node;
	}

	public int altura() {
        return altura(this.raiz);
    }
    
    private int altura(No node) {
        if(node == null) return -1;
        else return 1 + Math.max(altura(node.esquerda), altura(node.direita));
    }

	private boolean estaVazia() {
		return raiz == null;
	}

	public void preOrdem() {
		preOrdem(this.raiz);
	}
	
	private void preOrdem(T node) {
		if (node != null) {
			System.out.println(node.getChave());
			preOrdem(node.getEsquerda());
			preOrdem(node.getDireita());
		}
	}

	public void emOrdem() {
		emOrdem(this.raiz);
	}

	private void emOrdem(T node) {
		if (node != null) {
			emOrdem(node.getEsquerda());
			System.out.println(node.getChave());
			emOrdem(node.getDireita());
		}
	}

	public void posOrdem() {
		posOrdem(this.raiz);
	}
	
	private void posOrdem(T node) {
		if (node != null) {
			posOrdem(node.getEsquerda());
			posOrdem(node.getDireita());
			System.out.println(node.getChave());
		}
	}

	protected T procurarNoHelper(T aux, int element) {
		while (aux != null) {   
			if (aux.getChave() == element) return aux;
			if (element < aux.getChave())
				aux = aux.getEsquerda();
			if (element > aux.getChave())
				aux = aux.getDireita();
		}
		return null;
	}

	protected T deletarNoHelper(T node, int key) {
		// Procurando a Chave
		if (node == null) return node;
		else if (key < node.getChave()) node.esquerda = deletarNoHelper(node.getEsquerda(), key);
		else if (key > node.getChave()) node.direita = deletarNoHelper(node.getDireita(), key);
		else {
			// A chave foi encontrada, e agora deve ser deletada

			// case 1: O node eh folha
			if (node.esquerda == null && node.direita == null) {
				node = null;
			}

			// case 2: O No tem só um filho
			else if (node.esquerda == null) {
				node = node.getDireita();
			}

			else if (node.direita == null) {
				node = node.getEsquerda();
			}

			// case 3: Tem ambos os filhos
			else {
				T temp = minimo(node.getDireita());// Minimo da direita
				node.setChave(temp.getChave());
				node.direita = deletarNoHelper(node.getDireita(), temp.getChave());
			}

		} 
		return node;
	}

    protected T inserirNoHelper(No atual, int chave) {
        T node = novoNode(chave);
		//node.setChave(chave);

		No folhaCorreta = null;
		//No atual = this.raiz;

		while (atual != null) {
			folhaCorreta = atual;
			if (node.getChave() < atual.getChave()) {
				atual = atual.esquerda;
			} else {
				atual = atual.direita;
			}
		}

		// <<folhaCorreta>> é pai de <<node>>
		node.pai = folhaCorreta;
		if (folhaCorreta == null) {
			raiz = node;
		} else if (node.getChave() < folhaCorreta.getChave()) {
			folhaCorreta.esquerda = node;
		} else {
			folhaCorreta.direita = node;
		}

        return node;
    }

	public void imprimir() {
		Deque<T> queue = new LinkedList<T>();
			
		if (!estaVazia()) {
			queue.addLast(this.raiz);
			while (!queue.isEmpty()) {
				T current = queue.removeFirst();
					
				System.out.println(current.getChave());
					
				if(current.esquerda != null) 
					queue.addLast(current.getEsquerda());
				if(current.direita != null) 
					queue.addLast(current.getDireita());   
			}
		}
	}

    public abstract T novoNode(int key);
	public abstract T inserir(int key);
	public abstract T procurar(int key);
	public abstract T deletar(int key);
}