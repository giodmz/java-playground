package repository;

import conn.ConnectionFactory;
import dominio.Producer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProducerRepository {
    public static void save (Producer producer){
        String sql = "INSERT INTO anime_store.Producer (Name) " +
                "VALUES ('%s');".formatted(producer.getName());
        try(Connection conn = ConnectionFactory.getConnection();
        Statement stm = conn.createStatement()) {
            int rowsAffected = stm.executeUpdate(sql);
            System.out.println(rowsAffected);
        stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
