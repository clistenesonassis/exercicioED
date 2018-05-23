import java.util.*;
import java.lang.*;

class NiceBTree{
    
    public static void main (String[] args) throws java.lang.Exception{
        try{
            Scanner sc = new Scanner(System.in);
            boolean[] corrente;
            char[] caminhoArray;
            int quantTest;
            quantTest = Integer.parseInt (sc.nextLine());
            
            //laço para a quantidade de testes;
            for(int i = 0; i < quantTest; i++){
                int aux = 0, profundidade = 0;
                String caminho = sc.nextLine();
                corrente = new boolean [caminho.length()];
                
                //caso trivial;
                if (caminho.charAt(0) == 'l') {
                    System.out.println(0);
                    continue;
                }
                
                corrente[0] = true;
                caminhoArray = new char[caminho.length()];

                //armazena cada elemento de entrada no array;
                for(int j = 0; j < caminho.length(); j++){
                    caminhoArray[j] = caminho.charAt(j);
                }
                
                //varre o array e analisa os elementos;
                for (int j = 0; j < caminho.length(); j++) {
                    
                    //se o elemento for igual a n;
                    if (caminhoArray[j] == 'n'){
                        corrente[++aux] = true;
                    }
                    
                    //se o elemento for igual a 1;
                    if (caminhoArray[j] == 'l'){
                        while(corrente[aux] != true)
                            aux--; 
                        corrente[aux] = false;
                    }
                    
                    //compara a saida com o aux e retorna o maior;
                    profundidade = Math.max(profundidade, aux);
                }
                //imprime a saída;
                System.out.println(profundidade);
            }
            
        }catch(Exception ex){}
    }
}