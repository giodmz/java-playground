import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* 8 - Faça um algoritmo que leia três valores inteiros diferentes 
        e imprima na tela os valores em ordem decrescente.*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Insira três números: ");
        
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        int v3 = sc.nextInt();
        
        Integer[] values = {v1, v2, v3};
        
        Arrays.sort(values, Comparator.reverseOrder());

        System.out.println("Resultado: ");
        
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i < values.length -1) {
                System.out.print(", ");
            }            
        }

        sc.close();
    }
}
