package almeida.fernando.gprag.model;

import java.util.Date;

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

	private String tipoTrabalho;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoTrabalho() {
		return tipoTrabalho;
	}

	public void setTipoTrabalho(String tipoTrabalho) {
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
