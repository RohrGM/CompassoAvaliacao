package programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("Programa");
	
	public static EntityManager getEntity() {		
		return FACTORY.createEntityManager();
	}

}
