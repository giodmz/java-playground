package entities.models;

public class Endereco {

    private Integer num;
    private String cidade;
    private String rua;
    
    public Endereco() {
    }

    public Endereco(Integer num, String cidade, String rua) {
        this.num = num;
        this.cidade = cidade;
        this.rua = rua;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return "Endereco [num=" + num + ", cidade=" + cidade + ", rua=" + rua + "]";
    }

    

}
