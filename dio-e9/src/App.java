import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*9 - Faça um algoritmo que calcule o IMC (Índice de Massa Corporal) de uma pessoa, leia o seu peso e sua altura e imprima na tela sua condição 
        de acordo com a tabela abaixo:
        Fórmula do IMC = peso / (altura) ²
        
        Tabela Condições IMC

        Abaixo de 18,5   | Abaixo do peso          
        Entre 18,6 e 24,9 | Peso ideal (parabéns)  
        Entre 25,0 e 29,9 | Levemente acima do peso
        Entre 30,0 e 34,9 | Obesidade grau I 
        Entre 35,0 e 39,9 | Obesidade grau II (severa)
        Maior ou igual a 40 | Obesidade grau III (mórbida) */

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira seu dados: ");
        System.out.print("Altura: ");
        double height = sc.nextFloat();
        System.out.print("Peso: ");
        double weight = sc.nextFloat();

        double imcCalc = weight / Math.pow(height, 2);

        if (imcCalc <= 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imcCalc >= 18.6 && imcCalc <= 24.9) {
            System.out.println("Peso ideal");
        } else if (imcCalc >= 25.0 && imcCalc <= 29.9) {
            System.out.println("Levemente acima do peso");
        } else if (imcCalc >= 30.0 && imcCalc <= 34.9){
            System.out.println("Obesidade grau I");
        } else if (imcCalc >= 35.0 && imcCalc <= 39.9){
            System.out.println("Obesidade grau II");
        } else if (imcCalc >= 40.0){
            System.out.println("Você é o decau");
        }


        sc.close();
    }
}
