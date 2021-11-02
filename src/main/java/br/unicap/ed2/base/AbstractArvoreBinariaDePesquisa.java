package br.unicap.ed2.base;
import java.util.Deque;
import java.util.LinkedList;

public abstract class AbstractArvoreBinariaDePesquisa<T extends No> {
    protected T raiz;
	
	public void clear (){
		raiz = null;
	}

	public boolean ehRaiz(int i) {
        if (raiz == null){
            return false;
        }
        return raiz.getChave() == i;
    }

	public T minimo(T node) {
		while (node.getEsquerda() != null) {
			node = node.getEsquerda();
		}
		return node;
	}

	public T maximo(T node) {
		while (node.getDireita() != null) {
			node = node.getDireita();
		}
		return node;
	}

	public int altura() {
        return altura(this.raiz);
    }
    
    private int altura(No node) {
        if(node == null) return -1;
        else return 1 + Math.max(altura(node.getEsquerda()), altura(node.getDireita()));
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
			if (element < aux.getChave()){
				if (aux.getEsquerda() == null){
					return null;
				}
				aux = aux.getEsquerda();
			}
			if (element > aux.getChave()){
				if (aux.getDireita() == null){
					return null;
				}
				aux = aux.getDireita();
			}	
		}
		return null;
	}

	protected T deletarNoHelper(T node, int key) {
		// Procurando a Chave
		if (node == null) return node;
		else if (key < node.getChave()) node.setEsquerda(deletarNoHelper(node.getEsquerda(), key));
		else if (key > node.getChave()) node.setDireita(deletarNoHelper(node.getDireita(), key));
		else {
			// A chave foi encontrada, e agora deve ser deletada
			T pai = node.getPai();

			// case 1: O node eh folha
			if (node.getEsquerda() == null && node.getDireita() == null) {
				if (pai != null){
					if (node.getChave() < pai.getChave() ){
						pai.setEsquerda(null);
					} else {
						pai.setDireita(null);
					}
				}
				node = null;
			}

			// case 2: O No tem só um filho
			else if (node.getEsquerda() == null) {
				T filhoUnico = node.getDireita();
				if (pai != null){
					if (node.getChave() < pai.getChave() ){
						pai.setEsquerda(filhoUnico);
					} else {
						pai.setDireita(filhoUnico);
					}
				}
				node = node.getDireita();
			}

			else if (node.getDireita() == null) {
				T filhoUnico = node.getEsquerda();
				if (pai != null){
					if (node.getChave() < pai.getChave() ){
						pai.setEsquerda(filhoUnico);
					} else {
						pai.setDireita(filhoUnico);
					}
				}
				node = node.getEsquerda();
			}

			// case 3: Tem ambos os filhos
			else {
				T temp = minimo(node.getDireita());// Minimo da direita
				node.setChave(temp.getChave());
				node.setDireita(deletarNoHelper(node.getDireita(), temp.getChave()));
			}

		} 
		return node;
	}

    protected T inserirNoHelper(No atual, int chave) {
        T node = novoNode(chave);
		node.setChave(chave);

		No folhaCorreta = null;
		//No atual = this.raiz;

		while (atual != null) {
			folhaCorreta = atual;
			if (node.getChave() < atual.getChave()) {
				atual = atual.getEsquerda();
			} else {
				atual = atual.getDireita();
			}
		}

		// <<folhaCorreta>> é pai de <<node>>
		node.setPai(folhaCorreta);
		if (folhaCorreta == null) {
			raiz = node;
		} else if (node.getChave() < folhaCorreta.getChave()) {
			folhaCorreta.setEsquerda(node);
		} else {
			folhaCorreta.setDireita(node);
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
					
				if(current.getEsquerda() != null) 
					queue.addLast(current.getEsquerda());
				if(current.getDireita() != null) 
					queue.addLast(current.getDireita());   
			}
		}
	}

    public abstract T novoNode(int key);
	public abstract T inserir(int key);
	public abstract T procurar(int key);
	public abstract void deletar(int key);
}