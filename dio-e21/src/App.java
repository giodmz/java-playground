import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        /* 21 - Faça um algoritmo que mostre um valor aleatório entre 0 e 100.*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        
        Random random = new Random();
        int number = random.nextInt(101);
        
        System.out.println(number);

        sc.close();
    }
}
