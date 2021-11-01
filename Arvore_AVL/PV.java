package Arvore_AVL;

public class PV {

    private NoPV raiz;

    public PV() {
    }

    public NoPV getRaiz() {
        return raiz;
    }

    public void setRaiz(NoPV raiz) {
        this.raiz = raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public NoPV procurar (int info, NoPV noAtual) {
        while (noAtual != null) {
            if (noAtual.getInfo() == info) {
                return noAtual;
            } else if (info > noAtual.getInfo()) {
                noAtual = noAtual.getDir();
            } else {
                noAtual = noAtual.getEsq();
            }
        }
        return null;
    }

    public void inserir(int info, NoPV noAtual) {
        if (isEmpty()) {
            NoPV novoNo = new NoPV(info);
            raiz = novoNo;
             ajustarBalanceamento(raiz);
        } else {
            if (info < noAtual.getInfo()) {
                if (noAtual.getEsq() != null) {
                    // no com valor, vamos leva-lo para recursao.
                    inserir(info, noAtual.getEsq());
                } else {
                    // no null, vamos inserir.
                    NoPV novoNo = new NoPV(info);
                    noAtual.setEsq(novoNo);
                    novoNo.setPai(noAtual);
                    ajustarBalanceamento(noAtual);
                    raiz = balanceia(raiz);
                }
            } else if (info > noAtual.getInfo()) {
                if (noAtual.getDir() != null) {
                    // no com valor, vamos leva-lo para recursao.
                    inserir(info, noAtual.getDir());
                } else {
                    // no null, vamos inserir.
                    NoPV novoNo = new NoPV(info);
                    noAtual.setDir(novoNo);
                    novoNo.setPai(noAtual);
                    ajustarBalanceamento(noAtual);
                    raiz = balanceia(raiz);
                }
            } else {
                System.out.println("Caso de no ser repetido!");
            }
        }
    }

    public void percorrerEmOrdem(NoPV no) {
        if (no != null) {
            percorrerEmOrdem(no.getEsq());
            System.out.println(no.getInfo());
            percorrerEmOrdem(no.getDir());
        }
    }

    public NoPV remover(int info, NoPV noAtual) {
        if (isEmpty()) {
            System.out.println("Caso de arvore vazia");
            return null;
        }
        if (info < noAtual.getInfo()) {
            noAtual.setEsq(remover(info, noAtual.getEsq()));
        } else if (info > noAtual.getInfo()) {
            noAtual.setDir(remover(info, noAtual.getDir()));
        } else { // proceso de remocao.
            if (noAtual.getDir() == null && noAtual.getEsq() == null) {
                if (noAtual == raiz) {
                    raiz = null;
                } else {
                    noAtual = null;
                }

            } else if (noAtual.getEsq() == null) {
                noAtual = noAtual.getDir();
            } else if (noAtual.getDir() == null) {
                noAtual = noAtual.getEsq();
            } else {
                NoPV aux = noAtual.getEsq();
                while (aux.getDir() != null) {
                    aux = aux.getDir();
                }
                noAtual.setInfo(aux.getInfo());
                aux.setInfo(info);
                noAtual.setEsq(remover(info, noAtual.getEsq()));
            }
        }
        if (raiz != null) {
            ajustarBalanceamento(noAtual);
            raiz = balanceia(raiz);
        }
        return noAtual;
    }

   

    public int verificaAltura(NoPV noAtual) {
        if (noAtual == null) {
            return -1;
        }
        if (noAtual.getDir() == null && noAtual.getEsq() == null) {
            return 0;
        } else if (noAtual.getEsq() == null) {
            return 1 + verificaAltura(noAtual.getDir());
        } else if (noAtual.getDir() == null) {
            return 1 + verificaAltura(noAtual.getEsq());
        } else {
            if (verificaAltura(noAtual.getEsq()) > verificaAltura(noAtual.getDir())) {
                return 1 + verificaAltura(noAtual.getEsq());
            } else {
                return 1 + verificaAltura(noAtual.getDir());
            }
        }
    }

    

    public NoPV rotacaoADireita(NoPV noAtual) {
        NoPV aux = noAtual.getEsq();
        aux.setPai(noAtual.getPai());
        if (aux.getDir() != null) {
            aux.getDir().setPai(noAtual);
        }
        noAtual.setPai(aux);
        noAtual.setEsq(aux.getDir());
        aux.setDir(noAtual);
        if (aux.getPai() != null) {
            if (aux.getPai().getDir() == noAtual) {
                aux.getPai().setDir(aux);
            } else if (aux.getPai().getEsq() == noAtual) {
                aux.getPai().setEsq(aux);
            }
        }
        ajustarBalanceamento(aux);
        return aux;
    }

    public NoPV rotacaoAEsquerda(NoPV noAtual) {
        NoPV aux = noAtual.getDir();
        aux.setPai(noAtual.getPai());
        if (aux.getEsq() != null) {
            aux.getEsq().setPai(noAtual);
        }

        noAtual.setPai(aux);
        noAtual.setDir(aux.getEsq());
        aux.setEsq(noAtual);
        if (aux.getPai() != null) {
            if (aux.getPai().getDir() == noAtual) {
                aux.getPai().setDir(aux);
            } else if (aux.getPai().getEsq() == noAtual) {
                aux.getPai().setEsq(aux);
            }
        }
        ajustarBalanceamento(aux);
        return aux;
    }

    public NoPV rotacaoDuplaDireita(NoPV noAtual) {
        NoPV aux = noAtual.getEsq();
        noAtual.setEsq(rotacaoAEsquerda(aux));
        NoPV aux2 = rotacaoADireita(noAtual);
        return aux2;
    }

    public NoPV rotacaoDuplaEsquerda(NoPV noAtual) {
        NoPV aux = noAtual.getDir();
        noAtual.setDir(rotacaoADireita(aux));
        NoPV aux2 = rotacaoAEsquerda(noAtual);
        return aux2;
    }

}
