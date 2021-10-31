package Arvore_AVL;

public class AVL {

    private NoAVL raiz;

    public AVL() {

    }

    public NoAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NoAVL raiz) {
        this.raiz = raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public void inserir(int info, NoAVL noAtual) {
        if (isEmpty()) {
            NoAVL novoNo = new NoAVL(info);
            raiz = novoNo;
            // defineFB(raiz);//define o fator de balanceamento de cada nó
        } else {
            if (info < noAtual.getInfo()) {
                if (noAtual.getEsq() != null) {
                    // no com valor, vamos leva-lo para recursao.
                    inserir(info, noAtual.getEsq());
                } else {
                    // no null, vamos inserir.
                    NoAVL novoNo = new NoAVL(info);
                    noAtual.setEsq(novoNo);
                    novoNo.setPai(noAtual);
                    ajustarBalanceamento(noAtual);// define o fator de balanceamento de cada nó
                    raiz = balanceia(raiz);// Balanceia a arvore
                }
            } else if (info > noAtual.getInfo()) {
                if (noAtual.getDir() != null) {
                    // no com valor, vamos leva-lo para recursao.
                    inserir(info, noAtual.getDir());
                } else {
                    // no null, vamos inserir.
                    NoAVL novoNo = new NoAVL(info);
                    noAtual.setDir(novoNo);
                    novoNo.setPai(noAtual);
                    ajustarBalanceamento(noAtual);// define o fator de balanceamento de cada nó
                    raiz = balanceia(raiz);// Balanceia a arvore
                }
            } else {
                System.out.println("Caso de no ser repetido!");
            }
        }
    }

    private void percorrerEmOrdem(NoAVL no) {
        if (no != null) {
            percorrerEmOrdem(no.getEsq());
            System.out.println(no.getInfo());
            percorrerEmOrdem(no.getDir());
        }
    }

    public NoAVL remover(int info, NoAVL noAtual) {
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
                NoAVL aux = noAtual.getEsq();
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

    public void ajustarBalanceamento(NoAVL noAtual) {
        noAtual.setBalanceamento(verificaAltura(noAtual.getEsq()) - verificaAltura(noAtual.getDir()))
        if (noAtual.getDir() != null) {
            ajustarBalanceamento(noAtual);
        }
        if (noAtual.getEsq() != null) {
            ajustarBalanceamento(noAtual);
        }
    }

    public int verificaAltura(NoAVL noAtual) {
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

    public NoAVL balanceia(NoAVL noAtual) {
        if (noAtual.getBalanceamento() == 2 && noAtual.getEsq().getBalanceamento() >= 0) {
            noAtual = rotacaoADireita(noAtual);

        } else if (noAtual.getBalanceamento() == -2 && noAtual.getDir().getBalanceamento() <= 0) {
            noAtual = rotacaoAEsquerda(noAtual);

        } else if (noAtual.getBalanceamento() == 2 && noAtual.getEsq().getBalanceamento() < 0) {
            noAtual = rotacaoDuplaDireita(noAtual);

        } else if (noAtual.getBalanceamento() == -2 && noAtual.getDir().getBalanceamento() > 0) {
            noAtual = rotacaoDuplaEsquerda(noAtual);
        }

        if (noAtual.getDir() != null) {
            balanceia(noAtual.getDir());
        }
        if (noAtual.getEsq() != null) {
            balanceia(noAtual.getEsq());
        }
        return noAtual;
    }

    public NoAVL rotacaoADireita(NoAVL noAtual) {
        NoAVL aux = noAtual.getEsq();
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

    public NoAVL rotacaoAEsquerda(NoAVL noAtual) {
        NoAVL aux = noAtual.getDir();
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

    public NoAVL rotacaoDuplaDireita(NoAVL noAtual) {
        NoAVL aux = noAtual.getEsq();
        noAtual.setEsq(rotacaoAEsquerda(aux));
        NoAVL aux2 = rotacaoADireita(noAtual);
        return aux2;
    }

    public NoAVL rotacaoDuplaEsquerda(NoAVL noAtual) {
        NoAVL aux = noAtual.getDir();
        noAtual.setDir(rotacaoADireita(aux));
        NoAVL aux2 = rotacaoAEsquerda(noAtual);
        return aux2;
    }

}
