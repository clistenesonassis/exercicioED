
package treeord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author clistenes
 */
public class Treeord {

    //Variáveis que será utilizada pelas classes;
    static int preIndc = 0;
    static int inIndc = 0;
    static int posIndc = 0;
    
    //variável de decisão(pré[], pós[], in[] pertence a mesma arvore ou não);
    static boolean treeOrd = true;
    
    //árvore;
    static ArvoreBinaria arvore;
    
    //array onde receberão os elementos;
    static String pre[];
    static String pos[];
    static String in[];
    
    static class No{
        private int conteudo;
        private No esq;
        private No direita;
        
        //construtor;
        public No(int c){
          this.conteudo = c;
        }

        //retorn conteudo do No;
        public int getConteudo(){
          return conteudo;
        }
        
        //insere conteudo no nó;
        public void setConteudo(int c){
          conteudo = c;
        }
        
        //retorna No da esquerda da raiz atual;
        public No getEsq(){
          return esq;
        }
        
        //insere no No da esquerda da raiz atual;
        public void setEsq(No e){
          esq = e;
        }
        
        //retorna No da direita da raiz atual;
        public No getDireita(){
          return direita;
        }
        
        //insere no No da direita da raiz atual;
        public void setDireita(No d){
          direita = d;
        }
        
    }
    
    //Arvore Binária;
    static class ArvoreBinaria {
        No raiz;

        //construtor da Arvore Binária;
        public ArvoreBinaria(){
          raiz = null;
        }
        
        //insere elemento na raiz;
        public void setRaiz(No r){
          raiz = r;
        }

        //realiza uma busca na raiz;
        public No busca(int valor){
          return busca(raiz,valor);
        }
        
        //realiza uma busca em determinado nó;
        private No busca(No n, int valor){
          if(n == null)
            return null;

          if(n.getConteudo() == valor)
            return n;

          No aux = busca(n.getEsq(), valor);
          if (aux == null)
            aux = busca(n.getDireita(), valor);

          return aux;
        }
        
        //caminha por toda a árvore em ordem prefixa;
        private void preOrdem(No n){
          if (n == null)
            return;

          if(n.getEsq() != null)
            preOrdem(n.getEsq());

          if(n.getDireita() != null)
            preOrdem(n.getDireita());
        }

        //caminha por toda a árvore em ordem infixa;
        private void inOrdem(No n){
          if (n == null || !treeOrd)
            return;

          if(n.getEsq() != null)
            inOrdem(n.getEsq());

          if( n.getConteudo() != Integer.parseInt(in[inIndc++]) ){
            treeOrd = false;
            return;
          }

          if(n.getDireita() != null)
            inOrdem(n.getDireita());
        }

        //caminha por toda a árvore em ordem sufixa;
        private void posOrdem(No n){
          if (n == null || !treeOrd)
            return;

          if(n.getEsq() != null)
            posOrdem(n.getEsq());

          if(n.getDireita() != null)
            posOrdem(n.getDireita());

          if(n.getConteudo() != Integer.parseInt(pos[posIndc++])){
            treeOrd = false;
          }

        }

    }
    
    //estrutura a arvore;
    static No MontaArvore(int inicio, int fim){

        //condição inválida;
        if(inicio > fim)
          return null;
        
        //valor da raiz;
        int raiz = Integer.parseInt(pre[preIndc++]);
        
        //instancia do nó passando a raiz;
        No no = new No(raiz);

        //condição na qual exite apenas a raiz na árvore;
        if(inicio == fim){
          return no;
        }
        
        int indece = 0;
        //indice de onde se encontra a raiz na ordem infixa;
        for (int i = inicio; i <= fim ; i++) {
          if(Integer.parseInt(in[i]) == raiz)
            indece = i;
        }
        

        //preencher a esquerda da árvore;
        No esq = MontaArvore(inicio, indece - 1);
        if(esq != null)
          no.setEsq(esq);

        //preencher a direita da árvore;
        No direita = MontaArvore(indece + 1, fim);
        if(direita != null)
          no.setDireita(direita);

        return no;
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try{
            //numero de elementos da árvore;
            int numElementos;

            //carrega o buffer;
            BufferedReader entrada;
            entrada = new BufferedReader(new InputStreamReader(System.in));

            //numero de elementos;
            numElementos = Integer.parseInt(entrada.readLine());

            //instancia Arrays;
            pre = new String[numElementos];
            pos = new String[numElementos]; 
            in = new String[numElementos]; 

            //preenchendo os arrays;
            String g = entrada.readLine();
            pre = g.split(" ");

            g = entrada.readLine();
            pos = g.split(" ");

            g = entrada.readLine();
            in = g.split(" ");

            //condições que inicialmente pode ser negado;
            if(Integer.parseInt(pre[0]) != Integer.parseInt(pos[numElementos-1])){;
                System.out.println("no");
                return;
             }
            if((pre.length != pos.length) || (pre.length != in.length) || (in.length != pos.length)){
                System.out.println("no");
                return;
            }

            //instancia da árvore binária;
            arvore = new ArvoreBinaria();

            //montando arvore e retornando o No;
            No raiz = MontaArvore(0, numElementos - 1);

            //inserindo a raiz;
            arvore.setRaiz(raiz);

            //realizando caminho ordem prefixa;
            arvore.preOrdem(raiz);

            //realizando caminho ordem infixa;
            arvore.inOrdem(raiz);

            //realizando caminho ordem sufixa;
            arvore.posOrdem(raiz);


            if(treeOrd)
                System.out.println("yes");
            else
                System.out.println("no");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
 
    }
    
}
