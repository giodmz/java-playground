import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* 14 - Faça um algoritmo que receba um valor A e B, e troque o valor de 
        A por B e o valor de B por A e imprima na tela os valores.*/


        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Insira os valores de A e B");
        System.out.print("A: ");
        a = sc.nextInt();
        System.out.print("B: ");
        b = sc.nextInt();

        int c = a;
        a = b;
        b = c;

        System.out.println("A = " + a + " | B = " + b);
        

        sc.close();
    }
}
