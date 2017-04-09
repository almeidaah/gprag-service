package almeida.fernando.gprag.util;

import java.util.Date;
import java.util.Map;

import org.springframework.util.StringUtils;

import almeida.fernando.gprag.model.Cliente;

public class ClienteUtils {

	private static final String NOME = "nome";
	private static final String ENDERECO = "endereco";
	private static final String TELEFONE = "telefone";
	private static final String EMAIL = "email";
	private static final String STATUS = "status";
	private static final String PERIODO_NECESSIDADE = "periodoNecessidade";
	
	public static Cliente popularCliente(Map<String, String> parameters) {
	
		Cliente c = new Cliente();
		c.setNome(parameters.get(ClienteUtils.NOME));
		c.setEndereco(parameters.get(ClienteUtils.ENDERECO));
		c.setEmail(parameters.get(ClienteUtils.EMAIL));
		
		String telefone = parameters.get(ClienteUtils.TELEFONE);
		if(!StringUtils.isEmpty(telefone)){
			c.setTelefone(Long.parseLong(telefone));
		}
		
		Boolean status = Boolean.valueOf(parameters.get(ClienteUtils.STATUS));
		c.setStatus(status);
		
		long periodoNecessidadeParam = Long.parseLong(parameters.get(ClienteUtils.PERIODO_NECESSIDADE));
		Date periodoNecessidade = new Date(periodoNecessidadeParam);
		c.setPeriodoNecessidade(periodoNecessidade);
		
		return c;
	}
	
}
