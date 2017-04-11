package almeida.fernando.gprag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import almeida.fernando.gprag.model.Trabalho;
import almeida.fernando.gprag.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

	@Autowired
	private TrabalhoRepository trabalhoRepository;
	
	public void inserir(Trabalho trabalho) {
		trabalhoRepository.insert(trabalho);
	}
	
	

}
