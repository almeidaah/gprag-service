package almeida.fernando.gprag.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import almeida.fernando.gprag.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

}
