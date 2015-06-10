import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class AcademiaMain {
	private EntityManager em;

	public AcademiaMain() {
		em = new JPAUtil().getManager();
	}

	public static void main(String[] args) {
		AcademiaMain acm = new AcademiaMain();
		List<User> users = new ArrayList<>();

		users.add(new User("Pompeu", "123456", "11122233333", "Admin"));
		users.add(new User("Pompeu2", "1234356", "44422233332", "Admin2"));
		users.add(new User("Pompeu2", "1234356", "11155533331", "Admin3"));

				
		acm.salvar(users);
	}

	public void salvar(List<User> users) {

		em.getTransaction().begin();
		users.forEach(u -> em.persist(u));
		em.getTransaction().commit();
		em.close();
	}
}
