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

	@Transactional
	public List<Cliente> findClientsToExpire() {
		int noOfDays = 7; 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());            
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
		
		return clienteRepository.findByPeriodoNecessidade(new Date().getTime(), calendar.getTime().getTime());
	}

	@Transactional
	public List<Cliente> findExpiredClients() {
		return clienteRepository.findExpiredClients(new Date().getTime());
	}
	
}
