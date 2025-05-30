import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* 13 - Faça algoritmo que leia o nome e a idade de uma pessoa e 
        imprima na tela o nome da pessoa e se ela é maior ou menor de idade.*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Insira os dados a seguir: ");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Idade: ");
        Integer idade = sc.nextInt();

        System.out.print("\nNome: " + nome);
        if (idade >= 18) {
            System.out.print(" | Maior de idade");
        } else {
            System.out.print(" | Menor de idade");
        }


        sc.close();
    }
}
