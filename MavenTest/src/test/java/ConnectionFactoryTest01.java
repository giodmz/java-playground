import conn.ConnectionFactory;
import dominio.Producer;
import lombok.extern.log4j.Log4j2;
import repository.ProducerRepository;

import java.sql.SQLException;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) throws SQLException {
        Producer producer = Producer.builder().name("Toei Animation").build();
        ProducerRepository.save(producer);
//        log.info("INFO");
//        log.debug("debug");
//        log.warn("warn");
//        log.error("error");
//        log.trace("trace");
    }
}
