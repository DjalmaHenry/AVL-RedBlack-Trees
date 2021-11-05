package br.unicap.ed2.pv;

public class NoPV {
	public Integer valor;
	public NoPV p, esq, dir;
	public boolean cor; // true = vermelho, false = preto.

	public NoPV(int valor, boolean cor) {
		this.valor = valor;
		this.cor = cor;
		this.p = this.esq = this.dir = PV.nil;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
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

	public NoPV procurar(int no) {
		if (no < this.valor && this.esq != PV.nil)
			return this.esq.procurar(no);
		else if (no > this.valor && this.dir != PV.nil)
			return this.dir.procurar(no);
		else
			return this;
	}

	public NoPV minimo() {
		if (this.esq != PV.nil)
			return esq.minimo();
		else
			return this;
	}

	public NoPV sucessor() {
		if (this.dir != PV.nil)
			return this.dir.minimo();
		else
			return this;
	}

}
