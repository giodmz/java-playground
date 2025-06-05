package entities.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entities.PetSearcher;
import entities.enums.Genero;
import entities.enums.Tipo;

public class Pet {

    private String nome;
    private Tipo tipo;
    private Genero sexo;
    private Integer idade;
    private Double peso;
    private String raca;

    private Endereco endereco;

    public Pet() {
    }

    public Pet(String nome, Tipo tipo, Genero sexo, Endereco endereco, Integer idade, Double peso, String raca) {
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public Endereco getendereco() {
        return endereco;
    }

    public void setendereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "Pet [nome=" + nome + ", tipo=" + tipo + ", sexo=" + sexo + ", endereco=" + endereco + ", idade=" + idade
                + ", peso=" + peso + ", raca=" + raca + "]";
    }

    public static String capitalizar(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    public void cadastrarPet(Pet pet) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");

        String arquivo = LocalDateTime.now().format(formatter) + pet.getNome().replaceAll(" ", "").toUpperCase()
                + ".txt";
        String pathWriter = "C:\\Studies\\java-playground\\pets-dsf\\src\\pets\\" + arquivo;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter, true))) {

            bw.write("1 - " + pet.getNome());
            bw.write("\n2 - " + capitalizar(pet.getTipo().toString()));
            bw.write("\n3 - " + capitalizar(pet.getSexo().toString()));
            bw.write("\n4 - " + (pet.getendereco().getRua() +
                    ", " + pet.getendereco().getNum() +
                    ", " + pet.getendereco().getCidade()));
            bw.write("\n5 - " + pet.getIdade().toString());
            bw.write("\n6 - " + pet.getPeso());
            bw.write("\n7 - " + pet.getRaca());
            bw.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<File> buscarPet(File diretorio, String criterio) {
        return PetSearcher.buscarInterativo(diretorio, criterio);
    }
}
