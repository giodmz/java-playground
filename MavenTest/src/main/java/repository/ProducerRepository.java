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

    public static void showDriverMetadata(){
        log.info("Showing driver Metadata: ");
        String sql = "SELECT * FROM anime_store.Producer;";
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData dbMetadata = conn.getMetaData();
            if(dbMetadata.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports type forward only");
                if (dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    log.info("and supports concur updatable");
                }
            }
            if(dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports type scroll insensitive");
                if (dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("and supports concur updatable");
                }
            }
            if(dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports type scroll sensitive");
                if (dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("and supports concur updatable");
                }
            }
        } catch (SQLException ex) {
            log.error("Error while trying find all producers", ex);
        }
    }

    // um cursor que se move pelas linhas utilizando comandos do resultSet
    public static void showTypeScrollWorking() {
        String sql = "SELECT * FROM anime_store.Producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stm.executeQuery(sql)) {

            // se move para a última linha
            log.info("Last row: '{}'", rs.last());
            log.info("Row number: '{}'", rs.getRow());
            log.info(Producer.builder()
                    .id(rs.getInt("ID"))
                    .name(rs.getString("Name"))
                    .build());

            // primeira linha
            log.info("First row: '{}'", rs.first());
            log.info("Row number: '{}'", rs.getRow());
            log.info(Producer.builder()
                    .id(rs.getInt("ID"))
                    .name(rs.getString("Name"))
                    .build());

            // linha absoluta que foi passada (2)
            log.info("Row absolute: '{}'", rs.absolute(2));
            log.info("Row number: '{}'", rs.getRow());
            log.info(Producer.builder()
                    .id(rs.getInt("ID"))
                    .name(rs.getString("Name"))
                    .build());

            // se move de forma relativa baseada na última linha que estava
            log.info("Row relative: '{}'", rs.relative(-1));
            log.info("Row number: '{}'", rs.getRow());
            log.info(Producer.builder()
                    .id(rs.getInt("ID"))
                    .name(rs.getString("Name"))
                    .build());

            // verifica se é a última e não move o cursor
            log.info("Is last? '{}'", rs.isLast());
            log.info("Row number: '{}'", rs.getRow());

            // msm esquema do isLast
            log.info("Is first? '{}'", rs.isFirst());
            log.info("Row number: '{}'", rs.getRow());

            log.info("***************************************");
            log.info("Last row '{}'", rs.last());
            rs.next();
            log.info("Is after last row? '{}'", rs.isAfterLast());

            // previous vai pra trás
            while(rs.previous()) {
                log.info(Producer.builder()
                        .id(rs.getInt("ID"))
                        .name(rs.getString("Name"))
                        .build());
            }

        } catch (SQLException ex) {
            log.error("Error while trying find all producers", ex);
        }
    }


}
