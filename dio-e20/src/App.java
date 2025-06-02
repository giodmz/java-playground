import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 20 - Faça um algoritmo que receba um valor inteiro e imprima na tela a sua
         * tabuada.
         */


        Scanner sc = new Scanner(System.in);
        System.out.print("Insira um número: ");
        int input = sc.nextInt();

        System.out.println("Número: " + input);
        for (int j = 1; j <= 10; j++) {
            System.out.println(input + " x " + j + " = " + (j * input));
        }

        sc.close();
    }
}
