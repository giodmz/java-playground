package repository;

import conn.ConnectionFactory;
import dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ProducerRepository {
    public static void save (Producer producer){
        String sql = "INSERT INTO anime_store.Producer (Name) " +
                "VALUES ('%s');".formatted(producer.getName());
        try(Connection conn = ConnectionFactory.getConnection();
        Statement stm = conn.createStatement()) {
            int rowsAffected = stm.executeUpdate(sql);
            // utiliza da dependencia log4j
            log.info("Inserted producer in the database, rows affected by this change: '{}'", rowsAffected);
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
