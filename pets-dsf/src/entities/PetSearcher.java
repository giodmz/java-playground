package entities;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class PetSearcher {
    
    private static final Map<String, String> CRITERIOS = Map.of(
        "1", "1 - ", "2", "3 - ", "3", "5 - ", 
        "4", "6 - ", "5", "7 - ", "6", "4 - "
    );
    
    private static final Map<String, String> NOMES = Map.of(
        "1", "nome", "2", "sexo", "3", "idade", 
        "4", "peso", "5", "raça", "6", "endereço"
    );
    
    // Método principal - tudo em uma linha de stream
    public static List<File> buscar(File diretorio, String criterio, String valor) {
        return Arrays.stream(Objects.requireNonNull(diretorio.listFiles((d, n) -> n.endsWith(".txt"))))
                .filter(f -> lerArquivo(f).stream()
                        .filter(linha -> linha.startsWith(CRITERIOS.get(criterio)))
                        .anyMatch(linha -> linha.toLowerCase().contains(valor.toLowerCase())))
                .collect(Collectors.toList());
    }
    
    public static List<File> buscarInterativo(File diretorio, String criterio) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o " + NOMES.get(criterio) + ": ");
        return buscar(diretorio, criterio, sc.nextLine());
    }
    
    private static List<String> lerArquivo(File arquivo) {
        try {
            return Files.readAllLines(arquivo.toPath());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
    
    public static void exibirResultados(List<File> arquivos) {
        if (arquivos.isEmpty()) {
            System.out.println("❌ Nenhum pet encontrado!");
            return;
        }
        
        System.out.println("\n✅ " + arquivos.size() + " pet(s) encontrado(s):\n");
        arquivos.forEach(PetSearcher::exibirPet);
    }
    
    private static void exibirPet(File arquivo) {
        System.out.println(arquivo.getName());
        lerArquivo(arquivo).stream()
                .map(linha -> linha.split(" - ", 2))
                .filter(partes -> partes.length == 2)
                .forEach(partes -> System.out.println("   🐾 " + partes[1]));
        System.out.println();
    }
    
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        File diretorio = new File("C:\\Studies\\java-playground\\pets-dsf\\src\\pets");
        
        System.out.println(" BUSCAR: 1-Nome 2-Sexo 3-Idade 4-Peso 5-Raça 6-Endereço");
        String criterio = sc.nextLine();
        
        if (criterio.matches("[1-6]")) {
            exibirResultados(buscarInterativo(diretorio, criterio));
        } else {
            System.out.println("Opção inválida!");
        }
    }
}
