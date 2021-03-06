package almeida.fernando.gprag.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import almeida.fernando.gprag.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

	@Query(value= "{ 'nome' : { $regex: '.*?0.*', $options: 'i' } }")
	List<Cliente> findByNome(String nmCliente);

	@Query(value= "{'periodoNecessidade' : {'$gt' : ?0, '$lt' : ?1}}")
	List<Cliente> findByPeriodoNecessidade(Long actualDate, Long futureDate);

	@Query(value= "{'periodoNecessidade' : {'$lt' : ?0}}")
	List<Cliente> findExpiredClients(long time);
}
