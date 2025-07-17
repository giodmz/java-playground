package service;

import dominio.Producer;
import repository.ProducerRepository;

import java.util.List;

public class ProducerService {

    public  static  void save(Producer producer) {
        ProducerRepository.save(producer);
    }

    public  static  void delete(Integer id) {
        requiredValidId(id);
        ProducerRepository.delete(id);
    }

    public static  void update(Producer producer) {
        requiredValidId(producer.getId());
        ProducerRepository.update(producer);
    }

    public static List<Producer> findAll() {
        return ProducerRepository.findAll();
    }

    public static void showProducerMetadata() {
        ProducerRepository.showProducerMetadata();
    }

    private static void requiredValidId(Integer id){
        if (id <= 0){
            throw new IllegalArgumentException("Invalid id");
        }
    }

    public static List<Producer> findByName(String name) {
        return ProducerRepository.findByName(name);
    }

}
