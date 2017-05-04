package almeida.fernando.gprag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import almeida.fernando.gprag.model.Cliente;
import almeida.fernando.gprag.service.ClienteService;

@Controller
@RequestMapping("gprag/v1/alerts")
@CrossOrigin(origins="*")
public class AvisosController {

	@Autowired
	private ClienteService clienteService;
	/**
	 * Encontra os clientes que faltam uma semana ou menos pra vencer.
	 */
	@RequestMapping(value="/findClientsToExpire", method=RequestMethod.GET)
	@ResponseBody
	public List<Cliente> findClientsToExpire(){
		return clienteService.findClientsToExpire();
	}
	
	/**
	 * Encontra os clientes já foram espirados(periodoNEcessidade anterior à data atual)
	 */
	@RequestMapping(value="/findExpiredClients", method=RequestMethod.GET)
	@ResponseBody
	public List<Cliente> findExpiredClients(){
		return clienteService.findExpiredClients();
	}

}
