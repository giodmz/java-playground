package dominio;


import lombok.Builder;
import lombok.Value;

// lombok serve para o aumento de produtividade e acesso ao log (println eh paia)
@Value
@Builder
public class Producer {
    Integer id;
    String name;

    public Producer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
