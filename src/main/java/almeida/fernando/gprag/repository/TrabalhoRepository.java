package almeida.fernando.gprag.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import almeida.fernando.gprag.model.Trabalho;

public interface TrabalhoRepository extends MongoRepository<Trabalho, String> {

	List<Trabalho> findByIdCliente(String idCliente);

}
