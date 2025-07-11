import conn.ConnectionFactory;
import dominio.Producer;
import repository.ProducerRepository;

import java.sql.SQLException;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) throws SQLException {
        Producer producer = Producer.ProducerBuilder.Builder().withName("NHK").build();
        ProducerRepository.save(producer);
    }
}
