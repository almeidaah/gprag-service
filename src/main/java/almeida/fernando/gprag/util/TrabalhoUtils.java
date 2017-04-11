package almeida.fernando.gprag.util;

import java.util.Map;

import almeida.fernando.gprag.model.Trabalho;

public class TrabalhoUtils {
	
	private static final String ID_CLIENTE = "id";
	private static final String TIPO_TRABALHO = "tipoTrabalho";
	private static final String VALOR_TOTAL = "valorTotal";
	private static final String REPRESENTANTE = "representante";
	private static final String APLICADOR = "aplicador";
	
	public static Trabalho popularTrabalho(Map<String, String> parameters){
		
		Trabalho t = new Trabalho();
		t.setIdCliente(parameters.get(TrabalhoUtils.ID_CLIENTE));
		t.setValor(Double.parseDouble(parameters.get(TrabalhoUtils.VALOR_TOTAL)));
		t.setRepresentante(parameters.get(TrabalhoUtils.REPRESENTANTE));
		t.setAplicador(parameters.get(TrabalhoUtils.APLICADOR));
		
		//TODO
		//t.setTipoTrabalho(parameters.get(TrabalhoUtils.TIPO_TRABALHO));
		//t.setTipoTrabalho((Map<String, Boolean>)parameters.g(TrabalhoUtils.TIPO_TRABALHO));
		
		return t;
	}

}