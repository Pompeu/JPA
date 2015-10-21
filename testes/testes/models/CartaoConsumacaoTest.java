package testes.models;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.model.CartaoConsumacao;
import org.model.dao.Dao;
import org.model.util.JPAUtil;

import testes.factorys.ModelFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartaoConsumacaoTest {

	CartaoConsumacao cartao = null;

	@Test
	public void teste_all() {
		a_cartao_should_be_save_new_cartao();
		b_cartao_should_be_get_an_cartao();
		c_cartao_should_be_update_an_cartao();
		d_cartao_should_be_getAll_cartaos();
		e_cartao_should_be_remove_an_cartao();
	}

	public void a_cartao_should_be_save_new_cartao() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		cartao = dao.save(ModelFactory.criarCartoes().get(0));
		assertTrue(cartao != null);
	}

	public void b_cartao_should_be_get_an_cartao() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		CartaoConsumacao cartaoGeted = dao.retrivetbyId(cartao.getCartaoId());
		assertTrue(cartaoGeted.getSaldo() == cartao.getSaldo());
	}

	public void c_cartao_should_be_update_an_cartao() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		CartaoConsumacao cartaoGeted = dao.save(cartao);
		assertTrue(cartaoGeted.equals(cartao));

	}

	public void d_cartao_should_be_getAll_cartaos() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		List<CartaoConsumacao> retrivetAll = dao.retrivetAll();
		assertTrue(retrivetAll.size() != 0);
	}

	public void e_cartao_should_be_remove_an_cartao() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		boolean deleted = dao.delete(cartao);
		assertTrue(deleted);
	}
}
