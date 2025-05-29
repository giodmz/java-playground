import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        /*7 - Faça um algoritmo que leia dois valores booleanos (lógicos) 
        e determine se ambos são VERDADEIRO ou FALSO. */

        boolean x;
        boolean y;

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os seguintes valores: ");

        System.out.print("X: ");
        x = sc.nextBoolean();
        System.out.print("Y: ");
        y = sc.nextBoolean();

        if (x == y) {
            System.out.println("Ambos são falsos ou verdadeiros");
        } else {
            System.out.println("Um valor é falso e o outro verdadeiro");
        }

        sc.close();
    }
}
