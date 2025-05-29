import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* 6 - Faça um algoritmo que leia um valor qualquer e imprima na tela com um reajuste de 5%.*/
        Locale.setDefault(Locale.US);
        double fix = 0.0;


        Scanner sc = new Scanner(System.in);
        System.out.print("Insira um valor: ");
        double input = sc.nextDouble();

        double percentage = (5.0 / input) * 100;
        fix = input + percentage;

        System.out.printf("Valor inicial: %.2f", input);
        System.out.printf("\nReajuste (+ 5%%): %.2f", fix);



        sc.close();
    }
}
