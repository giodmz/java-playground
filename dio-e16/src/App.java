import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 16 - Faça um algoritmo que leia três valores que representam
         * os três lados de um triângulo e verifique se são válidos,
         * determine se o triângulo é equilátero, isósceles ou escaleno.
         */

        // equilatero = todos os lados iguais
        // isoceles = dois lados iguais
        // escaleno = todas medidas diferentes

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite as medidas do triângulo");
        System.out.print("X: ");
        double x = sc.nextDouble();
        System.out.print("Y: ");
        double y = sc.nextDouble();
        System.out.print("Z: ");
        double z = sc.nextDouble();

        if (x > 0 && y > 0 && z > 0 && x + y + z == 180) {
             if (x == y && y == z) {
                System.out.println("O triângulo é equilátero.");
            } else if (x == y || y == z || z == x) {
                System.out.println("O triângulo é isósceles.");
            } else {
                System.out.println("O triângulo é escaleno.");
            }
        } else {
            System.out.println("O triângulo é inválido");
        }
        

        sc.close();
    }
}
