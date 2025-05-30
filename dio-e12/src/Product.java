public class Product {
    private String nome;
    private Double value;

    public Product() {
    }

    public Product(String nome, Double value) {
        this.nome = nome;
        this.value = value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
