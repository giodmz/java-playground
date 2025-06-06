package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.enums.*;
import entities.exceptions.InputException;
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
            System.out.println("5 - Listar pets por algum critério");
            System.out.println("6 - Sair");
            Integer input = sc.nextInt();

            switch (input) {
                case 1:
                    cadastroPetMenu();
                    break;
                case 5:
                    menuBuscarDados();

                default:
                    break;
            }

            if (input <= 0) {
                throw new InputException("Por insira um número válido.");
            }

        } catch (InputMismatchException ex) {
            System.out.println("\nFormato inválido, utilize apenas números para navegar.");
            menuInicial();
        } catch (InputException ex) {
            System.out.println("\nErro: " + ex.getMessage());
            menuInicial();
        }

        sc.close();

    }

    private static void cadastroPetMenu() {
        try {
            String txtPath = "C:\\Studies\\java-playground\\pets-dsf\\src\\forms\\formulario.txt";
            final String NAO_INFORMADO = "NÃO INFORMADO";

            Scanner in = new Scanner(new FileReader(txtPath));

            while (in.hasNextLine()) {
                Scanner sc = new Scanner(System.in);

                System.out.println(in.nextLine());
                String nome = sc.nextLine();
                if (nome.isEmpty()) {
                    nome = NAO_INFORMADO;
                }

                if (nome.trim().split("\\s+").length < 2) {
                    throw new InputException("Por favor insira o nome e o sobrenome.");
                }
                if (!nome.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
                    throw new InputException("O nome não pode conter números ou caracteres especiais.");
                }

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

                if (idade >= 22) {
                    throw new InputException("Insira uma idade válida");
                }

                System.out.println(in.nextLine());
                Double peso = sc.nextDouble();
                sc.nextLine();

                System.out.println(in.nextLine());
                String raca = sc.nextLine();

                if (!raca.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
                    throw new InputException("O nome não pode conter números ou caracteres especiais.");
                }

                Tipo tipo = Tipo.valueOf(inputTipo.toUpperCase());
                Genero sexo = Genero.valueOf(inputSexo.toUpperCase());

                Pet pet = new Pet(nome, tipo, sexo, endereco, idade, peso, raca);
                pet.cadastrarPet(pet);

                System.out.println(pet.toString());
                System.out.println(endereco.toString());

                sc.close();
            }

            in.close();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            cadastroPetMenu();
        } catch (InputException ex) {
            System.out.println("Erro: " + ex.getMessage());
            cadastroPetMenu();
        } catch (InputMismatchException ex) {
            System.out.println("Erro: " + ex.getMessage());
            cadastroPetMenu();
        }

    }

    public static void menuBuscarDados() {
        Scanner sc = new Scanner(System.in);
        File pasta = new File("C:\\Studies\\java-playground\\pets-dsf\\src\\pets");

        System.out.println("\nEscolha um ou dois critérios de busca:");
        System.out.println("1 - Nome ou sobrenome");
        System.out.println("2 - Sexo");
        System.out.println("3 - Idade");
        System.out.println("4 - Peso");
        System.out.println("5 - Raça");
        System.out.println("6 - Endereço");

        // recebendo os critérios
        System.out.print("\nInforme o primeiro critério (1-6): ");
        int criterio1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Insira a informação: ");
        String valor1 = sc.nextLine().toLowerCase();

        System.out.print("Deseja adicionar um segundo critério? (s/n): ");
        String opcao = sc.nextLine().toLowerCase();
        int criterio2 = -1;
        String valor2 = "";

        if (opcao.equals("s")) {
            System.out.print("Informe o segundo critério (1-6): ");
            criterio2 = sc.nextInt();
            sc.nextLine();
            System.out.print("Insira a informação: ");
            valor2 = sc.nextLine().replace("\n", ",");
        }

        System.out.println("\nResultados encontrados:");


        // passar pelos arquivos .txt da pasta pets (referenciada pelo pasta)
        File[] arquivos = pasta.listFiles();
        if (arquivos != null) {

            // ler todos os arquivos
            for (File arq : arquivos) {
                try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
                    StringBuilder conteudo = new StringBuilder();
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        conteudo.append(linha.toLowerCase()).append(", ");
                    }

                    // verificar se o conteudo passado tem valores válidos
                    boolean match1 = conteudo.toString().contains(valor1);
                    boolean match2 = (criterio2 != -1) ? conteudo.toString().contains(valor2) : true;

                    if (match1 && match2) {
                        System.out.println(conteudo);
                    }


                } catch (IOException e) {
                    System.out.println("Erro ao ler arquivo: " + arq.getName());
                }
 
            }
        } else {
            System.out.println("Nenhum arquivo encontrado.");
        }

        sc.close();
    }
}
