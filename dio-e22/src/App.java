import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*22 - Faça um algoritmo que leia dois valores inteiros A e B, 
        imprima na tela o quociente e o resto da divisão inteira entre eles. */
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira os números: ");
        System.out.print("A: ");
        double a = sc.nextDouble();
        System.out.print("B: ");
        double b = sc.nextDouble();

        double div = a / b;
        double sob = a % b;

        System.out.printf("A / B = %.2f", div);
        System.out.printf("\nA /! B = %.2f", sob);



        sc.close();
    }
}
