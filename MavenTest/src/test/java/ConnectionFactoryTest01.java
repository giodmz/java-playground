import conn.ConnectionFactory;
import dominio.Producer;
import lombok.extern.log4j.Log4j2;
import repository.ProducerRepository;
import service.ProducerService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) throws SQLException {

//        // TESTE
//            ProducerService.showProducerMetadata()//            ProducerService.showDriverMetadata();
            ProducerService.showTypeScrollWorking();
//        List<Producer> producers = ProducerService.findAll();
//        List<Producer> producers = ProducerService.findByName("Mad");
//        log.info("Complete log: {}", producers);
//        System.out.println("Total: " + producers.size());
//        System.out.println("Total: " + producers.size());
//        System.out.println("Total: " + producers.size());
//        System.out.println("Total: " + producers.size());
//        System.out.println("Total: " + producers.size());
//        System.out.println("Total: " + producers.size());
//        System.out.println("Total: " + producers.size());
//        System.out.println("Total: " + producers.size());
//        Producer producerToUpdate = Producer.builder().id(15).name("Madhouse").build();
//        ProducerService.update(producerToUpdate);

//        List<Producer> producers = ProducerService.findAll();
//        log.info("Total producers found: {}", producers.size());
//        log.info("All producers in database: '{}'", producers);
//        log.info("Finding all producers in database '{}'", producers.toString());
//        System.out.println("end");

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
