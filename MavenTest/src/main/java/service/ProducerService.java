package service;

import dominio.Producer;
import repository.ProducerRepository;

public class ProducerService {

    public  static  void save(Producer producer) {
        ProducerRepository.save(producer);
    }

    public  static  void delete(int id) {
        if (id <= 0 ){
            throw new IllegalArgumentException("Invalid id");
        }
        ProducerRepository.delete(id);
    }

}
