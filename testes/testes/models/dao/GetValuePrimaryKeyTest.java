package testes.models.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.model.Produto;
import org.model.dao.Dao;
import org.model.dao.GetValuePrimaryKey;
import org.model.util.JPAUtil;

public class GetValuePrimaryKeyTest {
	
	@Test
	public void should_get_primary_key_from_jpa_entity_by_notation_id() {	
		Dao<Produto> dao = new Dao<Produto>(Produto.class,new JPAUtil().getManager());
		Produto produto = dao.retrivetAll().get(0);
		Integer id = GetValuePrimaryKey.getID(produto);
		assertEquals(produto.getProdutoId(), id);
	}
}
