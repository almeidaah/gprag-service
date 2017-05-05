package almeida.fernando.gprag.util;

import java.util.Map;

import org.springframework.util.StringUtils;

import almeida.fernando.gprag.model.Cliente;

public class ClienteUtils {

	private static final String ID = "id";
	private static final String NOME = "nome";
	private static final String ENDERECO = "endereco";
	private static final String TELEFONE = "telefone";
	private static final String EMAIL = "email";
	private static final String STATUS = "status";
	private static final String PERIODO_NECESSIDADE = "periodoNecessidade";
	
	public static Cliente popularCliente(Map<String, String> parameters) {
	
		Cliente c = new Cliente();
		c.setId(parameters.get(ClienteUtils.ID));
		c.setNome(parameters.get(ClienteUtils.NOME));
		c.setEndereco(parameters.get(ClienteUtils.ENDERECO));
		
		String email = parameters.get(ClienteUtils.EMAIL);
		if(!StringUtils.isEmpty(email)){
			c.setEmail(email.toLowerCase());
		}
		
		String telefone = parameters.get(ClienteUtils.TELEFONE);
		if(!StringUtils.isEmpty(telefone)){
			c.setTelefone(Long.parseLong(telefone));
		}
		
		Boolean status = Boolean.valueOf(parameters.get(ClienteUtils.STATUS));
		c.setStatus(status);
		
		c.setPeriodoNecessidade(Long.parseLong(parameters.get(ClienteUtils.PERIODO_NECESSIDADE)));
		
		return c;
	}
	
}
