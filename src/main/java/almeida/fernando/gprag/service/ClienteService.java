package almeida.fernando.gprag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import almeida.fernando.gprag.model.Cliente;
import almeida.fernando.gprag.repository.ClienteRepository;

@Service
public class ClienteService{

	@Autowired
	private ClienteRepository clientRepository;

	@Transactional
	public void inserir(Cliente cliente) {
		clientRepository.insert(cliente);
	}
	
}
