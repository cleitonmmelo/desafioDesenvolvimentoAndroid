package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cliente_id;
	private String cliente_nome;
	private String cliente_email;
	private String cliente_cep;
	private String cliente_cpf;
	private String cliente_logradouro;
	private String cliente_bairro;
	private String cliente_cidade;
	private String cliente_uf;
	private String cliente_telefone;
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getCliente_nome() {
		return cliente_nome;
	}
	public void setCliente_nome(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}

	public String getCliente_cep() {
		return cliente_cep;
	}
	public void setCliente_cep(String cliente_cep) {
		this.cliente_cep = cliente_cep;
	}
	public String getCliente_cpf() {
		return cliente_cpf;
	}
	public void setCliente_cpf(String cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}
	public String getCliente_logradouro() {
		return cliente_logradouro;
	}
	public void setCliente_logradouro(String cliente_logradouro) {
		this.cliente_logradouro = cliente_logradouro;
	}
	public String getCliente_bairro() {
		return cliente_bairro;
	}
	public void setCliente_bairro(String cliente_bairro) {
		this.cliente_bairro = cliente_bairro;
	}
	public String getCliente_cidade() {
		return cliente_cidade;
	}
	public void setCliente_cidade(String cliente_cidade) {
		this.cliente_cidade = cliente_cidade;
	}
	public String getCliente_uf() {
		return cliente_uf;
	}
	public void setCliente_uf(String cliente_uf) {
		this.cliente_uf = cliente_uf;
	}
	public String getCliente_telefone() {
		return cliente_telefone;
	}
	public void setCliente_telefone(String cliente_telefone) {
		this.cliente_telefone = cliente_telefone;
	}
	public String getCliente_email() {
		return cliente_email;
	}
	public void setCliente_email(String cliente_email) {
		this.cliente_email = cliente_email;
	}
	
	

	
}
