import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*
        24 - Faça um algoritmo que calcule a quantidade de litros de combustível gastos em 
        uma viagem, sabendo que o carro faz 12km com um litro. 
        Deve-se fornecer ao usuário o tempo que será gasto na viagem a sua velocidade média, 
        distância percorrida e a quantidade de litros utilizados para fazer a viagem. 

        Fórmula: distância = tempo x velocidade.
        litros usados = distância / 12. 
        */

        double consumoCarro = 12;

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a velocidade(km/h): ");
        double velocidade = sc.nextDouble();
        System.out.println("Digite a distância(km): ");
        double distancia = sc.nextDouble();

        double tempoGasto = distancia / velocidade;
        double listrosConsumidos = distancia / consumoCarro;
        double velocidadeMedia = distancia / tempoGasto;

        System.out.println("\nRelatório de Viagem: ");
        System.out.println("-----------------------------------");
        System.out.printf("Tempo que será gasto: %.2fh", tempoGasto);
        System.out.printf("\nVelocidade média: %.2fkm/h", velocidadeMedia);
        System.out.printf("\nGasto de combustível: %.2fL", listrosConsumidos);




        sc.close();


    }
}
