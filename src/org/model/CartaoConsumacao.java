package org.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "catoes")
public class CartaoConsumacao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "cartaoId", sequenceName = "cartoes_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartaoId")
	private Integer cartaoId;
	private BigDecimal saldoInicial;
	@OneToOne
	private User userId;

	CartaoConsumacao() {
	}

	public CartaoConsumacao(BigDecimal saldoInicial, User userId) {
		this.saldoInicial = saldoInicial.setScale(2);
		this.userId = userId;
	}

	public Integer getCartaoId() {
		return cartaoId;
	}

	public BigDecimal getSaldo() {
		return saldoInicial.setScale(2);
	}

	public User getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "CartaoConsumacao [cartaoId=" + cartaoId + ", saldoInicial=" + saldoInicial
				+ ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cartaoId == null) ? 0 : cartaoId.hashCode());
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
		CartaoConsumacao other = (CartaoConsumacao) obj;
		if (cartaoId == null) {
			if (other.cartaoId != null)
				return false;
		} else if (!cartaoId.equals(other.cartaoId))
			return false;
		return true;
	}

}
