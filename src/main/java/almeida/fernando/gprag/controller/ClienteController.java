package almeida.fernando.gprag.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import almeida.fernando.gprag.model.Cliente;
import almeida.fernando.gprag.model.Trabalho;
import almeida.fernando.gprag.service.ClienteService;
import almeida.fernando.gprag.service.TrabalhoService;
import almeida.fernando.gprag.util.ClienteUtils;

@Controller
@RequestMapping("gprag/v1/clients")
@CrossOrigin(origins="*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TrabalhoService trabalhoService;
	
	/**
	 * Inserir novo cliente
	 * @param parameters
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Cliente> save(@RequestParam Map<String, String> parameters){
		
		Cliente cliente = ClienteUtils.popularCliente(parameters);
		clienteService.saveOrUpdate(cliente);
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	/**
	 * Buscar todos os clientes(Ordernados por nome)
	 * @return List<Cliente> clientes cadastrados
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Cliente> get(){
		return clienteService.findAll();
	}
	
	/**
	 * Busca cliente por nome (Case Insensitive) / Busca por like Ex "Client" ou "lient"
	 * @param nmCliente
	 * @return
	 */
	@RequestMapping(value="/{nmCliente}", method=RequestMethod.GET)
	@ResponseBody
	public List<Cliente> findByName(@PathVariable String nmCliente){
		return clienteService.findByNome(nmCliente);
	}
	
	/**
	 * Deleta um cliente(e todos os trabalhos associados
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable String id){
		
		//Deleta os trabalhos antes de deletar o cliente
		List<Trabalho> trabalhos = trabalhoService.findByIdCliente(id);
		trabalhos.forEach(t -> trabalhoService.delete(t.getId()));
			
		clienteService.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
