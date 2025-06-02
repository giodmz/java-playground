public class App {
    public static void main(String[] args) throws Exception {
        /*18 - Francisco tem 1,50m e cresce 2 centímetros por ano, enquanto Sara tem 1,10m 
        e cresce 3 centímetros por ano. 
        Faça um algoritmo que calcule e imprima na tela em quantos 
        anos serão necessários para que Sara seja maior que Francisco. */

        double heightSara = 1.10;
        double heightFrancisco = 1.50;
        
        int count = 0;

        while (heightSara < heightFrancisco) {
            heightSara += 0.03;
            heightFrancisco += 0.02;
            count++;
        }

        // versao sem loop
        double crescimentoSara = 0.03;
        double crescimentoFrancisco = 0.02;

        double diferencaAltura = heightFrancisco - heightSara;
        double diferencaCrescimento = crescimentoSara - crescimentoFrancisco;

        int anos = (int) Math.ceil(diferencaAltura / diferencaCrescimento);

        double alturaFinalSara = heightSara + anos * crescimentoSara;
        double alturaFinalFrancisco = heightFrancisco + anos * crescimentoFrancisco;


        System.out.printf("Altura final Sara: %.2f\n", alturaFinalSara);
        System.out.printf("Altura final Francisco: %.2f\n", alturaFinalFrancisco);

        System.out.println("\nSerão necessários " + count + " anos para que Sara seja maior que Francisco");
        System.out.printf("Altura final Sara: %.2f", heightSara);
        System.out.printf("\nAltura final Francisco: %.2f", heightFrancisco);
        
    }
}
