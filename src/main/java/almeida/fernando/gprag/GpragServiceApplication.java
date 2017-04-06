package almeida.fernando.gprag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class GpragServiceApplication implements ErrorController {

	public static void main(String[] args) {
		SpringApplication.run(GpragServiceApplication.class, args);
	}
	
	@RequestMapping(value="/error")
	@ResponseBody
	public String error(){
		return "G-PRAG Service APP (Heroku)\n Author : Fernando Almeida";
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
}
