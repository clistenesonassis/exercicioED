import java.util.Scanner;

class Onp {
    
   private char dados[];
   private int topo;
   private int tamMax;
   
   public Onp(int tam){
       tamMax = tam;
       dados = new char[tamMax];
       topo = -1;
   }
   
   public boolean vazio(){
       return topo == -1;
   }
   
   public boolean cheia(){
       return topo == (tamMax -1);
   }
   
   public int tamanhoPilha(){
       return (topo + 1);
   }
   
   public char consultaTopo() throws Exception{
       if(vazio())
           throw new Exception();  //se a pilha estiver vazia;
       else
           return dados[topo];
   }
   
   public boolean insereElemento(char nome){
       if(cheia())
           return false;    //verifica se a pilha está cheia;
       else{
           dados[++topo] = nome;
           return true;
       }          
   }
   
   public char removeElemento() throws Exception{
       if(vazio())
           throw new Exception();    //verifica se a lista está vazia; Erro: Lista Vazia.
       else
           return dados[topo--];
   }      
    

    public static void main(String[] args) throws Exception{
 
        int quant;
        Onp p1 = new Onp(100);
        Onp p2 = new Onp(100);
        Onp pAux = new Onp(100);
        String expressao;
        
        Scanner s = new Scanner(System.in);
        
        quant = s.nextInt();
        
        for(int i = 0; i < quant; i++){     //número de expressões;
            expressao = s.next();
            for(int j = 0; j < expressao.length(); j++){    //cada elemento da expressão;
                if(expressao.charAt(j) != ')'){
                    switch(expressao.charAt(j)){    //separação das pilhas;
                        case '(':
                            break;
                        case '*':
                            p1.insereElemento(expressao.charAt(j));
                            break;
                        case '+':
                            p1.insereElemento(expressao.charAt(j));
                            break;
                        case '^':
                            p1.insereElemento(expressao.charAt(j));
                            break;
                        case '/':
                            p1.insereElemento(expressao.charAt(j));
                            break;
                        case '-':
                            p1.insereElemento(expressao.charAt(j));
                            break;
                        default:
                            p2.insereElemento(expressao.charAt(j));
                        
                    }
                
                }else{      
                    while(p2.vazio() != true)    //passando para pilha auxliar para inverter a ordem;
                        pAux.insereElemento(p2.removeElemento());
                    
                    while(pAux.vazio() != true)
                        System.out.print(pAux.removeElemento());	//printando a pilha aux que agora está na ordem correta;
                    
                    System.out.print(p1.removeElemento());	//printando os caracteres: ^, +, -, /, *
                }
                
            }
            System.out.println(" ");
        }
                
    }

    
}

