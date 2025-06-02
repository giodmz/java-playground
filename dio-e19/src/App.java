public class App {
    public static void main(String[] args) throws Exception {
        /*19 - Faça um algoritmo que imprima na tela a tabuada de 1 até 10.*/

        for (int i = 1; i <= 10; i++) {
            System.out.println("------- " + i +" -------");
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));  
            }
            System.out.println();
            
        }


    }
}
