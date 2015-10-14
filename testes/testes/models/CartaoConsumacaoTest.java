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

	CartaoConsumacao catao = null;

	@Test
	public void teste_all() {
		a_catao_should_be_save_new_catao();
		b_catao_should_be_get_an_catao();
		c_catao_should_be_update_an_catao();
		d_catao_should_be_getAll_cataos();
		e_catao_should_be_remove_an_catao();
	}

	public void a_catao_should_be_save_new_catao() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		catao = dao.create(ModelFactory.criarCartoes().get(0));
		assertTrue(catao != null);
	}

	public void b_catao_should_be_get_an_catao() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		CartaoConsumacao cataoGeted = dao.retrivetbyId(catao.getCartaoId());
		assertTrue(cataoGeted.getSaldo() == catao.getSaldo());
	}

	public void c_catao_should_be_update_an_catao() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		CartaoConsumacao cataoGeted = dao.update(catao);
		assertTrue(cataoGeted.getSaldo() != catao.getSaldo());

	}

	public void d_catao_should_be_getAll_cataos() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		List<CartaoConsumacao> retrivetAll = dao.retrivetAll();
		assertTrue(retrivetAll.size() != 0);
	}

	public void e_catao_should_be_remove_an_catao() {
		Dao<CartaoConsumacao> dao = new Dao<>(CartaoConsumacao.class,
				new JPAUtil().getManager());
		boolean deleted = dao.delete(catao);
		assertTrue(deleted);
	}
}
