package br.unicap.ed2.pv;
public class NoPV {
	public Integer v; 
	public NoPV p, esq, dir;
	public boolean cor; 
	
	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
	}

	public NoPV getEsq() {
		return esq;
	}

	public void setEsq(NoPV esq) {
		this.esq = esq;
	}

	public NoPV getDir() {
		return dir;
	}

	public void setDir(NoPV dir) {
		this.dir = dir;
	}

	public NoPV(int n, boolean cor) {
		this.v = n;
		this.cor = cor;
		this.p = this.esq = this.dir = PV.nil;
	}

	// Busca o nó que será o pai do proximo nó a ser inserido
	public NoPV procurar(int n) {
		if (n < this.v && this.esq != PV.nil) return this.esq.procurar(n);
		else if (n > this.v && this.dir != PV.nil) return this.dir.procurar(n);
		else return this;
	}

	// Busca o menor valor da árvore
	public NoPV minimo() {
		if (this.esq != PV.nil) return esq.minimo();
		else return this;
	}
	
	public NoPV sucessor(){
		if (this.dir != PV.nil) return this.dir.minimo();
		else return this;
	}

}
