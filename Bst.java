package nicebtree;

import java.util.Scanner;

class Bst {
    
    static class No { 
        int conteudo;
        No esquerda;
        No direita;

    public No(int c){
        conteudo = c;
        esquerda = null;
        direita = null;  
    }
    }

    static class Arv{
        No raiz;
        int quant;

        public Arv(){
            raiz = null;
            quant = 0;
        }
        
        //insere elemento na raiz;
        public void insereRaiz(int v){
            No no = new No(v);
            raiz = no;
        }
        
        //insere elementos na arvore;
        public void insere(int v, No n){
            quant++;
            //se o elemento a ser inserido for menor que o conteudo;
            if (v < n.conteudo){
		if (n.esquerda == null){
                    n.esquerda = new No(v);
		}else{
                    insere(v, n.esquerda);
		}
            }
            //se o elemento a ser inserido for maior que o conteudo;
            else if (v > n.conteudo) {
            	if (n.direita == null){
                    n.direita = new No(v);
		}else{
                    insere(v, n.direita);
		}
            }
        } 
    }
  

    public static void main(String[] args) throws java.lang.Exception{

        Scanner sc = new Scanner(System.in);
        Arv arvore = new Arv();
        
        int tamanho = sc.nextInt();

        for (int i = 0; i < tamanho; i++) {
            
            //se i for diferente de 0 já existe uma raiz;
            if(i != 0){
                arvore.insere(sc.nextInt(), arvore.raiz);
                System.out.println(arvore.quant);
            }else{  //senão insere a raiz;
                arvore.insereRaiz(sc.nextInt());
                System.out.println(arvore.quant);
            }
        }
    }
}