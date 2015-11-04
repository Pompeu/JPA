package org.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class RegistradorCaixa {

	private final CartaoConsumacao cartao;
	private final List<Produto> produtos;
	private final User user;

	public RegistradorCaixa(User user, CartaoConsumacao cartao,
			List<Produto> produtos) {
		this.user = user;
		this.cartao = cartao;
		this.produtos = produtos;
	}

	public User getUser() {
		return user;
	}

	public CartaoConsumacao getCartao() {
		return cartao;
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public BigDecimal getTotal() {
		final double sum = getProdutos().stream()
				.mapToDouble(p -> p.getPreco().doubleValue()).sum();
		return new BigDecimal(sum).setScale(2);
	}

	@Override
	public String toString() {
		return "RegistradorCaixa [cartao=" + cartao + ", produtos=" + produtos
				+ ", user=" + user + "]";
	}

}
