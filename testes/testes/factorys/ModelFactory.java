package testes.factorys;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.model.CartaoConsumacao;
import org.model.Produto;
import org.model.User;

public class ModelFactory {

	public static List<User> criarUsers() {

		return Arrays.asList(new User("Pompeu", "Pompeu", "123456", "Admin",
				"6434441827", "03311255688"), new User("Pompeu", "Pompeu",
				"123456", "Admin", "6434441827", "03311255688"), new User(
				"Pompeu", "Pompeu", "123456", "Admin", "6434441827",
				"03311255688"));

	}

	public static List<Produto> criarProdutos() {

		return Arrays.asList(new Produto("coca", new BigDecimal(6.50)),
				new Produto("vodka", new BigDecimal(7.50)), new Produto(
						"Cerveja", new BigDecimal(5.50)));

	}

	public static List<CartaoConsumacao> criarCartoes() {

		return Arrays.asList(new CartaoConsumacao(BigDecimal.valueOf(2.50),
				new User("Pompeu", "Pompeu", "123456", "Cliente", "6434441827",
						"03311255688")),
				new CartaoConsumacao(BigDecimal.valueOf(2.50), new User(
						"Pompeu2", "Pompeu2", "123456", "Cliente",
						"6434441827", "03311255688")), new CartaoConsumacao(
						BigDecimal.valueOf(2.50), new User("Pompeu3",
								"Pompeu3", "123456", "Cliente", "6434441827",
								"03311255688")));

	}
}
