import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        /*Faça um algoritmo que leia os valores de A, B, C e 
        em seguida imprima na tela a soma entre A e B é mostre se a soma é menor que C. */

        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        int c;
        
        System.out.println("Digite os valores: ");
        System.out.print("A:");
        a = sc.nextInt();
        System.out.print("B:");
        b = sc.nextInt();
        System.out.print("C:");
        c = sc.nextInt();

        int sum = a + b;
        System.out.println("A + B = " + sum);

         if (sum < c) {
            System.out.println("C é maior que a soma entre A e B");
        } else if (sum == c) {
            System.out.println("C é igual à soma entre A e B");
        } else {
            System.out.println("C é menor que a soma entre A e B");
        }
        

        sc.close();

    }
}
