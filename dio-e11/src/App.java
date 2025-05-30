import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* 11 - Faça um algoritmo que leia quatro notas obtidas por um aluno, 
        calcule a média das nota obtidas, 
        imprima na tela o nome do aluno e se o aluno foi aprovado ou reprovado. 
        Para o aluno ser considerado aprovado sua média final deve ser maior ou igual a 7. */
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        System.out.println("Insira os dados do aluno: ");
        System.out.print("Nome: ");
        String nome = sc.next();
        
        double nota = 0.0;
        for (int i = 0; i < 4; i++) {
            System.out.print("Nota #" + (i + 1) + ": ");
            double n = sc.nextDouble();
            nota += n;
        }

        Aluno aluno = new Aluno(nome, nota);
        
        System.out.println("\nNome: " + aluno.getNome());
        System.out.print("Situação: " );

        if (aluno.aprovadoCalc(nota) >= 7) {
            System.out.println("Aprovado, média final: " + aluno.aprovadoCalc(nota));
        } else {
            System.out.println("Reprovado, média final: " + aluno.aprovadoCalc(nota));
        }

        sc.close();
    }
}
