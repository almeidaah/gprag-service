package almeida.fernando.gprag.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import almeida.fernando.gprag.model.Cliente;
import almeida.fernando.gprag.repository.ClienteRepository;

@Service
public class ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public void saveOrUpdate(Cliente cliente) {
		
		//Update else Insert
		if(cliente.getId() != null){
			clienteRepository.save(cliente);
		}else{
			clienteRepository.insert(cliente);
		}
	}

	@Transactional
	public List<Cliente> findAll() {
		return clienteRepository.findAll(new Sort(Sort.Direction.ASC, "nome"));
	}

	@Transactional
	public List<Cliente> findByNome(String nmCliente) {
		return clienteRepository.findByNome(nmCliente);
	}

	@Transactional
	public void delete(String id) {
		clienteRepository.delete(id);
	}

	/**
	 * Encontra os clientes que estão para expirar das 00:00 do dia atual às 00:00 com a diferença de uma semana.
	 * @return
	 */
	@Transactional
	public List<Cliente> findClientsToExpire() {
		Instant now = Instant.now();
		Instant future = now.plus(7, ChronoUnit.DAYS);
		return clienteRepository.findByPeriodoNecessidade(now.toEpochMilli(), future.toEpochMilli());
	}

	@Transactional
	public List<Cliente> findExpiredClients() {
		return clienteRepository.findExpiredClients(Instant.now().toEpochMilli());
	}

	@Transactional
	public Cliente findClienteUnique(String clienteId) {
		return clienteRepository.findOne(clienteId);
	}

}
