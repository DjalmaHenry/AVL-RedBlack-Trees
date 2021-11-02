package ArvorePV;

public class Arvore  {

    private NoRN   raiz;

    public NoRN getRaiz () {
        return raiz;
    }

    public Arvore(){
        this.raiz = null;
    }

    public void inserir(int elemento){
        inserirP(this.raiz, elemento);
    }

    public void percorrerEmOrdem(NoRN no) {
        if (no != null) {
            percorrerEmOrdem(no.getEsquerda());
            System.out.println(no.getElemento());
            percorrerEmOrdem(no.getDireita());
        }
    }

    private void inserirP(NoRN  raiz, int elemento) {
        NoRN novoNo = new NoRN(elemento);
        if(this.raiz == null){ //Arvoré vazia
            System.out.println("Iniciou a arvore");
            this.raiz = new NoRN (elemento);
            this.raiz.setPai(this.raiz);
            primeiroCasoAdd(this.raiz);
        }

        else if(novoNo.compareTo(raiz) < 0){

            if(raiz.getEsquerda() != null){
                inserirP(raiz.getEsquerda(), elemento);
            }
            else{
                raiz.setEsquerda(new NoRN (elemento));
                raiz.getEsquerda().setPai(raiz);
              //  System.out.println(raiz);
                primeiroCasoAdd(raiz.getEsquerda());
            }
        }

        else if(novoNo.compareTo(raiz) > 0){

            if(raiz.getDireita() != null){
                inserirP(raiz.getDireita(), elemento);
            }
            else{
                raiz.setDireita(new NoRN (elemento));
                raiz.getDireita().setPai(raiz);
              //  System.out.println(raiz.getDireita());
                primeiroCasoAdd(raiz.getDireita());
            }
        }
    }
    
    private void rotacaoLL(NoRN raiz){  // Rotação simples a direita
        System.out.println("Fez LL");

        if(raiz.getPai() ==  raiz.getPai().getPai().getEsquerda()){
            raiz.getPai().getPai().setEsquerda(raiz);
        }
        else{
            raiz.getPai().getPai().setDireita(raiz);
        }
        raiz.getPai().setEsquerda(raiz.getDireita());
        if(raiz.getDireita() != null){
            raiz.getDireita().setPai(raiz.getPai());
        }
        raiz.setDireita(raiz.getPai());
        raiz.setPai(raiz.getPai().getPai());
        raiz.getPai().setPai(raiz);

    }

    private void rotacaoRR(NoRN raiz) {  // Rotação simples a esquerda
        System.out.println("Fez RR");

        if (raiz.getPai() == raiz.getPai().getPai().getEsquerda()) {
            raiz.getPai().getPai().setEsquerda(raiz);
        } else {
            raiz.getPai().getPai().setDireita(raiz);
        }
        raiz.getPai().setDireita(raiz.getEsquerda());
        if (raiz.getEsquerda() != null) {
            raiz.getEsquerda().setPai(raiz.getPai());
        }
        raiz.setEsquerda(raiz.getPai());
        raiz.setPai(raiz.getPai().getPai());
        raiz.getPai().setPai(raiz);
    }

    private void primeiroCasoAdd(NoRN  raiz){  //Se for a raiz da arvore, só pintar de preto

        if(raiz == this.raiz){
        //    System.out.println("Primeiro");
            raiz.setCor(false);
        }
        else{
            segundoCasoAdd(raiz);
        }
    }

    private void segundoCasoAdd(NoRN  raiz){ //Se o pai for preto, a árvore está desbalanceada
        if(!(raiz.getPai().getCor())) { //Se o pai for preto não faz nada
        }
        else{
            terceiroCasoAdd(raiz);
        }
    }

    private void terceiroCasoAdd(NoRN  raiz) { //Se o pai for vermelho
        NoRN  t = tio(raiz); //Guarda a referência do tio da raiz
        NoRN  v = raiz.getPai().getPai(); //Guarda a referência do avô da raiz
        NoRN  p = raiz.getPai(); //Guarda a referência do pai da raiz
        if(t != null && t.getCor()){ // se o tio for vermelho e diferente de null
            t.setCor(false); //pinta o tio de preto
            p.setCor(false); //pinta o pai de preto
            v.setCor(true); // pinta o avô
            primeiroCasoAdd(v); //Volta para o primeiro caso passando o avô, o qual ficará desbalanceado
        }
        else{
            quartoCasoAdd(raiz);
        }

    }

    private void quartoCasoAdd(NoRN  raiz){ //Caso que utiliza as rotações para tentar deixar o avô, o pai, e a raiz alinhados
        NoRN  p = raiz.getPai();
        NoRN  v = raiz.getPai().getPai();
        if(p.getDireita() == raiz && v.getEsquerda() == p){ // Se o filho a direita do pai da raiz for a raiz e o filho a esquerdo do avô da raiz for o pai (Forma o "Joelho")
            rotacaoRR(raiz); //Faz rotação a esquerda na raiz
        }
        else if(p.getEsquerda() == raiz && v.getDireita() == p){ //Se o filho a esquerda do pai da raiz for a raiz e o filho a direta do avô da raiz for o pai (Forma o "Joelho)
            rotacaoLL(raiz);// Faz rotação a direita na raiz
        }
        quintoCasoAdd(raiz);

    }

    private void quintoCasoAdd(NoRN  raiz){ //Estão alinhados, muda cores e faz rotações no avô
        NoRN  p = raiz.getPai(); //Guarda a referência do pai da raiz
        raiz.setCor(false); //Seta a cor da raiz para preto
        p.setCor(true); //Set a cor do pai para vermelho

        if(p.getEsquerda() == raiz){  //se a raiz for filho a esquerda do pai
            if(p.getDireita() != null){ //se o irmão da raiz for diferente de null
                p.getDireita().setCor(false); //Seta a cor do irmão da raiz para preto

            }
            rotacaoLL(raiz);//faz rotação a direita na raiz
        }

        else{ //Se a raiz for filho a direita do pai
            if(p.getEsquerda() != null){ //se o irmão da raiz for diferente de null
                p.getEsquerda().setCor(false); //seta a cor do irmão da raiz para preto

            }
            rotacaoRR(raiz); //faz rotação a esquerda na raiz
        }
    }

    public void remove(int elemento){
      this.raiz = removeP(this.raiz, elemento);
    }

    private NoRN  removeP(NoRN  raiz, int elemento){
        NoRN novoNo = new NoRN(elemento);
        if(raiz == null){

        }
        else{

            int aux = novoNo.compareTo(raiz);
            if(aux > 0){
               raiz.setDireita(removeP(raiz.getDireita(), elemento));
            }
            else if(aux < 0){
               raiz.setEsquerda(removeP(raiz.getEsquerda(), elemento));
            }
            else{
                NoRN  sucessor;
                if(raiz.compareTo(this.raiz) < 0){
                    sucessor = sucessor(this.raiz.getEsquerda());
                }
                else{
                    sucessor = sucessor(this.raiz.getDireita());
                }
                if(raiz.getDireita() == null && raiz.getEsquerda() == null){
                    return null;
                }

                else if(raiz.getDireita() != null && raiz.getEsquerda() == null){
                    primeiroCasoDel(raiz, sucessor);
                    raiz = raiz.getDireita();
                }

                else if(raiz.getDireita() == null && raiz.getEsquerda() != null){
                    primeiroCasoDel(raiz, sucessor);
                    raiz = raiz.getEsquerda();
                }

                else{
                    raiz.setElemento(sucessor.getElemento());
                    primeiroCasoDel(raiz, sucessor);
                    if(raiz.compareTo(this.raiz) < 0){
                        removeP(raiz.getEsquerda(), sucessor.getElemento());
                    }
                    else{
                        removeP(raiz.getDireita(), sucessor.getElemento());
                    }
                }

            }

        }
        return raiz;
    }

    private void primeiroCasoDel(NoRN  raiz, NoRN  sucessor){
        if(raiz.getCor() && sucessor.getCor()){ // raiz vermelha e sucessor vermelho, não é para mudar
            System.out.println("Primeiro caso");
        }
        else{
            segundoCasoDel(raiz, sucessor);
        }
    }

    private void segundoCasoDel(NoRN  raiz, NoRN  sucessor){
        if(!(raiz.getCor()) && sucessor.getCor()){ //raiz preta e sucessor vermelho
            System.out.println("Segundo caso");
            sucessor.setCor(false); //Pinta o sucessor de preto
        }
        else{
            terceiroCasoDel(raiz, sucessor);
        }

    }

    private void terceiroCasoDel(NoRN  raiz, NoRN  sucessor){
        if(!(raiz.getCor()) && !(sucessor.getCor())){ //Raiz preta e sucessor preto
            System.out.println("Terceiro caso");
            NoRN  aux = achaFilho(sucessor); //Filho do sucessor
            NoRN  w = tio(aux); // tio do filho do sucessor
            System.out.println(w);

            if(w.getCor()){ //O irmão do filho do sucessor é vermelho, 3.1
                System.out.println("3.1");
                w.setCor(!w.getCor()); //Troca a cor tio
                aux.getPai().setCor(!aux.getPai().getCor()); //Troca a cor do pai do tio
                rotacaoRR(aux.getPai()); //Faz rotação a esquerda no pai do irmão do filho do sucessor
            }

            if(!(w.getCor()) && !(w.getDireita().getCor()) && !(w.getEsquerda().getCor())){ //O tio do filho do sucessor é preto e seus filhos são pretos, 3.2
                System.out.println("3.2");
                w.setCor(true); //pinta O tio do filho do sucessor de vermelho
                aux = aux.getPai(); //o filho do sucessor agora é o pai
            }

            if(!(w.getCor()) && w.getEsquerda().getCor() && !(w.getDireita().getCor())){ //O tio do filho do sucessor é preto, seu filho a esquerda é vermelho e seu filho a direita é preto, 3.3
                System.out.println("3.3");
                w.setCor(!w.getCor()); //Troca a cor do tio do filho do sucessor
                w.getEsquerda().setCor(!w.getEsquerda().getCor()); //troca a cor do filho a esquerda do tio do filho do sucessor
                rotacaoLL(w); //faz rotação a direita no tio do filho do sucessor
            }

            if(!(w.getCor()) && w.getDireita().getCor()){ // O tio do filho do sucessor é preto e o filho a direita dele é vermelho, 3.4
                System.out.println("3.4");
                rotacaoLL(aux.getPai()); //Faz rotação a direita no filho do sucessor
                w.setCor(aux.getPai().getCor()); //pinta o tio do filho do sucessor com a cor do sucessor
                aux.setCor(false); //Pinta o filho do sucessor de preto
                w.getDireita().setCor(false); //Pinta o tio a direita do irmão do filho do sucessor de preto
            }
        }

        else{
            quartoCasoDel(raiz, sucessor);
        }
    }

    private void quartoCasoDel(NoRN  raiz,  NoRN  sucessor){
        if(raiz.getCor() && !(sucessor.getCor())){ //A raiz é vermelha e o sucessor é preto
            System.out.println("Quarto caso");
            sucessor.setCor(true); //Pinta o sucessor de vermelho
            terceiroCasoDel(raiz, sucessor); //E chama o terceiroCaso novamente
        }

    }

    private NoRN  sucessor(NoRN  raiz){ //Função para pegar o menor valor a direita da raiz
        while(raiz != null && raiz.getEsquerda() != null){
            raiz = raiz.getEsquerda();
        }
        return raiz;
    }

    private NoRN  achaFilho(NoRN  raiz){ //Pegar o filho de uma raiz que possua 1 ou nenhum filho
        NoRN  filho = null;
        if(raiz == null){
            return null;
        }
        if(raiz.getEsquerda() != null){
            System.out.println("esquerda");
            filho = raiz.getEsquerda();
        }
        else if(raiz.getDireita() != null){
            filho = raiz.getDireita();
        }
        return filho;
    }

    private NoRN  acharIrmao(NoRN  raiz){ //Pegar o irmão de uma raiz
        NoRN  irmao= null;

        if(raiz.getPai().getEsquerda() != null && raiz.getPai().getEsquerda() != raiz){
            irmao = raiz.getPai().getEsquerda();
        }
        else if(raiz.getPai().getDireita() != null && raiz.getPai().getDireita() != raiz){
            irmao = raiz.getPai().getDireita();
        }
        return irmao;
    }

    public void preOrdem(){
        preOrdemP(this.raiz);
    }

    private void preOrdemP(NoRN  raiz){
        if(raiz == null){
            System.out.println("Árvore vazia!");
        }
        else {
            System.out.println(raiz + "");
            if (raiz.getEsquerda() != null) {
                preOrdemP(raiz.getEsquerda());
            }

            if (raiz.getDireita() != null) {
                preOrdemP(raiz.getDireita());
            }
        }
    }

    public int busca(int elemento){
        return buscaP(this.raiz, elemento);
    }

    private int buscaP(NoRN  raiz, int elemento){ // Busca simples
       NoRN novoNo = new NoRN(elemento);
        if(raiz == null){
            return -1; // no nao encontrado.
        }

        int aux = novoNo.compareTo(raiz);
        if(aux < 0){
            return buscaP(raiz.getEsquerda(), elemento);
        }
        else if(aux > 0){
            return buscaP(raiz.getDireita(), elemento);
        }
        else{
            return raiz.getElemento();
        }
    }

    private NoRN  tio(NoRN  raiz){ //Função para pegar o tio da raiz
        NoRN  tio = null;

        if(raiz.getPai().getPai().getEsquerda() != null && raiz.getPai().getPai().getEsquerda() != raiz.getPai()){
            tio = raiz.getPai().getPai().getEsquerda();
        }
        else if(raiz.getPai().getPai().getDireita() != null && raiz.getPai().getPai().getDireita() != raiz.getPai()){
            tio = raiz.getPai().getPai().getDireita();
        }

        return tio;
    }
}
