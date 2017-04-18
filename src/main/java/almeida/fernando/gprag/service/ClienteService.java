package almeida.fernando.gprag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import almeida.fernando.gprag.model.Cliente;
import almeida.fernando.gprag.repository.ClienteRepository;

@Service
public class ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public void inserir(Cliente cliente) {
		clienteRepository.insert(cliente);
	}

	@Transactional
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Transactional
	public List<Cliente> findByNome(String nmCliente) {
		return clienteRepository.findByNome(nmCliente);
	}

	@Transactional
	public void delete(String id) {
		clienteRepository.delete(id);
	}
	
}
