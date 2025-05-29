import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*3 - Faça um algoritmo que leia dois valores inteiros A e B, 
        se os valores de A e B forem iguais, deverá somar os dois valores, 
        caso contrário devera multiplicar A por B. 
        Ao final de qualquer um dos cálculos deve-se atribuir o resultado a uma variável C 
        e imprimir seu valor na tela. */


        int a;
        int b;
        int c;

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os valores: ");
        System.out.print("A: ");
        a = sc.nextInt();
        System.out.print("B: ");
        b = sc.nextInt();
        
        int sum = 0;
        if (a == b){
            sum = a + b;
        } else {
            sum = a * b;
        }

        c = sum;

        System.out.println("Valor de C é = " + c);

        
        
        
        



        sc.close();
    }
}
