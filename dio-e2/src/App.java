import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       /*2 - Faça um algoritmo para receber um número qualquer
        e imprimir na tela se o número é par ou ímpar, positivo ou negativo. */
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite um número: ");
        int num = sc.nextInt();

        if (num > 0) {
            System.out.print("O número é positivo e é ");
        } else {
            System.out.println("O número é negativo e é ");
        }

        if (num % 2 == 0) {
            System.out.println("par");
        } else {
            System.out.println("impar");
        }


        sc.close();
    }
}
