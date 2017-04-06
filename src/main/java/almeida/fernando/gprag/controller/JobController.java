package almeida.fernando.gprag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("gprag/v1/job")
public class JobController {

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String insert(){
		return "JOB Inserido";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String get(){
		return "JOB Encontrado";
	}
}
