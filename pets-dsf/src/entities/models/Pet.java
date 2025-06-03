package entities.models;

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

    
    
    

}
