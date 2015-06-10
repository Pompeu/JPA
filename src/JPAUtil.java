import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private final EntityManagerFactory EMF = Persistence
			.createEntityManagerFactory("Jpa");

	public JPAUtil() {
	}

	public EntityManager getManager() {
		return EMF.createEntityManager();
	}
}
