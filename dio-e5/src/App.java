import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* 5 - Faça um algoritmo que leia o valor do salário mínimo 
        e o valor do salário de um usuário, calcule quantos salários mínimos esse 
        usuário ganha e imprima na tela o resultado. (Base para o Salário mínimo R$ 1.293,20). */

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        double minSalary = 1293.20;

        System.out.print("Digite o salário: ");
        double userSalary = sc.nextDouble();

        double countMinSalary = userSalary / minSalary;
        System.out.printf("Salário mínimo base: %.2fR$", minSalary);
        System.out.printf("\nO salário equivale a %.2f salário(s) mínimo(s)", countMinSalary);

        sc.close();
    }
}
