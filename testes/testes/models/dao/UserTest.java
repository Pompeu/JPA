package testes.models.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.model.User;
import org.model.dao.Dao;
import org.model.util.JPAUtil;

import testes.factorys.ModelFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {

	User user = null;

	@Test
	public void teste_all() {
		a_user_should_be_save_new_user();
		b_user_should_be_get_an_user();
		c_user_should_be_update_an_user();
		d_user_should_be_getAll_users();
		e_user_should_be_remove_an_user();
	}

	public void a_user_should_be_save_new_user() {
		Dao<User> dao = new Dao<>(User.class, new JPAUtil().getManager());
		user = dao.save(ModelFactory.criarUsers().get(0));
		assertTrue(user != null);
	}

	public void b_user_should_be_get_an_user() {
		Dao<User> dao = new Dao<>(User.class, new JPAUtil().getManager());
		User userGeted = dao.retrivetbyId(user.getId());
		assertTrue(userGeted.getCpf().equals(user.getCpf()));
	}

	public void c_user_should_be_update_an_user() {
		Dao<User> dao = new Dao<>(User.class, new JPAUtil().getManager());
		User userGeted = dao.save(user);
		assertTrue(userGeted.getId() instanceof Integer);
	}

	public void d_user_should_be_getAll_users() {
		Dao<User> dao = new Dao<>(User.class, new JPAUtil().getManager());
		List<User> retrivetAll = dao.retrivetAll();
		assertTrue(retrivetAll.size() != 0);
	}

	public void e_user_should_be_remove_an_user() {
		Dao<User> dao = new Dao<>(User.class, new JPAUtil().getManager());
		boolean deleted = dao.delete(user);
		assertTrue(deleted);
	}
}
