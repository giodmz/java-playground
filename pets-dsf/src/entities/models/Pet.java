package entities.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
        result = prime * result + ((idade == null) ? 0 : idade.hashCode());
        result = prime * result + ((peso == null) ? 0 : peso.hashCode());
        result = prime * result + ((raca == null) ? 0 : raca.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pet other = (Pet) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (tipo != other.tipo)
            return false;
        if (sexo != other.sexo)
            return false;
        if (idade == null) {
            if (other.idade != null)
                return false;
        } else if (!idade.equals(other.idade))
            return false;
        if (peso == null) {
            if (other.peso != null)
                return false;
        } else if (!peso.equals(other.peso))
            return false;
        if (raca == null) {
            if (other.raca != null)
                return false;
        } else if (!raca.equals(other.raca))
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        return true;
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

    
        
}
