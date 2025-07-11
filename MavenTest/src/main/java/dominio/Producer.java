package dominio;

import java.util.Objects;

public class Producer {
    private Integer id;
    private String name;

    public Producer() {

    }

    public Producer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public static final class ProducerBuilder {
        private Integer id;
        private String name;

        private ProducerBuilder() {
        }

        public static ProducerBuilder Builder() {
            return new ProducerBuilder();
        }

        public ProducerBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public ProducerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Producer build() {
            return new Producer(id, name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return Objects.equals(id, producer.id) && Objects.equals(name, producer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
