package br.unicap.ed2.pv;

public class PV {
	public NoPV raiz;
	public static NoPV nil = new NoPV(0, false);
	public Integer cont;

	public PV() {
		this.raiz = PV.nil;
	}

	public PV(int valor) {
		this.raiz = new NoPV(valor, false);
	}

	private void rotacaoEsq(NoPV no) {
		NoPV aux = no.dir;
		no.dir = aux.esq;
		if (aux.esq != PV.nil)
			aux.esq.p = no;
		aux.p = no.p;
		if (no.p == PV.nil)
			this.raiz = aux;
		else if (no == no.p.esq)
			no.p.esq = aux;
		else
			no.p.dir = aux;
		aux.esq = no;
		no.p = aux;
	}

	private void rotacaoDir(NoPV no) {
		NoPV aux = no.esq;
		no.esq = aux.dir;
		if (aux.dir != PV.nil)
			aux.dir.p = no;
		aux.p = no.p;
		if (no.p == PV.nil)
			this.raiz = aux;
		else if (no == no.p.esq)
			no.p.esq = aux;
		else
			no.p.dir = aux;
		aux.dir = no;
		no.p = aux;
	}

	public void inserir(int valor) {
		if (this.raiz == PV.nil) {
			this.raiz = new NoPV(valor, false);
		} else {
			NoPV novoNo = this.encontrar(valor);
			if (valor < novoNo.valor) {
				novoNo.esq = new NoPV(valor, true);
				novoNo.esq.p = novoNo;
				this.finalInsercao(novoNo.esq);
			} else if (valor > novoNo.valor) {
				novoNo.dir = new NoPV(valor, true);
				novoNo.dir.p = novoNo;
				this.finalInsercao(novoNo.dir);
			}
		}
	}

	public void trasferirNo(NoPV no, NoPV no2) {
		if (no.p == PV.nil)
			this.raiz = no2;
		else if (no == no.p.esq)
			no.p.esq = no2;
		else
			no.p.dir = no2;
		no2.p = no.p;
	}

	public boolean ehRaiz(int valor) {
		if (raiz == null) {
			return false;
		}
		return raiz.getValor() == valor;
	}

	private void finalInsercao(NoPV no) {
		NoPV aux;
		while (no.p.cor) {
			if (no.p == no.p.p.esq) {
				aux = no.p.p.dir;
				if (aux.cor) {
					no.p.cor = false;
					aux.cor = false;
					no.p.p.cor = true;
					no = no.p.p;
				} else {
					if (no == no.p.dir) {
						no = no.p;
						this.rotacaoEsq(no);
					}
					no.p.cor = false;
					no.p.p.cor = true;
					this.rotacaoDir(no.p.p);
				}
			} else {
				aux = no.p.p.esq;
				if (aux.cor) {
					aux.cor = no.p.cor = false;
					no.p.p.cor = true;
					no = no.p.p;
				} else {
					if (no == no.p.esq) {
						no = no.p;
						this.rotacaoDir(no);
					}
					no.p.cor = false;
					no.p.p.cor = true;
					this.rotacaoEsq(no.p.p);
				}
			}
		}
		this.raiz.cor = false;
	}

	public void remover(int n) {
		NoPV z = this.encontrar(n);
		NoPV no, y = z;
		boolean cordey = y.cor;

		if (z.valor == n) {
			if (z.esq == PV.nil) {
				no = z.dir;
				this.trasferirNo(z, z.dir);
			} else if (z.dir == PV.nil) {
				no = z.esq;
				this.trasferirNo(z, z.esq);
			} else {
				y = z.sucessor();
				cordey = y.cor;
				no = y.dir;

				if (y.p == z)
					no.p = y;
				else {
					this.trasferirNo(y, y.dir);
					y.dir = z.dir;
					y.dir.p = y;
				}
				this.trasferirNo(z, y);
				y.esq = z.esq;
				y.esq.p = y;
				y.cor = z.cor;
			}

			if (!cordey)
				this.finalRemocao(no);
		}
	}

	private void finalRemocao(NoPV n) {
		NoPV no;

		while (n != this.raiz && !n.cor) {
			if (n == n.p.esq) {
				no = n.p.dir;

				if (no.cor) { // caso 1
					no.cor = false;
					n.p.cor = true;
					this.rotacaoEsq(n.p);
					no = n.p.dir;
				}
				if (!no.esq.cor && !no.dir.cor) { // caso 2
					no.cor = true;
					n = n.p;
				} else {
					if (!no.dir.cor) { // caso 3
						no.esq.cor = false;
						no.cor = true;
						this.rotacaoDir(no);
						no = n.p.dir;
					}
					// caso 4
					no.cor = n.p.cor;
					n.p.cor = false;
					no.dir.cor = false;
					this.rotacaoEsq(n.p);
					n = this.raiz;
				}
			} else {
				no = n.p.esq;

				if (no.cor) { // caso 1
					no.cor = false;
					n.p.cor = true;
					this.rotacaoDir(n.p);
					no = n.p.esq;
				}
				if (!no.esq.cor && !no.dir.cor) { // caso 2
					no.cor = true;
					n = n.p;
				} else {
					if (!no.esq.cor) { // caso 3
						no.dir.cor = false;
						no.cor = true;
						this.rotacaoEsq(no);
						no = n.p.esq;
					}
					// caso 4
					no.cor = n.p.cor;
					n.p.cor = false;
					no.esq.cor = false;
					this.rotacaoDir(n.p);
					n = this.raiz;
				}
			}
		}
		n.cor = false;
	}

	public NoPV encontrar(int valor) {
		return this.raiz.procurar(valor);
	}

	public String color(boolean resul) {
		return (resul) ? "RED" : "BLACK";
	}

}
