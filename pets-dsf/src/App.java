import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        menuInicial();

    }

    private static void menuInicial() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\n1 - Cadastrar novo pet");
            System.out.println("2 - Alterar dados do pet cadastrado");
            System.out.println("3 - Deletar um pet cadastrado");
            System.out.println("4 - Listar todos os pets cadastrados");
            System.out.println("5 - Listar pets");
            System.out.println("6 - Sair");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    cadastroPet();
                    break;

                default:
                    break;
            }

        } catch (InputMismatchException ex) {
            System.out.println("\nFormato inválido, utilize apenas números para navegar.");
            menuInicial();
        }

        sc.close();

    }

    private static void cadastroPet() {
        try {
            String txtPath = "C:\\Studies\\java-playground\\pets-dsf\\src\\forms\\formulario.txt";

            Scanner in = new Scanner(new FileReader(txtPath));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }

            in.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
