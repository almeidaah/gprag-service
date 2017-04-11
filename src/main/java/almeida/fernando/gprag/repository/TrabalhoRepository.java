package almeida.fernando.gprag.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import almeida.fernando.gprag.model.Trabalho;

public interface TrabalhoRepository extends MongoRepository<Trabalho, String> {

}
