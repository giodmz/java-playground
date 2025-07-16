import conn.ConnectionFactory;
import dominio.Producer;
import lombok.extern.log4j.Log4j2;
import repository.ProducerRepository;
import service.ProducerService;

import java.sql.SQLException;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) throws SQLException {

        Producer producerToUpdate = Producer.builder().id(15).name("Madhouse").build();
        ProducerService.update(producerToUpdate);
//        Producer producer = Producer.builder().name("Toei Animation").build();
//        ProducerRepository.save(producer);
//        ProducerService.delete(13);
//        log.info("INFO");
//        log.debug("debug");
//        log.warn("warn");
//        log.error("error");
//        log.trace("trace");
    }
}
