package almeida.fernando.gprag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("gprag/v1/client")
public class ClientController {

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String insert(){
		return "Cliente Inserido";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String get(){
		return "Cliente Encontrado";
	}
}
