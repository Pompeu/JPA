package org.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@SequenceGenerator(name = "produtoId", sequenceName = "produtos_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoId")
	private Integer produtoId;
	private String nome;
	private double preco;

	Produto() {
	}

	public Produto( String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return "Produto [produtoId=" + produtoId + ", nome=" + nome
				+ ", preco=" + preco + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((produtoId == null) ? 0 : produtoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (produtoId == null) {
			if (other.produtoId != null)
				return false;
		} else if (!produtoId.equals(other.produtoId))
			return false;
		return true;
	}

}
