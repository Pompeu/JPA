package testes.models;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.model.CartaoConsumacao;
import org.model.Produto;
import org.model.RegistradorCaixa;
import org.model.User;

import testes.factorys.ModelFactory;

public class RegistradorCaixaTest {
	User user = null;
	CartaoConsumacao cartao = null;
	List<Produto> produtos = null;
	RegistradorCaixa caixa = null;

	@Before
	public void before() {
		user = ModelFactory.criarUsers().get(0);
		cartao = ModelFactory.criarCartoes().get(0);
		produtos = ModelFactory.criarProdutos();
		caixa = new RegistradorCaixa(user, cartao, produtos);
	}

		
	@Test
	public void venda_should_be_have_a_total() {
		double total = produtos.stream()
				.mapToDouble(p -> p.getPreco().doubleValue()).sum();
		assertEquals(new BigDecimal(total), caixa.getTotal());
	}
}
