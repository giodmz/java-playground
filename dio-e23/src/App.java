import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*23 - Faça um algoritmo que efetue o cálculo do salário líquido de um professor. 
        As informações fornecidas serão: valor da hora aula, número de aulas lecionadas no mês 
        e percentual de desconto do INSS. Imprima na tela o salário líquido final. */

        Scanner sc = new Scanner(System.in);
        System.out.println("Forneça os dados do professor: ");
        System.out.print("Valor da hora aula: ");
        double value = sc.nextDouble();
        System.out.print("Número de aulas lecionadas (mensal): ");
        int classes = sc.nextInt();
        

        double salary = value * classes; 

        Professor professor = new Professor(value, classes);


        // System.out.println(professor.toString());
        System.out.println(professor.inssCalc(salary));



        sc.close();
    }
}
