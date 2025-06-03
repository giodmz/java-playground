package entities;

import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.enums.*;
import entities.models.Endereco;
import entities.models.Pet;


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
                Scanner sc = new Scanner(System.in);

                System.out.println(in.nextLine());
                String nome = sc.nextLine();

                System.out.println(in.nextLine());
                String inputTipo = sc.nextLine();

                System.out.println(in.nextLine());
                String inputSexo = sc.nextLine();

                System.out.println(in.nextLine());
                System.out.print("Número da casa: ");
                Integer num = sc.nextInt();
                sc.nextLine();
                System.out.print("Cidade: ");
                String cidade = sc.nextLine();
                
                System.out.print("Rua: ");
                String rua = sc.nextLine();

                Endereco endereco = new Endereco(num, cidade, rua);

                System.out.println(in.nextLine());
                Integer idade = sc.nextInt();

                System.out.println(in.nextLine());
                Double peso = sc.nextDouble();

                System.out.println(in.nextLine());
                String raca = sc.next();


                Tipo tipo = Tipo.valueOf(inputTipo.toUpperCase());
                Genero sexo = Genero.valueOf(inputSexo.toUpperCase());

                Pet pet = new Pet(nome, tipo, sexo, endereco, idade, peso, raca);
                
                System.out.println(pet.toString());
                System.out.println(endereco.toString());


                sc.close();
            }

            in.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
