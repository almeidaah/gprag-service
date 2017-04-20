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

import almeida.fernando.gprag.model.Trabalho;
import almeida.fernando.gprag.service.TrabalhoService;
import almeida.fernando.gprag.util.TrabalhoUtils;

@Controller
@RequestMapping("gprag/v1/job")
@CrossOrigin(origins="*")
public class TrabalhoController {

	@Autowired 
	private TrabalhoService trabalhoService;
	
	/**
	 * Inserir novo trabalho
	 * @param parameters
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Trabalho> insert(@RequestParam Map<String, String> parameters){
		Trabalho trabalho = TrabalhoUtils.popularTrabalho(parameters);
		trabalhoService.inserir(trabalho);
		return new ResponseEntity<Trabalho>(trabalho, HttpStatus.OK);
	}
	/**
	 * Busca a lista de trabalhos realizados para cada cliente
	 * @return
	 */
	@RequestMapping(value="/client/{idCliente}", method=RequestMethod.GET)
	@ResponseBody
	public List<Trabalho> findByClientId(@PathVariable String idCliente){
		return trabalhoService.findByIdCliente(idCliente);
	}
	
	/**
	 * Remove um trabalho
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable String id){
		trabalhoService.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
