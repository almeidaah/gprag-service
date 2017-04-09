package almeida.fernando.gprag.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import almeida.fernando.gprag.model.Cliente;
import almeida.fernando.gprag.service.ClienteService;
import almeida.fernando.gprag.util.ClienteUtils;

@Controller
@RequestMapping("gprag/v1/client")
@CrossOrigin(origins="*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Cliente> insert(@RequestParam Map<String, String> parameters){
		
		Cliente cliente = ClienteUtils.popularCliente(parameters);
		clienteService.inserir(cliente);
		
		return new ResponseEntity<Cliente>(new Cliente(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String get(){
		return "Cliente Encontrado";
	}
}
