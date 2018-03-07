
package exercicio1lp2;

import java.util.Scanner;

/**
 *
 * @author clistenes
 */
public class Exercicio1Lp2 {
    
     private int dados[];
    private int tamAtual;
    private int tamMax;
    
    public Exercicio1Lp2(){
        tamMax = 100;
        tamAtual = 0;
        dados = new int[tamMax];        
    }
    
    
    public boolean cheia(){     //retorna se a lista está cheia;
        if(tamAtual == tamMax) return true;
        else return false;        
    }
    
    public int tamanho(){   //retorna tamanho da lista;
        return tamAtual;
    }
    
    public int elemento(int pos)   {      //retorna o elemento que pertence a determinada posição;
        int dado;
        
        if( (pos > tamAtual) || (pos <= 0) ){       //vai lançar uma exeção se a posição não pertencer ao array;
            return -1;
        }
        dado = dados[pos -1];
        return dado;        
    }
    
    public int posicao(int dado){       //retorna a posição onde o determinado dado se encontra;
        
        for (int i = 0; i < tamAtual; i++) {
            if(dados[i] == dado){
                return  (i + 1);
            }
        }
        
        return -1;
    }
    
    public boolean insere(int pos, int dado){
        if( cheia() || (pos <= 0) || (pos > (tamAtual + 1) ) ){
            return false;
        }
        
        for (int i = tamAtual; i >= pos ; i--) {
            dados[i] = dados[i -1];
        }
        
        dados[pos -1] = dado;
        tamAtual++;
        return true;        
    }
    
    public int remove(int pos){
        int dado;
        if ((pos > tamAtual) || (pos < 1) ) {
            return -1;
        }
        dado = dados[pos-1];
        for (int i = (pos -1); i < tamAtual; i++) {
            dados[i] = dados[i+1];
        }
        tamAtual--;
        return dado;
    }
    

    public static void main(String[] args) {
        
         int quant1, quant2, tamList3, element1, element2 ;
        boolean naoPertence = true;
        
        Scanner c = new Scanner(System.in);
        quant1 = c.nextInt();       //lendo primeiro inteiro, quantidade de numeros do primeiro array;
        
        Exercicio1Lp2 list1 = new Exercicio1Lp2();      //criando as listas;
        Exercicio1Lp2 list2 = new Exercicio1Lp2();      //instância da classe Lista;
        Exercicio1Lp2 list3 = new Exercicio1Lp2();      
        
        for (int i = 1; i < (quant1 +1); i++) {     //adicionando os inteiros da primeira lista;
            list1.insere(i, c.nextInt());
        }
        
        
        quant2 = c.nextInt();       //lendo quantidade de numeros da segunda lista;
        
        for (int i = 1; i < (quant2 + 1); i++) {      //adicionando os inteiros da segunda lista;
            list2.insere(i, c.nextInt());
        }
        
        quant1 = list1.tamanho();
        quant2 = list2.tamanho();
        for (int i = 1; i < (quant1 + 1); i++) {     //fazendo a comparação dos duas listas e extraindo os valores que são comuns as mesmas;
            element1 = list1.elemento(i);
            
            for (int j = 1; j < (quant2 + 1); j++) {
                element2 = list2.elemento(j);
                if (element1 == element2) {
                    naoPertence = false;
                }
                
            }
            
            if (naoPertence) {
                tamList3 = (list3.tamanho() + 1);
                list3.insere(tamList3, list1.elemento(i));
            }
            naoPertence = true;
        }

        tamList3 = (list3.tamanho() + 1);
        for (int i = 1; i < tamList3; i++) {
            System.out.printf("%d ", list3.elemento(i));
        }
        
        
    }
    
}
