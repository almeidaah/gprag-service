package almeida.fernando.gprag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import almeida.fernando.gprag.model.Trabalho;
import almeida.fernando.gprag.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

	@Autowired
	private TrabalhoRepository trabalhoRepository;
	
	@Transactional
	public void inserir(Trabalho trabalho) {
		trabalhoRepository.insert(trabalho);
	}

	@Transactional
	public List<Trabalho> findByIdCliente(String idCliente) {
		return trabalhoRepository.findByIdCliente(idCliente);
	}
	
	

}
