import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* 10 - Faça um algoritmo que leia três notas obtidas por um aluno, e imprima na tela a média das notas.*/

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite as notas:");
        System.out.print("Nota 1: ");
        float n1 = sc.nextFloat();
        System.out.print("Nota 2: ");
        float n2 = sc.nextFloat();
        System.out.print("Nota 3: ");
        float n3 = sc.nextFloat();

        float medCalc = (n1 + n2 + n3) / 3;

        System.out.printf("Sua média foi: %.2f", medCalc);

        sc.close();
    }
}
