package nicebtree;

import java.util.Scanner;

public class Omwg {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int quantidade, resultado;
        int linha, coluna;
        
        quantidade = sc.nextInt();
        
        while(quantidade != 0){
            linha = sc.nextInt();
            coluna = sc.nextInt();
            System.out.println(((2* linha * coluna) - linha - coluna));
            quantidade--;
        }
    }    
}
