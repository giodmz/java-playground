import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*17 - Faça um algoritmo que leia uma temperatura em Fahrenheit 
        e calcule a temperatura correspondente em grau Celsius. 
        Imprima na tela as duas temperaturas.
        Fórmula: C = (5 * ( F-32) / 9) */

        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a temperatura em Farenheit: ");
        float temp = sc.nextFloat();
        
        float tempC = (5 * (temp - 32) / 9);

        System.out.printf("Farenheit: %.2f ", temp);
        System.out.printf("| Celsius: %.2f", tempC);




        sc.close();
    }
}
