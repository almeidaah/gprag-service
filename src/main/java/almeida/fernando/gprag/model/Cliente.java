package almeida.fernando.gprag.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {
	
	@Id
	private String id;
	
	private String nome;
	private String email;
	private String endereco;
	private Long periodoNecessidade;
	private Boolean status;
	private Long telefone;
	
	private List<Trabalho> trabalhos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getPeriodoNecessidade() {
		return periodoNecessidade;
	}
	public void setPeriodoNecessidade(Long periodoNecessidade) {
		this.periodoNecessidade = periodoNecessidade;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Trabalho> getTrabalhos() {
		return trabalhos;
	}
	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}

	
}
