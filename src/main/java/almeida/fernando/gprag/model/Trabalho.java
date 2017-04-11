package almeida.fernando.gprag.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trabalho {

	@Id
	private String id;

	private String idCliente;

	private Double valor;
	private String representante;
	private String aplicador;
	private Date periodoNecessidade;

	private Map<String, Boolean> tipoTrabalho;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Boolean> getTipoTrabalho() {
		return tipoTrabalho;
	}

	public void setTipoTrabalho(Map<String, Boolean> tipoTrabalho) {
		this.tipoTrabalho = tipoTrabalho;
	}

	public String getAplicador() {
		return aplicador;
	}

	public void setAplicador(String aplicador) {
		this.aplicador = aplicador;
	}

	public Date getPeriodoNecessidade() {
		return periodoNecessidade;
	}

	public void setPeriodoNecessidade(Date periodoNecessidade) {
		this.periodoNecessidade = periodoNecessidade;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

}
