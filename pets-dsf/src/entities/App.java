package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
                case 2:
                    alterarDadosPetMenu();
                    break;
                case 3:
                    removerPetMenu();
                    break;
                case 4:
                    menuListarPets();
                    break;
                case 5:
                    menuBuscarDados();
                    break;
                case 6:
                    System.out.println("\nAté logo...");
                    System.exit(0);
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

        menuInicial();

    }

    // buscar as informações baseadas nos números utilizados no .txt, atribuindo o
    // texto a classe pet
    public static List<File> buscarDados(List<File> arquivosEncontrados) {

        arquivosEncontrados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File pasta = new File("C:\\Studies\\java-playground\\pets-dsf\\src\\pets");
        int contador = 1;

        System.out.println("Seu pet é um gato ou um cachorro?");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        System.out.print("Opção: ");
        int tipoOpcao = sc.nextInt();
        sc.nextLine();

        String tipoAnimal = "";
        if (tipoOpcao == 1) {
            tipoAnimal = "cachorro";
        } else if (tipoOpcao == 2) {
            tipoAnimal = "gato";
        } else {
            System.out.println("Opção inválida.");
            sc.close();
        }

        System.out.print("Deseja adicionar um segundo critério? (s/n): ");
        String opcao = sc.nextLine().toLowerCase();

        int criterio2 = -1;
        String valor2 = "";

        if (opcao.equals("s")) {
            System.out.println("\nEscolha um critério de busca:");
            System.out.println("1 - Nome ou sobrenome");
            System.out.println("2 - Sexo");
            System.out.println("3 - Idade");
            System.out.println("4 - Peso");
            System.out.println("5 - Raça");
            System.out.println("6 - Endereço");

            System.out.print("Informe o segundo critério (1-6): ");
            criterio2 = sc.nextInt();
            sc.nextLine();
            System.out.print("Insira a informação: ");
            valor2 = sc.nextLine().toLowerCase();
        }

        File[] arquivos = pasta.listFiles();
        boolean found = false; // verificar se algo foi achado nos arquivos

        if (arquivos != null) {
            for (File arq : arquivos) {
                try (BufferedReader br = new BufferedReader(new FileReader(arq))) {

                    String nome = "", tipo = "", sexo = "", endereco = "", idade = "", peso = "", raca = "";
                    String linha;

                    // passa pelas linhas usando como referência os numeros para pegar as
                    // informacoes
                    while ((linha = br.readLine()) != null) {
                        linha = linha.toLowerCase();

                        /*
                         * notes:
                         * substring() serve para recortar uma parte da String, começando a partir de um
                         * índice específico.
                         * trim() serve para remover espaços em branco no início e no fim de uma string.
                         */

                        if (linha.startsWith("1 - "))
                            nome = linha.substring(4).trim();
                        if (linha.startsWith("2 - "))
                            tipo = linha.substring(4).trim();
                        if (linha.startsWith("3 - "))
                            sexo = linha.substring(4).trim();
                        if (linha.startsWith("4 - "))
                            endereco = linha.substring(4).trim();
                        if (linha.startsWith("5 - "))
                            idade = linha.substring(4).trim();
                        if (linha.startsWith("6 - "))
                            peso = linha.substring(4).trim();
                        if (linha.startsWith("7 - "))
                            raca = linha.substring(4).trim();
                    }

                    boolean matchTipo = tipo.equals(tipoAnimal);
                    boolean matchCriterio2 = true;

                    // se houver um segundo critério, verifica se o conteúdo corresponde
                    if (criterio2 != -1) {
                        switch (criterio2) {
                            case 1 -> matchCriterio2 = nome.contains(valor2);
                            case 2 -> matchCriterio2 = sexo.contains(valor2);
                            case 3 -> matchCriterio2 = idade.equals(valor2);
                            case 4 -> matchCriterio2 = peso.equals(valor2);
                            case 5 -> matchCriterio2 = raca.contains(valor2);
                            case 6 -> matchCriterio2 = endereco.contains(valor2);
                            default -> matchCriterio2 = true;
                        }
                    }

                    if (matchTipo && matchCriterio2) {
                        System.out.print(contador + " - ");
                        System.out.print("Nome: " + nome);
                        System.out.print(", Tipo: " + tipo);
                        System.out.print(", Sexo: " + sexo);
                        System.out.print(", Idade: " + idade);
                        System.out.print(", Peso: " + peso);
                        System.out.print(", Raça: " + raca);
                        System.out.print(", Endereço: " + endereco + "\n");
                        found = true;
                    }

                    arquivosEncontrados.add(arq);
                    contador++;

                } catch (IOException e) {
                    System.out.println("Erro ao ler arquivo: " + arq.getName());
                }

            }

            if (!found) {
                System.out.println("Nenhum pet encontrado com essas informações.");
            }
        }

        return arquivosEncontrados;

    }

    public static void menuListarPets() {
        File pasta = new File("C:\\Studies\\java-playground\\pets-dsf\\src\\pets");
        File[] arquivos = pasta.listFiles();
        int contador = 1;

        System.out.println("Pets encontrados:");

        for (File arq : arquivos) {
            try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
                String nome = "", tipo = "", sexo = "", endereco = "", idade = "", peso = "", raca = "";
                String linha;
                while ((linha = br.readLine()) != null) {
                    linha = linha.toLowerCase();

                    if (linha.startsWith("1 - "))
                        nome = linha.substring(4).trim();
                    if (linha.startsWith("2 - "))
                        tipo = linha.substring(4).trim();
                    if (linha.startsWith("3 - "))
                        sexo = linha.substring(4).trim();
                    if (linha.startsWith("4 - "))
                        endereco = linha.substring(4).trim();
                    if (linha.startsWith("5 - "))
                        idade = linha.substring(4).trim();
                    if (linha.startsWith("6 - "))
                        peso = linha.substring(4).trim();
                    if (linha.startsWith("7 - "))
                        raca = linha.substring(4).trim();
                }

                System.out.print(contador + " - ");
                System.out.print("Nome: " + nome);
                System.out.print(", Tipo: " + tipo);
                System.out.print(", Sexo: " + sexo);
                System.out.print(", Idade: " + idade);
                System.out.print(", Peso: " + peso);
                System.out.print(", Raça: " + raca);
                System.out.print(", Endereço: " + endereco + "\n");
                
                contador++;

            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo: " + arq.getName());
            }
        }

        menuInicial();

    }

    public static void menuBuscarDados() {
        List<File> arquivosEncontrados = new ArrayList<>();
        arquivosEncontrados = buscarDados(arquivosEncontrados);
        menuInicial();
    }

    public static void alterarDadosPetMenu() {

        Scanner sc = new Scanner(System.in);
        List<File> arquivosEncontrados = new ArrayList<>();
        arquivosEncontrados = buscarDados(arquivosEncontrados);

        System.out.print("\nEscolha o número do pet que deseja alterar: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha < 1 || escolha > arquivosEncontrados.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        File arquivoSelecionado = arquivosEncontrados.get(escolha - 1);

        // carregar os dados atuais do pet
        List<String> dados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoSelecionado))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                dados.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo.");
            return;
        }

        // exibir dados atuais
        System.out.println("\nDados atuais:");
        for (int i = 0; i < dados.size(); i++) {
            System.out.println(dados.get(i));
        }

        // permitir alterar uma linha
        System.out.print("Digite o número do campo que deseja alterar: ");
        int campo = sc.nextInt();
        sc.nextLine();

        if (campo < 1 || campo > dados.size()) {
            System.out.println("Campo inválido.");
            return;
        }

        // impede que altere o sexo ou o tipo do animal
        if (campo == 2 || campo == 3) {
            System.out.println("Esse campo não pode ser alterado.");
            return;
        }

        System.out.print("Digite o novo valor: ");
        String novoValor = sc.nextLine();

        String prefixo = dados.get(campo - 1).substring(0, 4); // "1 - ", "2 - ", etc.
        dados.set(campo - 1, prefixo + novoValor);

        // reescrever o arquivo com os dados alterados
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSelecionado))) {
            for (String linha : dados) {
                bw.write(linha);
                bw.newLine();
            }
            System.out.println("Pet atualizado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
        }

        sc.close();

        menuInicial();
    }

    public static void removerPetMenu() {

        Scanner sc = new Scanner(System.in);
        List<File> arquivosEncontrados = new ArrayList<>();
        arquivosEncontrados = buscarDados(arquivosEncontrados);

        System.out.print("\nEscolha o número do pet que deseja deletar: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha < 1 || escolha > arquivosEncontrados.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        File arquivoSelecionado = arquivosEncontrados.get(escolha - 1);

        List<String> dados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoSelecionado))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                dados.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo.");
            return;
        }

        System.out
                .println("Tem certeza que deseja apagar os dados do pet? " + "(" + arquivoSelecionado.getName() + ")");
        System.out.println("Digite SIM para confirmar.");
        String confirmacao = sc.nextLine();

        if (confirmacao.toUpperCase().equals("SIM")) {
            arquivoSelecionado.delete();
            System.out.println("Dados apagados com sucesso.");
        } else {
            System.out.println("\nPor favor digite a confirmação corretamente. ");
            removerPetMenu();
        }

        menuInicial();

    }
}
