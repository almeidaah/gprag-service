package almeida.fernando.gprag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("gprag/v1")
public class ClientController {

	@RequestMapping("/home")
	@ResponseBody
	public String test(){
		return "Test";
	}
}
