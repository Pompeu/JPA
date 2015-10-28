package testes.models.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.model.Produto;
import org.model.dao.Dao;
import org.model.util.JPAUtil;

import testes.factorys.ModelFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest {

	Produto produto = null;

	@Test
	public void teste_all() {
		a_produto_should_be_save_new_produto();
		b_produto_should_be_get_an_produto();
		c_produto_should_be_update_an_produto();
		d_produto_should_be_getAll_produtos();
		e_produto_should_be_remove_an_produto();
	}

	public void a_produto_should_be_save_new_produto() {
		Dao<Produto> dao = new Dao<>(Produto.class, new JPAUtil().getManager());
		produto = dao.save(ModelFactory.criarProdutos().get(0));
		assertTrue(produto != null);
	}

	public void b_produto_should_be_get_an_produto() {
		Dao<Produto> dao = new Dao<>(Produto.class, new JPAUtil().getManager());
		Produto produtoGeted = dao.retrivetbyId(produto.getProdutoId());
		assertTrue(produtoGeted.getNome().equals(produto.getNome()));

	}

	public void c_produto_should_be_update_an_produto() {
		Dao<Produto> dao = new Dao<>(Produto.class, new JPAUtil().getManager());
		Produto produtoGeted = dao.save(produto);
		assertTrue(produtoGeted.equals(produto));
	}

	public void d_produto_should_be_getAll_produtos() {
		Dao<Produto> dao = new Dao<>(Produto.class, new JPAUtil().getManager());
		List<Produto> retrivetAll = dao.retrivetAll();
		assertTrue(retrivetAll.size() != 0);
	}

	public void e_produto_should_be_remove_an_produto() {
		Dao<Produto> dao = new Dao<>(Produto.class, new JPAUtil().getManager());
		boolean deleted = dao.delete(produto);
		assertTrue(deleted);
	}
}
