package org.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "id", sequenceName = "users_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	private String funcao;
	private String telefone;
	private String cpf;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "userId")
	private CartaoConsumacao cataoId;

	User() {
	}

	public User(String nome, String login, String senha, String funcao,
			String telefone, String cpf) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.funcao = funcao;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public CartaoConsumacao getCataoId() {
		return cataoId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", login=" + login
				+ ", senha=" + senha + ", funcao=" + funcao + ", telefone="
				+ telefone + ", cpf=" + cpf + "]";
	}

}
