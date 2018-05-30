
import java.util.Scanner;

class HashSpoj {

    static class  Hash{
        private String[] conteudo;
        private int tam = 0;
        
        public Hash(){
            conteudo = new String[101];
            
            for(int m=0; m<101; m++){
                conteudo[m] = "";                
            }
        }
        
        public int Hash(String chave){
            char array[] = chave.toCharArray();
            int h_conteudo=0;
            int soma=0;
                        
            for(int i=0; i < chave.length(); i++){
                soma = soma + (((int)array[i]) * (i+1));
            }
            h_conteudo = 19*soma;
            
            return h_conteudo%101;
        }
          
        public int add(String chave){
            int posicao = Hash(chave); 
            int aux = posicao;
            int count=0;            
            
            for(count= 0; count < 20;){                
               
               if(conteudo[aux].equals(chave)){
                   return 0;
               }               
             
               else{
                   count++;
                   aux = (Hash(chave)+(count*count)+(23*count))%101;                   
               }
            } 
            
            
            for(count=0; count<20;){              
               if(conteudo[posicao].equals("") || conteudo[posicao].equals("empty")){
                   conteudo[posicao] = chave;
                   tam++;
                   return 1;               
               }
               else{
                   count++;
                   posicao = (Hash(chave)+(count*count)+(23*count))%101;                   
               }
            } 
            
            return 0;
        }
        
        public void remove(String chave){
            int posicao = busca(chave);
            
            if(posicao!= -1){
                conteudo[posicao] = "empty";
                tam --;
            }  
        }
        
        public int busca(String chave){
            int posicao = Hash(chave); 
            int count=0;
            
            for(count = 0; count < 20 ; ){
               if(conteudo[posicao].equals(chave)){
                   return posicao;
               }               
               else{
                   count++;
                   posicao = (Hash(chave)+(count*count)+(23*count))%101;                   
               }
            }
            
            return -1;
        }
        
        public int getTamanho (){
            return tam;
        }
        
        public String getConteudo(int posicao){
            return conteudo[posicao];
        }
              
        
    }
    
        
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 
        int teste, operacoes;
        int l=0,k=0;
        String opt;
        
        teste = scanner.nextInt();
        
        Hash casos[] = new Hash[teste];
        
        while(l<teste){
            casos[l] = new Hash();
            
            operacoes = scanner.nextInt();
        
            scanner.nextLine();
            for( k = 0 ; k < operacoes; k++){
                opt = scanner.nextLine();
                
                if(opt.startsWith("ADD")){
                    casos[l].add(opt.substring(4));
                }
                
                if(opt.startsWith("DEL")){
                    casos[l].remove(opt.substring(4));
                }               
            }
            
            System.out.println(casos[l].getTamanho());
            
            for(k=0; k<101; k++){
                if(!(casos[l].getConteudo(k).equals("")) && !(casos[l].getConteudo(k).equals("empty")) ){
                    System.out.println(k + ":" + casos[l].getConteudo(k));
                }
            }
           
            l++;
        }       
       
    }
    
}