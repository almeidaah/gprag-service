package almeida.fernando.gprag.service;

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
		
		Calendar actualDate = Calendar.getInstance();
		actualDate.setTime(new Date());
		actualDate.set(Calendar.HOUR_OF_DAY, 0);
		actualDate.set(Calendar.MINUTE, 0);
		actualDate.set(Calendar.SECOND, 0);

		Calendar futureDate = (Calendar)actualDate.clone();
		futureDate.add(Calendar.DAY_OF_YEAR, 7);
		
		return clienteRepository.findByPeriodoNecessidade(actualDate.getTime().getTime(), futureDate.getTime().getTime());
	}

	@Transactional
	public List<Cliente> findExpiredClients() {
		
		Calendar actualDate = Calendar.getInstance();
		actualDate.setTime(new Date());
		actualDate.set(Calendar.HOUR_OF_DAY, 0);
		actualDate.set(Calendar.MINUTE, 0);
		actualDate.set(Calendar.SECOND, 0);

		return clienteRepository.findExpiredClients(actualDate.getTime().getTime());
	}

	@Transactional
	public Cliente findClienteUnique(String clienteId) {
		return clienteRepository.findOne(clienteId);
	}

}
