import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* 4 - Faça um algoritmo que receba um número inteiro 
        e imprima na tela o seu antecessor e o seu sucessor. */

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número inteiro: ");
        int input = sc.nextInt();

        int plus = input + 1;
        int minus = input - 1;

        System.out.println("Antecessor: " + minus + " | Sucessor: " + plus);

        sc.close();
    }
}
