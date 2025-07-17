package repository;

import conn.ConnectionFactory;
import dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
* resultSet é utilizado para recuperar qualquer tipo de dado da db*/
@Log4j2
public class ProducerRepository {
    public static void save(Producer producer) {
        String sql = "INSERT INTO anime_store.Producer (Name) " +
                "VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement()) {
            int rowsAffected = stm.executeUpdate(sql);
            // utiliza da dependencia log4j
            log.info("Inserted producer in the database, rows affected by this change: '{}'", rowsAffected);
        } catch (SQLException ex) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), ex);
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM anime_store.Producer WHERE (Id = '%d') "
                .formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement()) {
            int rowsAffected = stm.executeUpdate(sql);
            log.info("Deleted producer '{}' in the database, rows affected by this change: '{}'", id, rowsAffected);
        } catch (SQLException ex) {
            log.error("Error while trying to insert producer '{}'", id, ex);
        }
    }

    public static void update(Producer producer) {
        String sql = "UPDATE anime_store.Producer SET Name = '%s' WHERE Id = %d"
                .formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement()) {
            int rowsAffected = stm.executeUpdate(sql);
            log.info("Updated producer '{}' in the database, rows affected by this change: '{}'", producer.getId(), rowsAffected);
        } catch (SQLException ex) {
            log.error("Error while trying to insert producer '{}'", producer.getId(), ex);
        }
    }

    public static List<Producer> findAll() {
        log.info("Finding all producers: ");
        return findByName("");
//        String sql = "SELECT ID, Name FROM anime_store.Producer;";
//        List<Producer> producers = new ArrayList<>();
//        try (Connection conn = ConnectionFactory.getConnection();
//             Statement stm = conn.createStatement();
//             ResultSet rs = stm.executeQuery(sql)) {
//            while(rs.next()) {
//                var id = rs.getInt("Id");
//                var name = rs.getString("Name");
//                Producer producer = Producer.builder()
//                        .id(rs.getInt("ID"))
//                        .name(rs.getString("Name"))
//                        .build();
//                producers.add(producer);
//            }
//        } catch (SQLException ex) {
//            log.error("Error while trying find all producers", ex);
//        }
//        return producers;
    }

    public static List<Producer> findByName(String name) {
        String sql = "SELECT * FROM anime_store.Producer WHERE Name LIKE '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            while(rs.next()) {
//                var id = rs.getInt("Id");
//                var name = rs.getString("Name");
                Producer producer = Producer.builder()
                        .id(rs.getInt("ID"))
                        .name(rs.getString("Name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException ex) {
            log.error("Error while trying find all producers", ex);
        }
        return producers;
    }

    public static void showProducerMetadata(){
        log.info("Showing producer Metadata: ");
        String sql = "SELECT * FROM anime_store.Producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            ResultSetMetaData metaData = rs.getMetaData();
            rs.next();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name: '{}'", metaData.getTableName(i));
                log.info("Column name: '{}'", metaData.getColumnName(i));
                log.info("Column size: '{}'", metaData.getColumnDisplaySize(i));
                log.info("Column type: '{}'", metaData.getColumnTypeName(i));
            }
        } catch (SQLException ex) {
            log.error("Error while trying find all producers", ex);
        }
    }


}
